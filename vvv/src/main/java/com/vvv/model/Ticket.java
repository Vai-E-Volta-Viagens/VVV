package com.vvv.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ticket", unique = true)
	private Long idTicket;
	
	@Column(name = "cod_ticket")
	private Long codTicket;
	
	@OneToOne
	@JoinColumn(name = "fk_pagamento")
	private Pagamento fkPagamento;
	
	@Column(name = "data_geracao")
	private LocalDateTime dataGeracao;
}