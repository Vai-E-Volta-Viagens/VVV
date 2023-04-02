package com.vvv.model;

import java.time.LocalDateTime;

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
@Table(name = "tb_cadastro")
public class Cadastro {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cadastro", unique = true)
	private Long idCadastro;
	
	@ManyToOne
	@JoinColumn(name = "fk_login")
	private Login login;
	
	@ManyToOne
	@JoinColumn(name = "fk_passageiro")
	private Passageiro passageiro;
	
	@Column(name = "primeiro_nome_passageiro", nullable = false, length = 100)
	private String primeiroNome;
	
	@Column(name = "sobrenomePassageiro", nullable = false, length = 100)
	private String sobrenome;
	
	@Column(name = "data_de_cadastro", nullable = false)
	private LocalDateTime dataDeCadastro;
	
	
	public Cadastro() {}
	public Cadastro(Long idCadastro, Login login, Passageiro passageiro, String primeiroNome,
			String sobrenome, LocalDateTime dataDeCadastro) {
		this.idCadastro = idCadastro;
		this.login = login;
		this.passageiro = passageiro;
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.dataDeCadastro = dataDeCadastro;
	}
}
