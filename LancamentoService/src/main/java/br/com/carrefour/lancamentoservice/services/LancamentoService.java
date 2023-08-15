package br.com.carrefour.lancamentoservice.services;

import br.com.carrefour.lancamentoservice.models.LancamentoRequest;
import br.com.carrefour.lancamentoservice.models.LancamentoResponse;

public interface LancamentoService {
    long adicionarLancamento(LancamentoRequest lancamentoRequest);

    LancamentoResponse lerLancamentoPorId(long lancamentoId);

    void alterarLancamentoPorId(long lancamentoId, LancamentoRequest lancamentoRequest);
}
