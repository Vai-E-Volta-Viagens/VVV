package com.vvv.configuration;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vvv.model.Alocacao;
import com.vvv.model.Cartao;
import com.vvv.model.Pagamento;
import com.vvv.model.Passageiro;
import com.vvv.model.PreCadastrado;
import com.vvv.model.Reserva;
import com.vvv.model.Ticket;
import com.vvv.service.ServiceCartao;
import com.vvv.service.ServicePassageiro;
import com.vvv.service.ServicePreCadastrado;
import com.vvv.service.ServiceReserva;


// Classe responsável por realizar ajustes e configurações
public class Configuracao {
	private static long cod = 1;
	private static PreCadastrado[] coletor;
	
	private static Cartao cartao;
	private static ServiceCartao serviceCartao;
	
	
	// Adicionar a data atual do cadastro
	public static void RegistrationDate(Passageiro passageiro) {
		passageiro.setDataCadastro(LocalDateTime.now());
	}
	
	// Gerar o código do Passageiro
	public static void GeneratingCodeForRegister(Passageiro passageiro) {
		passageiro.setCodPassageiro(cod+=3);
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
	
	public static Set<String> modalSeats(Reserva reserva) {
		Set<String> set = new LinkedHashSet<String>();

		set.add("1A");
		set.add("2A");
		set.add("3A");
		set.add("4A");
		set.add("5A");
		set.add("6A");
		set.add("1B");
		set.add("2B");
		set.add("3B");
		set.add("4B");
		set.add("5B");
		set.add("6B");
		set.add("1C");
		set.add("2C");
		set.add("3C");
		set.add("4C");
		set.add("5C");
		set.add("6C");
		set.add("1D");
		set.add("2D");
		set.add("3D");
		set.add("4D");
		set.add("5D");
		set.add("6D");
		set.add("1E");
		set.add("2E");
		set.add("3E");
		set.add("4E");
		set.add("5E");
		set.add("6E");
		set.add("1F");
		set.add("2F");
		set.add("3F");
		set.add("4F");
		set.add("5F");
		set.add("6F");
		set.add("1G");
		set.add("2G");
		set.add("3G");
		set.add("4G");
		set.add("5G");
		set.add("6G");
		set.add("1H");
		set.add("2H");
		set.add("3H");
		set.add("4H");
		set.add("5H");
		set.add("6H");
		
		
		/*reserva.getPosicaoPoltrona().add("1A");
		reserva.getPosicaoPoltrona().add("2A");
		reserva.getPosicaoPoltrona().add("3A");
		reserva.getPosicaoPoltrona().add("1B");
		reserva.getPosicaoPoltrona().add("2B");
		reserva.getPosicaoPoltrona().add("3B");
		reserva.getPosicaoPoltrona().add("1C");
		reserva.getPosicaoPoltrona().add("2C");
		reserva.getPosicaoPoltrona().add("3C");
		reserva.getPosicaoPoltrona().add("1D");
		reserva.getPosicaoPoltrona().add("2D");
		reserva.getPosicaoPoltrona().add("3D");
		reserva.getPosicaoPoltrona().add("1E");
		reserva.getPosicaoPoltrona().add("2E");
		reserva.getPosicaoPoltrona().add("3E");
		reserva.getPosicaoPoltrona().add("1F");
		reserva.getPosicaoPoltrona().add("2F");
		reserva.getPosicaoPoltrona().add("3F");
		reserva.getPosicaoPoltrona().add("1G");
		reserva.getPosicaoPoltrona().add("2G");
		reserva.getPosicaoPoltrona().add("3G");
		reserva.getPosicaoPoltrona().add("1H");
		reserva.getPosicaoPoltrona().add("2H");
		reserva.getPosicaoPoltrona().add("3H");*/
		
		return set;
	}
	
	public static Cartao getCartaoForId() {
		return cartao;
	}
	
	public static void setCartaoForId(Cartao c) {
		cartao = c;
	}
	
	public static void saveCartaoForId(Cartao c) {
		serviceCartao.save(c);
	}
	
	public static Double fullAmountCount(PreCadastrado preCadastrado, Passageiro passageiro) {
	
		return null;
	}
	
	
	public static Boolean savePreCadastrado(PreCadastrado preCadastrado, Reserva reserva, ArrayList<Long> cpfList, ArrayList<LocalDate> dataList, ServicePreCadastrado spc) {		
		String[] nome = preCadastrado.getNomePreCadastrado().split(",");
		String[] sobrenome = preCadastrado.getSobrenomePreCadastrado().split(",");
		String[] email = preCadastrado.getEmailPreCadastrado().split(",");

		Boolean key = true;
		try {
			coletor = new PreCadastrado[cpfList.size()];
			for(int i = 0; i < cpfList.size(); i++) {
				coletor[i] = new PreCadastrado();
				coletor[i].setNomePreCadastrado(nome[i].trim());
				coletor[i].setSobrenomePreCadastrado(sobrenome[i].trim());
				coletor[i].setEmailPreCadastrado(email[i].trim());
				coletor[i].setCpfPreCadastrado(cpfList.get(i).toString());
				coletor[i].setDataDeNascimentoPreCadastrado(dataList.get(i).toString());
				coletor[i].setFkReserva(reserva);
			}		
			
			/*for(PreCadastrado pc : coletor) {
				//System.out.println(pc.getNomePreCadastrado());
				spc.save(pc);
			}*/
			
		}catch(Exception e) {
			key = false;
			e.printStackTrace();
		}
		
		return key;	
	}
	
	
	public static void saveAlocacao(Alocacao alocacao, ServicePreCadastrado spc) {
		for(int i = 0; i < coletor.length; i++) {
			coletor[i].setFkAlocacao(alocacao);
		}
		
		for(PreCadastrado pc : coletor) {
			spc.save(pc);
		}
	}
	
	
	public static void saveCartaoForCompra(Cartao cartaoCompra, Cartao cartaoInfo, ServiceCartao sc) {
		cartaoCompra.setSenha(cartaoInfo.getSenha());
		cartaoCompra.setOperadora(cartaoInfo.getOperadora());
		
		sc.save(cartaoCompra);
	}
	
	
	public static long[] ageOfPassengers(Passageiro passageiro, ServicePreCadastrado servicePreCadastrado) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		long quant = servicePreCadastrado.getRepositoryPreCadastrado().count() + 1;
		long[] coletorIdade = new long[(int) quant];
		LocalDate[] dataList = new LocalDate[(int)quant-1];
		
		for(int i = 0; i < quant-1; i++) {
			dataList[i] = LocalDate.parse(coletor[i].getDataDeNascimentoPreCadastrado(), formatter);
		}
		
		for(int i = 0; i < quant-1; i++) {
			coletorIdade[i] = ChronoUnit.YEARS.between(dataList[i], LocalDate.now());
		}
		coletorIdade[(int)quant-1] = ChronoUnit.YEARS.between(passageiro.getDataDeNascimentoPassageiro(), LocalDate.now());

		return coletorIdade;
	}
	
	public static void GeneratingCodeForTicket(Ticket ticket) { 
		ticket.setCodTicket(cod + 10);
	}
	
	
	public static PreCadastrado[] RedirectColetor() {
		return coletor;
	}
}
