package com.vvv.repository;

import java.util.ArrayList;
import java.util.Optional;
import com.vvv.model.Reserva;
import com.vvv.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryReserva extends JpaRepository<Reserva, Long>{
	Optional<Reserva> findById(Long id);
	
	ArrayList<Reserva> findByViagem(Viagem viagem);
	
	Optional<Reserva> findByCodReserva(Long codReserva);
}
