package com.vvv.service;

import com.vvv.model.Login;
import com.vvv.repository.RepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service	// Classe responsável pela conexão das classes Controller com o banco de dados Login
public class ServiceLogin {
	@Autowired
	private RepositoryLogin repositoryLogin;
	
	public Login save(Login login) {
		return repositoryLogin.save(login);
	}
	
	public Login findByEmailLoginAndSenhaLogin(String email, String senha) {
		return repositoryLogin.findByEmailLoginAndSenhaLogin(email, senha);
	}
	
	public Login findByEmailLogin(String email) {
		return repositoryLogin.findByEmailLogin(email);
	}
	
	public Login findBySenhaLogin(String senha) {
		return repositoryLogin.findBySenhaLogin(senha);
	}
}
