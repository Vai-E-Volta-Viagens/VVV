package com.vvv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vvv.model.Proprietaria;
import com.vvv.repository.RepositoryProprietaria;


@Service
public class ServiceProprietaria {
	@Autowired
	private RepositoryProprietaria repositoryProprietaria;
	
	public Proprietaria save(Proprietaria proprietaria) {
		return repositoryProprietaria.save(proprietaria);
	}
}

