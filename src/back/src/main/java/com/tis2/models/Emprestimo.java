package com.tis2.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Emprestimo.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo { 
    public interface CriarEmprestimo {}
    public interface AtualizarEmprestimo {}

    public static final String TABLE_NAME = "emprestimo";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Id;

    @NotBlank(groups = {CriarEmprestimo.class, AtualizarEmprestimo.class})
    @Column(name = "dataEmprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @NotBlank(groups = {CriarEmprestimo.class, AtualizarEmprestimo.class})
    @Column(name = "dataDevolucao", nullable = true)
    private LocalDate dataDevolucao;

    @Column(name = "quantidadeLivros", nullable = false)
    private int quantidadeLivros;

    @NotBlank(groups = {CriarEmprestimo.class, AtualizarEmprestimo.class})
    @Column(name = "valorMulta", nullable = true)
    private BigDecimal valorMulta;

    @NotBlank(groups = {CriarEmprestimo.class, AtualizarEmprestimo.class})
    @Column(name = "taxaExtra", nullable = true)
    private BigDecimal taxaExtra;

    @NotBlank(groups = {CriarEmprestimo.class, AtualizarEmprestimo.class})
    @Column(name = "motivoTaxa", nullable = true)
    private String motivoTaxa;

    @NotBlank(groups = {CriarEmprestimo.class, AtualizarEmprestimo.class})
    @Column(name = "valorEmprestimo", nullable = true)
    private BigDecimal valorEmprestimo;

    @ManyToOne
    @JoinColumn(name ="usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
        name = "emprestimo_livro",
        joinColumns = @JoinColumn(name = "emprestimo_id"),
        inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    @JsonIgnore
    private List<Livro> livros;

    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getQuantidadeLivros() {
        return this.quantidadeLivros;
    }

    public void setQuantidadeLivros(int quantidadeLivros) {
        this.quantidadeLivros = quantidadeLivros;
    }

    public BigDecimal getValorMulta() {
        return this.valorMulta;
    }

    public void setValorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
    }

    public BigDecimal getTaxaExtra() {
        return this.taxaExtra;
    }

    public void setTaxaExtra(BigDecimal taxaExtra) {
        this.taxaExtra = taxaExtra;
    }

    public String getMotivoTaxa() {
        return this.motivoTaxa;
    }

    public void setMotivoTaxa(String motivoTaxa) {
        this.motivoTaxa = motivoTaxa;
    }

    public BigDecimal getValorEmprestimo() {
        return this.valorEmprestimo;
    }

    public void setValorEmprestimo(BigDecimal valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
        this.quantidadeLivros = livros != null ? livros.size() : 0;
    }

    public long calcularDiasAtraso() {
        if (dataDevolucao != null) {
            long dias = ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
            return dias > 7 ? dias - 7 : 0;
        }
        return 0;
    }

    public BigDecimal calcularMulta() {
        long diasAtraso = calcularDiasAtraso();
        if (diasAtraso > 0) {
            return BigDecimal.valueOf(diasAtraso * 10);
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal calcularPrecoTotal() {
        BigDecimal precoLivros = livros.stream()
            .map(Livro::getPreco)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        BigDecimal multa = calcularMulta();
        BigDecimal precoTotal = precoLivros.add(multa).add(taxaExtra != null ? taxaExtra : BigDecimal.ZERO);
        this.valorEmprestimo = precoTotal;
        return precoTotal;
    }
}


