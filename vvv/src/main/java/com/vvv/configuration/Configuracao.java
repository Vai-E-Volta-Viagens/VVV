package com.vvv.configuration;

import java.time.LocalDateTime;

import com.vvv.model.Cadastro;

// Classe responsável por realizar ajustes e configurações
public class Configuracao {
	
	// Adicionar a data atual do cadastro
	public static void RegistrationDate(Cadastro cadastro) {
		cadastro.setDataDeCadastro(LocalDateTime.now());
	}
	
	// Gerar o código do Passageiro
	public static void GeneratingCodeForRegister(Cadastro cadastro) {
		cadastro.setCodigoPassageiro(cadastro.getLogin().getIdLogin() + 2);
	}
}
