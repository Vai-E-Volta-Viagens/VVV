package com.vvv.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva", unique = true)
	private Long idReserva;
	
	@ManyToOne
	@JoinColumn(name = "fk_viagem")
	private Viagem fkViagem;
	
	@ManyToOne
	@JoinColumn(name = "fk_embarque")
	private Embarque fkEmbarque;
	
	@OneToOne
	@JoinColumn(name = "fk_alocacao")
	private Alocacao fkAlocacao;
	
	@OneToMany(mappedBy = "fkReserva")
	private List<PreCadastrado> preCadastrado;
	
	@Column(name = "cod_reserva", unique = true)
	private Long codReserva;

	@Column(name = "valor_reserva", nullable = false, length=1000000)
	private Float valorReserva;
	
	@Column(name = "reservaAerea", nullable = false)
	private Boolean reservaAerea;
	
	@Column(name = "posicao_poltrona", nullable = true)
	private ArrayList<String> posicaoPoltrona;
}