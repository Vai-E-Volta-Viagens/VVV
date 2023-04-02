package com.vvv.repository;

import com.vvv.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryLogin extends JpaRepository<Login, Long>{
	Login findByEmailLoginAndSenhaLogin(String email, String senha);
	
	Login findByEmailLogin(String email);
	Login findBySenhaLogin(String senha);
}
