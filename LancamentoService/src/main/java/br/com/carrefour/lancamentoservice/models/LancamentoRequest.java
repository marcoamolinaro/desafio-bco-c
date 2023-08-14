package br.com.carrefour.lancamentoservice.models;

import lombok.Data;

@Data
public class LancamentoRequest {
    private String descricao;
    private double valor;
}
