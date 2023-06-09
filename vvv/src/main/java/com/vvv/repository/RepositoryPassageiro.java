package com.vvv.repository;

import java.util.Optional;

import com.vvv.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface responsável por realizar a conexão com o banco de dados Passageiro
public interface RepositoryPassageiro extends JpaRepository<Passageiro, Long>{
	Passageiro findByEmailPassageiroAndSenhaPassageiro(String email, String senha);
	
	Passageiro findByEmailPassageiro(String email);
	Passageiro findBySenhaPassageiro(String senha);
	
	Optional<Passageiro> findById(Long id);
}
