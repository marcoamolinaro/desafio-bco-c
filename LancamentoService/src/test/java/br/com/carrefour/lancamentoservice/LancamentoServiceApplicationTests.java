package br.com.carrefour.lancamentoservice;

import br.com.carrefour.lancamentoservice.entity.Lancamento;
import br.com.carrefour.lancamentoservice.model.LancamentoResponse;
import br.com.carrefour.lancamentoservice.repository.LancamentoRepository;
import br.com.carrefour.lancamentoservice.service.LancamentoService;
import br.com.carrefour.lancamentoservice.service.LancamentoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class LancamentoServiceApplicationTests {

	@Mock
	private LancamentoRepository lancamentoRepository;

	@InjectMocks
	LancamentoService lancamentoService = new LancamentoServiceImpl();

	@DisplayName("Ler Lancamneto - Cenário de Sucesso ")
	@Test
	void test_When_Lancamento_Success() {

		Lancamento lancamento = getMockLancamento();

		when(lancamentoRepository.findById(anyLong()))
				.thenReturn(Optional.of(lancamento));

		LancamentoResponse lancamentoResponse = lancamentoService.lerLancamentoPorId(1);

		verify(lancamentoRepository, times(1)).findById(anyLong());

		assertNotNull(lancamentoResponse);
		assertEquals(lancamento.getLancamentoId(), lancamentoResponse.getLancamentoId());
	}

	private Lancamento getMockLancamento() {
		return Lancamento.builder()
				.lancamentoId(1L)
				.dataLancamento(Instant.now())
				.descricao("Laçamento 1 teste")
				.valor(200.00)
				.build();
	}
}
