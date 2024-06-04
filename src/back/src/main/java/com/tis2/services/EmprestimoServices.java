package com.tis2.services;

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

}
