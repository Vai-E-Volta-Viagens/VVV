package com.vvv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vvv.model.Pagamento;
import com.vvv.model.Ticket;


public interface RepositoryTicket extends JpaRepository<Ticket, Long>{
	Ticket findByFkPagamento(Pagamento fkPagamento);
}

