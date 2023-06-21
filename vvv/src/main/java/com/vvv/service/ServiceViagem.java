package com.vvv.service;

import java.time.LocalDate;
import java.util.Optional;
import com.vvv.model.Viagem;
import com.vvv.repository.RepositoryViagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceViagem {
	@Autowired
	private RepositoryViagem repositoryViagem;
	
	public Optional<Viagem> findById(Long id){
		return repositoryViagem.findById(id);
	}
	
	public Viagem findAllByCidadeOrigemAndCidadeDestinoAndDataPartidaAndDataVolta(String cidadeOrigem, String cidadeDestino, LocalDate dataPartida, LocalDate dataVolta) {
		return repositoryViagem.findAllByCidadeOrigemAndCidadeDestinoAndDataPartidaAndDataVolta(cidadeOrigem, cidadeDestino, dataPartida, dataVolta);
	}
}