package com.tis2.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Usuario.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    public interface CriarUsuario {}
    public interface AtualizarUsuario {}

    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotBlank(groups = {CriarUsuario.class, AtualizarUsuario.class})
    @Column(name = "cpf", unique = true, nullable = false)
    private Long cpf;

    @NotBlank(groups = {CriarUsuario.class, AtualizarUsuario.class})
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(groups = {CriarUsuario.class, AtualizarUsuario.class})
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;


    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Livro> livro = new ArrayList<Livro>();


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Livro> getLivro() {
        return this.livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }


}
