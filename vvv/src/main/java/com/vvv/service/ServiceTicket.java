package com.vvv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvv.model.Pagamento;
import com.vvv.model.Ticket;
import com.vvv.repository.RepositoryTicket;


@Service
public class ServiceTicket {
	@Autowired
	private RepositoryTicket repositoryTicket;
	
	public Ticket save(Ticket ticket) {
		return repositoryTicket.save(ticket);
	}
	
	public Ticket findByFkPagamento(Pagamento pagamento) {
		return repositoryTicket.findByFkPagamento(pagamento);
	}
}