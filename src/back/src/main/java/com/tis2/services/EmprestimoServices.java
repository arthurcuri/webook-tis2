package com.tis2.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tis2.models.Emprestimo;
import com.tis2.models.Livro;
import com.tis2.repositories.EmprestimoRepository;
import com.tis2.repositories.LivroRepository;

import jakarta.transaction.Transactional;

@Service
public class EmprestimoServices {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public List<Emprestimo> findAllByUserId(Long userId) {
        return emprestimoRepository.findByUsuario_Id(userId);
    }

    public Emprestimo buscarPeloId(Long Id) {
        return emprestimoRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException(
                        "Emprestimo não encontrado para o ID: " + Id));
    }

    @Transactional
    public Emprestimo create(Emprestimo obj) {
        obj.setId(null); 
        return emprestimoRepository.save(obj);
    }

    @Transactional
    public Emprestimo update(Emprestimo obj) {
        buscarPeloId(obj.getId());
        return emprestimoRepository.save(obj);
    }

    public void delete(Long Id) {
        Emprestimo emprestimo = buscarPeloId(Id); 
        emprestimoRepository.delete(emprestimo);
    }

    @Transactional
public void devolverEmprestimo(Long emprestimoId) {
    Emprestimo emprestimo = buscarPeloId(emprestimoId); 

    if (emprestimo.getDataDevolucao() != null) {
        throw new RuntimeException("O empréstimo já foi devolvido.");
    }

    List<Livro> livros = emprestimo.getLivros();
    for (Livro livro : livros) {
        livro.setDisponivel(true);
        livroRepository.save(livro);
    }
}

public double calcularPercentualDevolucoesAtrasadas() {
    List<Emprestimo> emprestimos = emprestimoRepository.findAll();
    long totalDevolucoes = emprestimos.stream().filter(e -> e.getDataDevolucao() != null).count();
    long totalDevolucoesAtrasadas = emprestimos.stream()
        .filter(e -> e.getDataDevolucao() != null && e.getDataDevolucao().isAfter(e.getDataEmprestimo().plusDays(7)))
        .count();

    if (totalDevolucoes == 0) {
        return 0.0; 
    }

    return ((double) totalDevolucoesAtrasadas / totalDevolucoes) * 100;
}

  public double calcularTaxaEmprestimosNoPrazo(List<Emprestimo> emprestimos) {
        long emprestimosNoPrazo = emprestimos.stream()
                .filter(this::estaDentroDoPrazo)
                .count();
        long totalEmprestimos = emprestimos.size();
        
        if (totalEmprestimos == 0) {
            return 0.0;
        }
        
        return ((double) emprestimosNoPrazo / totalEmprestimos) * 100;
    }

    private boolean estaDentroDoPrazo(Emprestimo emprestimo) {
        LocalDate dataDevolucao = emprestimo.getDataDevolucao();
        LocalDate dataPrevistaDevolucao = emprestimo.getDataEmprestimo().plusDays(7); 
        
        return dataDevolucao != null && !dataDevolucao.isAfter(dataPrevistaDevolucao);
    }

}

