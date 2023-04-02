package com.vvv.service;

import com.vvv.model.Endereco;
import com.vvv.repository.RepositoryEndereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEndereco {
	@Autowired
	private RepositoryEndereco repositoryEndereco;
	
	public Endereco save(Endereco endereco) {
		return repositoryEndereco.save(endereco);
	}
}
