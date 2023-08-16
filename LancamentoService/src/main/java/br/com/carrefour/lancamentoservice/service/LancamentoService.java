package br.com.carrefour.lancamentoservice.service;

import br.com.carrefour.lancamentoservice.entity.Lancamento;
import br.com.carrefour.lancamentoservice.model.LancamentoRequest;
import br.com.carrefour.lancamentoservice.model.LancamentoResponse;

import java.util.List;

public interface LancamentoService {
    long adicionarLancamento(LancamentoRequest lancamentoRequest);

    LancamentoResponse lerLancamentoPorId(long lancamentoId);

    void alterarLancamentoPorId(long lancamentoId, LancamentoRequest lancamentoRequest);

    void deletarLancamentoPorId(long lancamentoId);

    List<LancamentoResponse> lerTodosLancamentos();
}
