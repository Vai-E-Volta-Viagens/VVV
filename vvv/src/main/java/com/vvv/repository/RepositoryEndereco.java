package com.vvv.repository;

import com.vvv.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface responsável por realizar a conexão com o banco de dados Endereco
public interface RepositoryEndereco extends JpaRepository<Endereco, Long>{
	Endereco findByIdEndereco(Long id);
}
