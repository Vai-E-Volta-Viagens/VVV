package com.vvv.model;

import java.time.LocalDateTime;
import java.util.List;

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
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_alocacao")
public class Alocacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alocacao", unique = true)
	private Long idAlocacao;
	
	@ManyToOne
	@JoinColumn(name = "fk_passageiro")
	private Passageiro fkPassageiro;
	
	@OneToOne
	@JoinColumn(name = "fk_reserva")
	private Reserva fkReserva;
	
	@OneToOne
	@JoinColumn(name = "fk_pagamento")
	private Pagamento fkPagamento;
	
	@OneToMany(mappedBy = "fkAlocacao")
	private List<PreCadastrado> preCadastrado;
	
	@Column(name = "data_solicitacao")
	private LocalDateTime dataSolicitacao;
	
	@Column(name = "valor_total")
	private Double valorTotal;
}