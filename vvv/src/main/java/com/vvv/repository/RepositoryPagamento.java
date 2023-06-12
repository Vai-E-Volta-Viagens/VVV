package com.vvv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vvv.model.Pagamento;

public interface RepositoryPagamento extends JpaRepository<Pagamento, Long>{
	 
}