const apiUrl = 'http://localhost:8080/emprestimo';

async function fetchLivrosDevolucao() {
    try {
        const response = await fetch(apiUrl);
        const data = await response.json();
        console.log('Dados recebidos da API:', data);

        const livrosTable = document.getElementById('livros-table');
        const tbody = livrosTable.getElementsByTagName('tbody')[0];
        tbody.innerHTML = '';

        for (const emprestimo of data) {
            if (emprestimo.dataDevolucao) {
                const livroDanificado = emprestimo.motivoTaxa && emprestimo.taxaExtra;
                const newRow = document.createElement('tr');
                newRow.innerHTML = `
                            <td>${emprestimo.id}</td>
                            <td>${emprestimo.dataEmprestimo.join('/')}</td>
                            <td>${emprestimo.dataDevolucao.join('/')}</td>
                            <td>Livro Devolvido</td>
                            <td>${livroDanificado ? 'Livro devolvido danificado' : 'Livro em bom estado'}</td>
                            <td>${emprestimo.valorEmprestimo}</td> <!-- Nova coluna para o valor do empréstimo -->
                        `;
                tbody.appendChild(newRow);
            }
        }

        if (tbody.innerHTML === '') {
            console.log('Nenhum livro devolvido encontrado.');
        }
    } catch (error) {
        console.error('Erro ao buscar livros:', error);
    }
}

window.onload = fetchLivrosDevolucao;