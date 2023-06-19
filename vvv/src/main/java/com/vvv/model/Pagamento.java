package com.vvv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento", unique = true)
	private Long idPagamento;
	
	@ManyToOne
	@JoinColumn(name = "fk_proprietaria")
	private Proprietaria fkProprietaria;
	
	@ManyToOne
	@JoinColumn(name = "fk_passageiro")
	private Passageiro fkPassageiro;
	
	@ManyToOne
	@JoinColumn(name = "fk_cartao")
	private Cartao fkCartao;
	
	@OneToOne
	@JoinColumn(name = "fk_alocacao")
	private Alocacao fkAlocacao;
	
	@Column(name = "parcelamento")
	private String parcelamento;
	
	@Column(name = "forma_pagamento")
	private String formaPagamento;
	
	@Column(name = "pagamento_feito")
	private Boolean pagamentoFeito;
}