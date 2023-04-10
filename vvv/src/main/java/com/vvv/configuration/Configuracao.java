package com.vvv.configuration;

import java.time.LocalDateTime;

import com.vvv.model.Cadastro;

public class Configuracao {
	public static void RegistrationDate(Cadastro cadastro) {
		cadastro.setDataDeCadastro(LocalDateTime.now());
	}
	
	public static void GeneratingCodeForRegister(Cadastro cadastro) {
		cadastro.setCodigoPassageiro(cadastro.getLogin().getIdLogin() + 2);
	}
}
