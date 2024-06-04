package com.tis2.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NovoEmprestimoRequest {
    private Long usuarioId;
    private List<Long> livrosIds;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Long> getLivrosIds() {
        return livrosIds;
    }

    public void setLivrosIds(List<Long> livrosIds) {
        this.livrosIds = livrosIds;
    }
}
