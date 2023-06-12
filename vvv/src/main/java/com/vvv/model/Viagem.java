package com.vvv.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "tb_viagem")
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_viagem", unique = true)
	private Long idViagem;
	
	@OneToMany(mappedBy = "fkViagem")
	private List<Reserva> reserva;
	
	@Column(name = "cidade_origem", nullable = false) //
	private String cidadeOrigem;
	
	@Column(name = "cidade_destino", nullable = false)//
	private String cidadeDestino;
	
	@Column(name = "escala")
	private ArrayList<String> escala;//
	
	@Column(name = "contem_escala")
	private Boolean contemEscala;
	
	@Column(name = "ida_e_volta", nullable = true)
	private Boolean idaVolta;
	
	@Column(name = "tempo_viagem", nullable = true)//Configuration (hora_chegada - hora_partida)
	private Integer tempoViagem; 
	
	@Column(name = "hora_partida", nullable = false)//Configuration
	private LocalTime horaPartida;
	
	@Column(name = "hora_chegada", nullable = false)//Configuration
	private LocalTime horaChegada;
	
	@Column(name = "data_partida", nullable = false)//
	private LocalDate dataPartida;
	
	@Column(name = "data_volta", nullable = false)//
	private LocalDate dataVolta;

	@Column(name = "data_chegada")//Configuration
	private LocalDate dataChegada;
	
	@Column(name = "quant_passageiro", length = 35, nullable = false)
	private Integer quantPassageiro;
}
