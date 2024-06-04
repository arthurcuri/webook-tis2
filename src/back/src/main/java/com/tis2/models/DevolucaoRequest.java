package com.tis2.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DevolucaoRequest {

    private LocalDate dataDevolucao;
    private String motivoTaxa;
    private BigDecimal taxaExtra;


    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getMotivoTaxa() {
        return this.motivoTaxa;
    }

    public void setMotivoTaxa(String motivoTaxa) {
        this.motivoTaxa = motivoTaxa;
    }

    public BigDecimal getTaxaExtra() {
        return this.taxaExtra;
    }

    public void setTaxaExtra(BigDecimal taxaExtra) {
        this.taxaExtra = taxaExtra;
    }

 
}
