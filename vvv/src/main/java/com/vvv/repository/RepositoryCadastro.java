package com.vvv.repository;

import com.vvv.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface responsável por realizar a conexão com o banco de dados Cadastro
public interface RepositoryCadastro extends JpaRepository<Cadastro, Long>{
	
}
