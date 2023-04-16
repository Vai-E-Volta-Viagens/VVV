package com.vvv.model;

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
@Table(name = "tb_login") // Tabela Login responsável por salvar os dados de Login
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login", unique = true)
	private Long idLogin;
	
	@Column(name = "email_login", nullable = false, unique = true, length = 50)
	private String emailLogin;
	
	@Column(name = "senha_login", nullable = false, length = 30)
	private String senhaLogin;
	
	
	public Login() {}
	public Login(Long idLogin, String emailLogin, String senhaLogin) {
		this.idLogin = idLogin;
		this.emailLogin = emailLogin;
		this.senhaLogin = senhaLogin;
	}	
}
