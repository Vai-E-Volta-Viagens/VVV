package com.vvv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "tb_reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva", unique = true)
	private Long idReserva;
	
	@ManyToOne
	@JoinColumn(name = "fk_viagem")
	private Viagem viagem;
	
	@ManyToOne
	@JoinColumn(name = "fk_embarque")
	private Embarque embarque;
	
	@Column(name = "cod_reserva", unique = true)
	private Long codReserva;

	@Column(name = "valor_reserva", nullable = false, length=1000000)
	private Float valorReserva;
	
	@Column(name = "reservaAerea", nullable = false)
	private Boolean reservaAerea;
	
	// Ficará para ser selecionada depois
	@Column(name = "posicao_poltrona", unique = true)
	private Integer posicaoPoltrona;
	
	
	public Reserva() {}
	public Reserva(Long idReserva, Viagem viagem, Embarque embarque, Long codReserva, Float valorReserva,
			Boolean reservaAerea, Integer posicaoPoltrona) {
		this.idReserva = idReserva;
		this.viagem = viagem;
		this.embarque = embarque;
		this.codReserva = codReserva;
		this.valorReserva = valorReserva;
		this.reservaAerea = reservaAerea;
		this.posicaoPoltrona = posicaoPoltrona;
	}	
}