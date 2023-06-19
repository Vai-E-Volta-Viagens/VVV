package com.vvv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vvv.model.Cartao;

public interface RepositoryCartao extends JpaRepository<Cartao, Long>{
	Optional<Cartao> findByIdCartao(Long idCartao);
}