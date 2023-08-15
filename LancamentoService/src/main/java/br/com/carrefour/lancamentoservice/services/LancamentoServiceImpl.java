package br.com.carrefour.lancamentoservice.services;

import br.com.carrefour.lancamentoservice.entities.Lancamento;
import br.com.carrefour.lancamentoservice.exceptions.LancamentoServiceCustomException;
import br.com.carrefour.lancamentoservice.models.LancamentoRequest;
import br.com.carrefour.lancamentoservice.models.LancamentoResponse;
import br.com.carrefour.lancamentoservice.repositories.LancamentoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class LancamentoServiceImpl implements LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Override
    public long adicionarLancamento(LancamentoRequest lancamentoRequest) {
        log.info("Adicionando Lançamento");

        Lancamento lancamento =
                Lancamento.builder()
                        .descricao(lancamentoRequest.getDescricao())
                        .valor(lancamentoRequest.getValor())
                        .build();
        lancamentoRepository.save(lancamento);

        log.info("Lançamento adicionado");

        return lancamento.getLancamentoId();
    }

    @Override
    public LancamentoResponse lerLancamentoPorId(long lancamentoId) {
        log.info("Lendo lançamento para o id {}", lancamentoId);

        Lancamento lancamento = lancamentoRepository.findById(lancamentoId)
                .orElseThrow(() -> new LancamentoServiceCustomException("Lançamento com id " + lancamentoId + " não encontrado", "LANÇAMENTO_NÃO_ENCONTRADO"));

        LancamentoResponse lancamentoResponse = new LancamentoResponse();

        copyProperties(lancamento, lancamentoResponse);

        return lancamentoResponse;
    }

    @Override
    public void alterarLancamentoPorId(long lancamentoId, LancamentoRequest lancamentoRequest) {
        log.info("Lendo lançamento para o id {}", lancamentoId);

        Lancamento lancamento = lancamentoRepository.findById(lancamentoId)
                .orElseThrow(() -> new LancamentoServiceCustomException("Lançamento com id " + lancamentoId + " não encontrado", "LANÇAMENTO_NÃO_ENCONTRADO"));

        copyProperties(lancamentoRequest, lancamento);

        lancamentoRepository.save(lancamento);

        log.info("Lançamento com id {} alterado", lancamentoId);
    }
}
