package com.vvv.service;

import com.vvv.model.Estado;
import com.vvv.repository.RepositoryEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEstado {
	@Autowired
	private RepositoryEstado repositoryEstado;
	
	public Estado save(Estado estado) {
		return repositoryEstado.save(estado);
	}
}