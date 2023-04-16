package com.vvv.service;

import java.util.Optional;

import com.vvv.model.Cadastro;
import com.vvv.repository.RepositoryCadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	// Classe responsável pela conexão das classes Controller com o banco de dados Cadastro
public class ServiceCadastro {
	@Autowired
	private RepositoryCadastro repositoryCadastro;
	
	public Cadastro save(Cadastro cadastro) {
		return repositoryCadastro.save(cadastro);
	}
	
	public Optional<Cadastro> findById(Long id) {
		return repositoryCadastro.findById(id);
	}
}
