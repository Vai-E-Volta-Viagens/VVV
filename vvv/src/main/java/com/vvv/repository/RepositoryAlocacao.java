package com.vvv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vvv.model.Alocacao;
import com.vvv.model.Pagamento;


public interface RepositoryAlocacao extends JpaRepository<Alocacao, Long>{
	Alocacao findByFkPagamento(Pagamento pagamento);
}