package com.vvv.configuration;

import java.time.LocalDateTime;
import com.vvv.model.Passageiro;
import com.vvv.model.Reserva;


// Classe responsável por realizar ajustes e configurações
public class Configuracao {
	private static long cod = 1;
	
	// Adicionar a data atual do cadastro
	public static void RegistrationDate(Passageiro passageiro) {
		passageiro.setDataCadastro(LocalDateTime.now());
	}
	
	// Gerar o código do Passageiro
	public static void GeneratingCodeForRegister(Passageiro passageiro) {
		passageiro.setCodigoPassageiro(cod+=3);
	}
	
	public static void addDataInUsuarioLogado(Passageiro usuarioLogado, Passageiro pass) {
		usuarioLogado.setCpfPassageiro(pass.getCpfPassageiro());
		usuarioLogado.setTelefonePassageiro(pass.getTelefonePassageiro());
		usuarioLogado.setProfissaoPassageiro(pass.getProfissaoPassageiro());
		usuarioLogado.setRgPassageiro(pass.getRgPassageiro());
		usuarioLogado.setDataDeNascimentoPassageiro(pass.getDataDeNascimentoPassageiro());
		usuarioLogado.setNacionalidadePassageiro(pass.getNacionalidadePassageiro());
		usuarioLogado.setSexoPassageiro(pass.getSexoPassageiro());
	}
	
	public static void GeneratingCodeForReservation(Reserva reserva) { 
		reserva.setCodReserva(cod + 4);
	}
}
