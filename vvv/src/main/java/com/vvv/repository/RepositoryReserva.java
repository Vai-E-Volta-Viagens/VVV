package com.vvv.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import com.vvv.model.Reserva;
import com.vvv.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface RepositoryReserva extends JpaRepository<Reserva, Long>{
	Optional<Reserva> findById(Long id);
		
	ArrayList<Reserva> findByFkViagem(Viagem viagem);
	
	Optional<Reserva> findByCodReserva(Long codReserva);
	
	@Query("UPDATE Reserva e SET e.posicaoPoltrona = :set WHERE e.idReserva = :id")
	@Modifying
	@Transactional
	void updatePosicaoPoltronaByIdReserva(Long id, Set<String> set);
}