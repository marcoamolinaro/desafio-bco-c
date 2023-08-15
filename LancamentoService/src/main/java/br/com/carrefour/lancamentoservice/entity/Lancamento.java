package br.com.carrefour.lancamentoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lancamentoId;
    @Column(name = "data_lancamento")
    private Instant dataLancamento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private double valor;
}
