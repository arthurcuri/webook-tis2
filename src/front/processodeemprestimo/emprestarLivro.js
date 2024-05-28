async function emprestarLivro() {
    const id = document.getElementById('id').value;
    const titulo = document.getElementById('titulo').value;
    const autor = document.getElementById('autor').value;
    const isbn = document.getElementById('isbn').value;
    const editora = document.getElementById('editora').value;
    const secao = document.getElementById('secao').value;
    const preco = document.getElementById('preco').value;

    const usuarioId = document.getElementById('usuarioId').value;
    const dataEmprestimo = document.getElementById('dataEmprestimo').value;
    const diasEmprestados = document.getElementById('diasEmprestados').value;

    if (!titulo || !autor || !isbn || !editora || !secao || !preco || !usuarioId || !dataEmprestimo || !diasEmprestados) {
        alert("Todos os campos devem ser preenchidos.");
        return;
    }

    if (isNaN(isbn) || isNaN(diasEmprestados)) {
        alert('ISBN e Dias Emprestados devem conter apenas números');
        return;
    }

    const livroEditado = {
        id: id,
        tituloLivro: titulo,
        autor: autor,
        isbn: isbn,
        editora: editora,
        secao: secao,
        preco: preco,
        usuario: { id: usuarioId },
        dataEmprestimo: dataEmprestimo,
        diasEmprestado: parseInt(diasEmprestados, 10)
    };

    const requestOptions = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(livroEditado)
    };

    try {
        const response = await fetch(`http://localhost:8080/livro/${id}`, requestOptions);
        if (!response.ok) {
            throw new Error('Erro ao emprestar livro');
        }
        console.log('Livro emprestado com sucesso');
        alert('Livro emprestado com sucesso');
        window.location.href = "/webook/src/front/gerenciamentodelivros/Iniciargerenciamento.html";
    } catch (error) {
        console.error('Erro ao emprestar livro:', error);
        alert('Erro ao emprestar livro');
    }
}

async function preencherCampos(id) {
    try {
        const response = await fetch(`http://localhost:8080/livro/${id}`);
        const livro = await response.json();

        document.getElementById('id').value = livro.id;
        document.getElementById('titulo').value = livro.tituloLivro;
        document.getElementById('autor').value = livro.autor;
        document.getElementById('isbn').value = livro.isbn;
        document.getElementById('editora').value = livro.editora;
        document.getElementById('secao').value = livro.secao;
        document.getElementById('preco').value = livro.preco;
    } catch (error) {
        console.error('Erro ao buscar livro:', error);
    }
}

window.onload = function() {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    if (id) {
        preencherCampos(id);
    }
};
