package com.vvv.repository;

import com.vvv.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface responsável por realizar a conexão com o banco de dados Passageiro
public interface RepositoryPassageiro extends JpaRepository<Passageiro, Long>{

}
