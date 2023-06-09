package com.vvv.repository;

import java.time.LocalDate;
import java.util.Optional;
import com.vvv.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryViagem extends JpaRepository<Viagem, Long>{
	Optional<Viagem> findById(Long id);
	
	Viagem findAllByCidadeOrigemAndCidadeDestinoAndDataPartidaAndDataVolta(String cidadeOrigem, String cidadeDestino, LocalDate dataPartida, LocalDate dataVolta);
}
