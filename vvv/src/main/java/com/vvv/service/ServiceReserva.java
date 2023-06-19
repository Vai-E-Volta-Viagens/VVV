package com.vvv.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import com.vvv.model.Reserva;
import com.vvv.model.Viagem;
import com.vvv.repository.RepositoryReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceReserva {
	@Autowired
	private RepositoryReserva repositoryReserva;
	
	public void save(Reserva reserva) {
		repositoryReserva.save(reserva);
	}
	
	public Optional<Reserva> findById(Long id){
		return repositoryReserva.findById(id);
	}
	
	public ArrayList<Reserva> findByFkViagem(Viagem viagem) {
		return repositoryReserva.findByFkViagem(viagem);
	}
	
	public Optional<Reserva> findByCodReserva(Long codReserva){
		return repositoryReserva.findByCodReserva(codReserva);
	}
	
	public void updatePosicaoPoltronaByIdReserva(Long id, Set<String> set) {
		repositoryReserva.updatePosicaoPoltronaByIdReserva(id, set);
	}
}
