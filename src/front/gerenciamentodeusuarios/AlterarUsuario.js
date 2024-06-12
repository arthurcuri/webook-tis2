async function editarUsuario() {
    const id = document.getElementById('id').value;
    const nome = document.getElementById('nome').value;
    const cpf = document.getElementById('cpf').value;
    const dataNascimento = document.getElementById('data').value;

    if (!nome || !cpf || !dataNascimento) {
        alert("Todos os campos devem ser preenchidos.");
        return;
    }

    if (isNaN(cpf)) {
        alert('CPF deve conter apenas números');
        return;
    }

    const usuarioEditado = {
        id: id,
        nome: nome,
        cpf: cpf,
        dataNascimento: dataNascimento
    };

    const requestOptions = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuarioEditado)
    };

    try {
        const response = await fetch(`http://localhost:8080/usuario/${id}`, requestOptions);
        if (!response.ok) {
            throw new Error('Erro ao editar usuário');
        }
        console.log('Usuário editado com sucesso');
        alert('Usuário editado com sucesso');
        window.location.href = "/webook/src/front/gerenciamentodeusuarios/Gerenciamento.html";
    } catch (error) {
        console.error('Erro ao editar usuário:', error);
        alert('Erro ao editar usuário');
    }
}


async function preencherCampos(id) {
    try {
        const response = await fetch(`http://localhost:8080/usuario/${id}`);
        const usuario = await response.json();

        document.getElementById('id').value = usuario.id;
        document.getElementById('nome').value = usuario.nome;
        document.getElementById('cpf').value = usuario.cpf;
        document.getElementById('data').value = usuario.dataNascimento;
    } catch (error) {
        console.error('Erro ao buscar usuário:', error);
    }
}

window.onload = function () {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    if (id) {
        preencherCampos(id);
    }
};