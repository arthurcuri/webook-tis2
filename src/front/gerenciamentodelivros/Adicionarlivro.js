function cadastrar() {
    const titulo = document.getElementById('titulo').value;
    const autor = document.getElementById('autor').value;
    const isbn = document.getElementById('isbn').value;
    const editora = document.getElementById('editora').value;
    const secao = document.getElementById('secao').value;
    const preco = document.getElementById('preco').value;
    const disponivel = 1;

    if (!titulo || !autor || !isbn || !editora || !secao || !preco) {
        alert("Todos os campos devem ser preenchidos.");
        return;
    }
    if (isNaN(isbn)){
       alert('ISBN deve conter apenas numeros');
      return;
    }

    const novoLivro = {
        tituloLivro: titulo,
        autor: autor,
        isbn: isbn,
        editora: editora,
        secao: secao,
        preco: preco,
        disponivel: disponivel 
    };

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(novoLivro)
    };

    fetch("http://localhost:8080/livro", requestOptions)
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar livro');
            }
            document.getElementById('mensagem').style.display = "block"; 
            document.getElementById('mensagem').style.display = "block"; // Exibe a mensagem de sucesso
            console.log('Livro cadastrado com sucesso!'); // Exibe mensagem no console
            setTimeout(() => {
                console.log('Redirecionando para a tela inicial...');
                window.location.href = "/webook/src/front/gerenciamentodelivros/Iniciargerenciamento.html"; // Redireciona para a página principal após 2 segundos
            }, 2000); // 2000 milissegundos = 2 segundos
            return response.json();
        })
        .catch(error => {
            console.error('Erro ao cadastrar livro:', error);
        });
}