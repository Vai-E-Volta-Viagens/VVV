package com.vvv.model;

import java.time.LocalDate;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_passageiro") // Tabela Passageiro responsável por salvar os dados de Passageiro
public class Passageiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_passageiro", unique = true)
	private Long idPassageiro;
	
	@Column(name = "cod_passageiro", unique = true)
	private Long codPassageiro;
	
	@ManyToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;
	
	@OneToMany
	@JoinColumn(name = "fk_pagamento")
	private List<Pagamento> pagamento;
	
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "primeiro_nome", nullable = false, length = 100)
	private String primeiroNomePassageiro;
	
	@Column(name = "sobrenome_passageiro", nullable = false, length = 200)
	private String sobrenomePassageiro;
	
	@Column(name = "email_passageiro", nullable = false, unique = true, length = 50)
	private String emailPassageiro;
	
	@Column(name = "senha_passageiro", nullable = false, length = 30)
	private String senhaPassageiro;
	
	@Column(name = "cpf_passageiro", unique = true, length = 11)
	private Long cpfPassageiro;
	
	@Column(name = "telefone_passageiro", unique = true, length = 14)
	private Long telefonePassageiro;
	
	@Column(name = "profissao_passageiro", length = 50)
	private String profissaoPassageiro;
	
	@Column(name = "rg_passageiro", unique = true, length = 9)
	private Long rgPassageiro;
	
	@Column(name = "data_de_nascimento_passageiro")
	private LocalDate dataDeNascimentoPassageiro;
	
	@Column(name = "nacionalidade_passageiro", length = 30)
	private String nacionalidadePassageiro;
	
	@Column(name = "sexo_passageiro", length = 20)
	private String sexoPassageiro;
}