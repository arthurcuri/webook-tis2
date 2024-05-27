async function emprestarLivro() {
    const id = document.getElementById('id').value;
    const titulo = document.getElementById('titulo').value;
    const autor = document.getElementById('autor').value;
    const isbn = document.getElementById('isbn').value;
    const editora = document.getElementById('editora').value;
    const secao = document.getElementById('secao').value;
    const preco = document.getElementById('preco').value;

    if (!titulo || !autor || !isbn || !editora || !secao || !preco) {
        alert("Todos os campos devem ser preenchidos.");
        return;
    }

    if (isNaN(isbn)) {
        alert('ISBN deve conter apenas números');
        return;
    }

    const livroEditado = {
        id: id,
        tituloLivro: titulo,
        autor: autor,
        isbn: isbn,
        editora: editora,
        secao: secao,
        preco: preco
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
            throw new Error('Erro ao editar livro');
        }
        console.log('Livro editado com sucesso');
        alert('Livro editado com sucesso');
        window.location.href = "/webook/src/front/processodeemprestimo/clienteInicial.js";
    } catch (error) {
        console.error('Erro ao editar livro:', error);
        alert('Erro ao editar livro');
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
        console.error('Erro ao buscar livro:',   error);
    }
}

window.onload = function() {
const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');
if (id) {
    preencherCampos(id);
}
};