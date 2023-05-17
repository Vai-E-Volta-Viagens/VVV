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
@Table(name = "tb_embarque")
public class Embarque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_embarque", unique = true)
	private Long idEmbarque;
	
	@ManyToOne
	@JoinColumn(name = "fk_modal")
	private Modal modal;
	
	@ManyToOne
	@JoinColumn(name = "fk_proprietaria")
	private Proprietaria proprietaria;
	
	@ManyToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;
	
	@Column(name = "capacidade", nullable = false, length = 3000)
	private Integer capacidade;
	
	@Column(name = "manutencao", nullable = false)
	private Boolean manutencao;
	
	
	public Embarque() {}
	public Embarque(Long idEmbarque, Modal modal, Proprietaria proprietaria, Endereco endereco, Integer capacidade,
			Boolean manutencao) {
		this.idEmbarque = idEmbarque;
		this.modal = modal;
		this.proprietaria = proprietaria;
		this.endereco = endereco;
		this.capacidade = capacidade;
		this.manutencao = manutencao;
	}
}
