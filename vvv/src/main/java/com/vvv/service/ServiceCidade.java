package com.vvv.service;

import com.vvv.model.Cidade;
import com.vvv.repository.RepositoryCidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCidade {
	@Autowired
	private RepositoryCidade repositoryCidade;
	
	public Cidade save(Cidade cidade) {
		return repositoryCidade.save(cidade);
	}
}