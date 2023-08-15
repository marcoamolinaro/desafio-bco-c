package br.com.carrefour.lancamentoservice.repository;

import br.com.carrefour.lancamentoservice.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
