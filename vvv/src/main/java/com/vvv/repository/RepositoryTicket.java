package com.vvv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.vvv.model.Pagamento;
import com.vvv.model.Ticket;


public interface RepositoryTicket extends JpaRepository<Ticket, Long>{
	Ticket findByFkPagamento(Pagamento fkPagamento);
}

