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
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "pre_cadastrado")
public class PreCadastrado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pre_cadastrado", unique = true)
	private Long idPreCadastrado;
	
	@ManyToOne
	@JoinColumn(name = "fk_reserva")
	private Reserva fkReserva;
	
	@ManyToOne
	@JoinColumn(name = "fk_alocacao")
	private Alocacao fkAlocacao;
	
	@Column(name = "nome_pre_cadastrado")
	private String nomePreCadastrado;
	
	@Column(name = "sobrenome_pre_cadastrado")
	private String sobrenomePreCadastrado;
	
	@Column(name = "email_pre_cadastrado", unique = true)
	private String emailPreCadastrado;
	
	@Column(name = "cpf_pre_cadastrado", unique = true)
	private String cpfPreCadastrado;
	
	@Column(name = "data_de_nascimento_pre_cadastrado")
	private String dataDeNascimentoPreCadastrado;
}