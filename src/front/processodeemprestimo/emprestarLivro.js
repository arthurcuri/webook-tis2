async function emprestarLivro() {
    const id = document.getElementById('id').value;
    const usuarioId = document.getElementById('usuarioId').value;
    let dataEmprestimo = document.getElementById('dataEmprestimo').value;
    const diasEmprestados = document.getElementById('diasEmprestados').value;

    if (!id || !usuarioId || !dataEmprestimo || !diasEmprestados) {
        alert("Todos os campos devem ser preenchidos.");
        return;
    }

    dataEmprestimo = new Date(dataEmprestimo).toISOString().split('T')[0];

    const emprestimo = {
        usuarioId: usuarioId,
        livrosIds: [id],
        dataEmprestimo: dataEmprestimo,
        diasEmprestados: parseInt(diasEmprestados, 10)
    };

    console.log('Dados enviados para o servidor:', emprestimo);

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(emprestimo)
    };

    try {
        console.log('Enviando requisição para o servidor...');
        const response = await fetch('http://localhost:8080/emprestimo/novo', requestOptions);
        console.log('Resposta do servidor recebida.');
        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(`Erro ao emprestar livro: ${errorMessage}`);
        }
        console.log('Empréstimo criado com sucesso');
        alert('Livro emprestado com sucesso');
        window.location.href = "/webook/src/front/Main.html";
    } catch (error) {
        console.error('Erro ao emprestar livro:', error);
        alert(`Erro ao emprestar livro: ${error.message}`);
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

async function listarUsuarios() {
    try {
        console.log('Buscando usuários...');
        const response = await fetch('http://localhost:8080/usuario');
        const usuarios = await response.json();
        console.log('Usuários recebidos:', usuarios);

        const usuarioSelect = document.getElementById('usuarioId');
        usuarios.forEach(usuario => {
            const option = document.createElement('option');
            option.value = usuario.id;
            option.textContent = `${usuario.id} - ${usuario.nome} (CPF: ${usuario.cpf}, Nascimento: ${usuario.dataNascimento})`;
            usuarioSelect.appendChild(option);
        });
    } catch (error) {
        console.error('Erro ao buscar usuários:', error);
        alert('Erro ao buscar usuários');
    }
}

window.onload = function () {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    if (id) {
        preencherCampos(id);
    }
    listarUsuarios();

    const dataAtual = new Date().toISOString().split('T')[0];
    document.getElementById('dataEmprestimo').value = dataAtual;

    document.getElementById('diasEmprestados').value = 7;
    document.getElementById('diasEmprestados').setAttribute('readonly', 'readonly');
};