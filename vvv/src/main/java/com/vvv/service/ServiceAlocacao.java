package com.vvv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vvv.model.Alocacao;
import com.vvv.model.Pagamento;
import com.vvv.repository.RepositoryAlocacao;


@Service
public class ServiceAlocacao {
	@Autowired
	private RepositoryAlocacao repositoryAlocacao;
	
	public Alocacao save(Alocacao alocacao) {
		return repositoryAlocacao.save(alocacao);
	}
	
	public Alocacao findByFkAlocacao(Pagamento pagamento) {
		return repositoryAlocacao.findByFkPagamento(pagamento);
	}
}
