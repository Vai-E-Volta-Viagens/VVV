package com.vvv.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_viagem")
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_viagem", unique = true)
	private Long idViagem;
	
	@Column(name = "cidade_origem", nullable = false)
	private String cidadeOrigem;
	
	@Column(name = "cidade_destino", nullable = false)
	private String cidadeDestino;
	
	@Column(name = "escala")
	private ArrayList<String> escala;
	
	@Column(name = "contem_escala")
	private Boolean contemEscala;
	
	@Column(name = "ida_e_volta", nullable = true)
	private Boolean idaVolta;
	
	@Column(name = "tempo_viagem", nullable = true)
	private Integer tempoViagem;
	
	@Column(name = "hora_partida", nullable = false)
	private LocalTime horaPartida;
	
	@Column(name = "hora_chegada", nullable = false)
	private LocalTime horaChegada;
	
	@Column(name = "data_partida", nullable = false)
	private LocalDate dataPartida;
	
	@Column(name = "data_volta", nullable = false)
	private LocalDate dataVolta;
	
	@Column(name = "data_chegada")
	private LocalDate dataChegada;
	
	
	public Viagem() {}
	public Viagem(Long idViagem, String cidadeOrigem, String cidadeDestino, ArrayList<String> escala,
			Boolean contemEscala, Boolean idaVolta, Integer tempoViagem, LocalTime horaPartida, LocalTime horaChegada,
			LocalDate dataPartida, LocalDate dataVolta, LocalDate dataChegada) {
		this.idViagem = idViagem;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.escala = escala;
		this.contemEscala = contemEscala;
		this.idaVolta = idaVolta;
		this.tempoViagem = tempoViagem;
		this.horaPartida = horaPartida;
		this.horaChegada = horaChegada;
		this.dataPartida = dataPartida;
		this.dataVolta = dataVolta;
		this.dataChegada = dataChegada;
	}
}
