package com.vvv.service;

import java.util.Optional;

import com.vvv.model.Passageiro;
import com.vvv.repository.RepositoryPassageiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	// Classe responsável pela conexão das classes Controller com o banco de dados Passageiro
public class ServicePassageiro {
	@Autowired
	private RepositoryPassageiro repositoryPassageiro;
	
	public Passageiro save(Passageiro passageiro) {		
		return repositoryPassageiro.save(passageiro);
	}
	
	public Passageiro findByEmailPassageiroAndSenhaPassageiro(String email, String senha) {
		return repositoryPassageiro.findByEmailPassageiroAndSenhaPassageiro(email, senha);
	}
	
	public Passageiro findByEmailPassageiro(String email) {
		return repositoryPassageiro.findByEmailPassageiro(email);
	}
	
	public Passageiro findBySenhaPassageiro(String senha) {
		return repositoryPassageiro.findBySenhaPassageiro(senha);
	}
	
	public Optional<Passageiro> findById(Long id){
		return repositoryPassageiro.findById(id);
	}
}
