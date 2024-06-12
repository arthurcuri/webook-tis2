function cadastrar() {
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

    const novoUsuario = {
        nome: nome,
        cpf: cpf,
        dataNascimento: dataNascimento
    };

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(novoUsuario)
    };

    fetch("http://localhost:8080/usuario", requestOptions)
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar usuário');
            }
            document.getElementById('mensagem').style.display = "block"; // Exibe a mensagem de sucesso
            setTimeout(() => {
                window.location.href = "/webook/src/front/gerenciamentodeusuarios/Gerenciamento.html"; // Redireciona para a página principal após 2 segundos
            }, 2000); // 2000 milissegundos = 2 segundos
            return response.json();
        })
        .catch(error => {
            console.error('Erro ao cadastrar usuário:', error);
        });
}