package br.com.carrefour.lancamentoservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lancamentoId;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private double valor;
}
