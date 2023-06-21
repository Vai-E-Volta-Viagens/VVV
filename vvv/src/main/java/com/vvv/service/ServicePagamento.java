package com.vvv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvv.model.Pagamento;
import com.vvv.repository.RepositoryPagamento;


@Service
public class ServicePagamento {
	@Autowired
	private RepositoryPagamento repositoryPagamento;
	
	public void save(Pagamento pagamento) {
		repositoryPagamento.save(pagamento);
	}
}
