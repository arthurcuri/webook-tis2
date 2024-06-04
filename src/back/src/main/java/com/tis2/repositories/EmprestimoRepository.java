package com.tis2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tis2.models.Emprestimo;


@Repository
public interface EmprestimoRepository extends JpaRepository <Emprestimo, Long> {

    List<Emprestimo> findByUsuario_Id(Long id);

}
