package com.vvv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_embarque")
public class Embarque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_embarque")
	private Long idEmbarque;
	
	@ManyToOne
	@JoinColumn(name = "fk_modal")
	private Modal fkModal;
	
	@ManyToOne
	@JoinColumn(name = "fk_proprietaria")
	private Proprietaria fkProprietaria;
	
	@ManyToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco fkEndereco;
	
	@Column(name = "capacidade", nullable = false, length = 3000)
	private Integer capacidade;
	
	@Column(name = "manutencao", nullable = false)
	private Boolean manutencao;

}
