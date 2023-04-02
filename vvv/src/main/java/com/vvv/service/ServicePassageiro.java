package com.vvv.service;

import com.vvv.model.Passageiro;
import com.vvv.repository.RepositoryPassageiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePassageiro {
	@Autowired
	private RepositoryPassageiro repositoryPassageiro;
	
	public Passageiro save(Passageiro passageiro) {		
		return repositoryPassageiro.save(passageiro);
	}
}
