package br.com.carrefour.lancamentoservice.repositories;

import br.com.carrefour.lancamentoservice.entities.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
