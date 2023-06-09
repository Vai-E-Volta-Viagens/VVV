package com.vvv.controller;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.vvv.configuration.Configuracao;
import com.vvv.model.Alocacao;
import com.vvv.model.Cartao;
import com.vvv.model.Embarque;
import com.vvv.model.Estado;
import com.vvv.model.Modal;
import com.vvv.model.Pagamento;
import com.vvv.model.Passageiro;
import com.vvv.model.PreCadastrado;
import com.vvv.model.Reserva;
import com.vvv.model.Ticket;
import com.vvv.model.Viagem;
import com.vvv.repository.RepositoryReserva;
import com.vvv.service.ServiceAlocacao;
import com.vvv.service.ServiceCartao;
import com.vvv.service.ServiceCidade;
import com.vvv.service.ServiceEmbarque;
import com.vvv.service.ServiceEndereco;
import com.vvv.service.ServiceEstado;
import com.vvv.service.ServiceModal;
import com.vvv.service.ServicePagamento;
import com.vvv.service.ServicePassageiro;
import com.vvv.service.ServicePreCadastrado;
import com.vvv.service.ServiceReserva;
import com.vvv.service.ServiceTicket;
import com.vvv.service.ServiceViagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

//Classe realizada pelo controle das execuções entre a interface e o back-end
@Controller
public class ControllerProject {
	public ModelAndView mav;
	
	private Cartao cartao;
	private Passageiro usuarioLogado;
	
	private ServiceEstado serviceEstado;
	private ServiceCidade serviceCidade;
	private ServiceEndereco serviceEndereco;
	private ServicePassageiro servicePassageiro;
	
	private ServiceModal serviceModal;
	private ServiceCartao serviceCartao;
	private ServiceViagem serviceViagem;
	private ServiceTicket serviceTicket;
	private ServiceReserva serviceReserva;
	
	private ServiceAlocacao serviceAlocacao;
	private ServiceEmbarque serviceEmbarque;
	private ServicePagamento servicePagamento;
	private ServicePreCadastrado servicePreCadastrado;

	@Autowired
	private RepositoryReserva repositoryReserva;
	
	private Pagamento pagamento = new Pagamento();
	
	public ControllerProject(ServiceEndereco serviceEndereco, ServicePassageiro servicePassageiro, ServiceEstado serviceEstado, ServiceCidade serviceCidade, ServiceModal serviceModal, ServiceViagem serviceViagem, ServiceReserva serviceReserva, ServiceCartao serviceCartao, ServicePreCadastrado servicePreCadastrado, ServicePagamento servicePagamento, ServiceAlocacao serviceAlocacao, ServiceTicket serviceTicket, ServiceEmbarque serviceEmbarque) {
		this.serviceEndereco = serviceEndereco;
		this.servicePassageiro = servicePassageiro;
		this.serviceCidade = serviceCidade;
		this.serviceEstado = serviceEstado;
		
		this.serviceModal = serviceModal;
		this.serviceCartao = serviceCartao;
		this.serviceViagem = serviceViagem;
		this.serviceReserva = serviceReserva;
	
		this.serviceTicket = serviceTicket; 
		this.serviceAlocacao = serviceAlocacao;
		this.servicePagamento = servicePagamento;
		this.servicePreCadastrado = servicePreCadastrado;
		
		this.serviceEmbarque = serviceEmbarque; 
	}
	
	// Método responsável por inicializar a janela Login
	@GetMapping("/login")
	public String startLogin(Passageiro passageiro) {
		return "login";
	}
	
	// Método responsável por validar o cadastro
	@PostMapping("/bem-vindo")
	public String validarLogin(Passageiro passageiro, Viagem viagem, RedirectAttributes ra, Model model) {
		this.usuarioLogado = new Passageiro();
		 usuarioLogado = servicePassageiro.findByEmailPassageiroAndSenhaPassageiro(passageiro.getEmailPassageiro(), passageiro.getSenhaPassageiro());		
		
		if(usuarioLogado !=  null) {
						
			model.addAttribute("username", usuarioLogado.getPrimeiroNomePassageiro());
			return "reserva";
						
		}else {
			ra.addFlashAttribute("ErrorMessage", true);
			return "redirect:login";
		}
	}
	
	// Método responsável por inicializar a janela Cadastro
	@GetMapping("/cadastre-se")
	public String iniciarCadastro(Passageiro passageiro) {
		return "cadastro";
	}
	
	// Método responsável por validar o cadastro
	@PostMapping("/realizar-cadastro")
	public String realizarCadastro(Passageiro passageiro, RedirectAttributes ra) {
		if(servicePassageiro.findByEmailPassageiro(passageiro.getEmailPassageiro()) == null) {
								
			Configuracao.GeneratingCodeForRegister(passageiro);
			Configuracao.RegistrationDate(passageiro);
				
			servicePassageiro.save(passageiro);
			//System.out.println(passageiro);
							
			return "redirect:login";
		}
		
		ra.addFlashAttribute("ExistingRegistration", true);
		return "redirect:cadastre-se";
	}
	
	
	@GetMapping("/perfil")
	public String preencherPerfil(Passageiro passageiro) {
		return "perfil";
	}
	
	@PostMapping("/perfil")
	public String updatePerfil(Passageiro passageiro, RedirectAttributes ra) {
Passageiro pass = servicePassageiro.findById(usuarioLogado.getIdPassageiro()).get();
		
		pass.setCpfPassageiro(passageiro.getCpfPassageiro());
		pass.setTelefonePassageiro(passageiro.getTelefonePassageiro());
		pass.setProfissaoPassageiro(passageiro.getProfissaoPassageiro());
		pass.setRgPassageiro(passageiro.getRgPassageiro());
		pass.setDataDeNascimentoPassageiro(passageiro.getDataDeNascimentoPassageiro());
		pass.setNacionalidadePassageiro(passageiro.getNacionalidadePassageiro());
		pass.setSexoPassageiro(passageiro.getSexoPassageiro());
		
			try {
				Estado est = new Estado();
				est.setNomeEstado(passageiro.getEndereco().getFkCidade().getFkEstado().getNomeEstado());
				est.setUf(passageiro.getEndereco().getFkCidade().getFkEstado().getUf());
				passageiro.getEndereco().getFkCidade().setFkEstado(est);
				
				System.out.println(passageiro.getEndereco().getFkCidade().getFkEstado().getNomeEstado());
				System.out.println(passageiro.getEndereco().getFkCidade().getFkEstado().getUf());
				
				serviceEstado.save(passageiro.getEndereco().getFkCidade().getFkEstado());
				serviceCidade.save(passageiro.getEndereco().getFkCidade());
				serviceEndereco.save(passageiro.getEndereco());
				
				pass.setEndereco(passageiro.getEndereco());
				
				Configuracao.addDataInUsuarioLogado(this.usuarioLogado, pass);
				//pass.setEndereco(enderecoSave);
				servicePassageiro.save(pass);
					
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("Error", true);
			
			return "redirect:perfil";
		}
		
		ra.addFlashAttribute("Message", true);
		return "redirect:perfil";
	}
	
	@GetMapping("/bem-vindo")
	public String aposCadastroPerfil(Passageiro passageiro, Viagem viagem, Model model) {
		
		model.addAttribute("username", this.usuarioLogado.getPrimeiroNomePassageiro());
		return "reserva";
	}
	
	
	@PostMapping("/buscar-reserva")
	public String buscarReserva(Viagem viagem, Passageiro passageiro, Reserva reserva, HttpServletRequest request, Model model, RedirectAttributes ra) {
		
		model.addAttribute("username", this.usuarioLogado.getPrimeiroNomePassageiro());
		
		if(this.usuarioLogado.getRgPassageiro() != null) {
				
			if(request.getParameter("opcao").equals("IDA_E_VOLTA")) {
				viagem.setIdaVolta(true);
				
			}else if(request.getParameter("opcao").equals("SOMENTE_IDA")) {
				viagem.setIdaVolta(false);
				viagem.setDataVolta(null);	
			}
			
			
			/*
			 *  Buscar os dados da viagem no banco de dados e exibir no template reservas.html
			 *  
			 * /
			 */
			ArrayList<Reserva> reservaDisponivel = new ArrayList<>();
			Viagem vgm = serviceViagem.findAllByCidadeOrigemAndCidadeDestinoAndDataPartidaAndDataVolta(viagem.getCidadeOrigem(), viagem.getCidadeDestino(), viagem.getDataPartida(), viagem.getDataVolta());
			
			if(vgm != null) {
				reservaDisponivel = serviceReserva.findByFkViagem(vgm);
				
				model.addAttribute("reservas", reservaDisponivel); // model responsável por exibir os dados no template enviando para o thymeleaf
				// model.addAttribute("tipoModal", repositoryReserva.buscarTipoModalPorRegistro(/* Aqui dentro você irá passar o registro do modal que será feita a reserva*/));
				// tentar buscar o Modal e exibir o seu tipo, exemplo: Ônibus, Navio...
				return "reserva";
				
			}else {
				
				return "redirect:/bem-vindo";
			}
		}else {
			
			ra.addFlashAttribute("ErrorMessage", true);
			return "redirect:/bem-vindo";
		}
	}
	
	
	Reserva reservaSelecionada = null;
	Set<String> posicaoSelecionada = new LinkedHashSet<String>();

	@GetMapping("/assento/{codReserva}")
	public String paginaAssento(@PathVariable("codReserva")Long codReserva, Model model) {
		reservaSelecionada = new Reserva();
		reservaSelecionada = serviceReserva.findByCodReserva(codReserva).orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
	
		model.addAttribute("modal", reservaSelecionada.getFkEmbarque().getFkModal().getTipoModal());
		try {
			posicaoSelecionada.forEach(c -> model.addAttribute("assento_".concat(c), "red"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "assento";
	}
	
	
	Set<String> posicaoAuxiliar = new LinkedHashSet<>();
	@PostMapping("/confirmar-assento")
	public String confirmarAssento(HttpServletRequest request, Model model) {	
		model.addAttribute("reservaForEach",reservaSelecionada);
		
		
		model.addAttribute("modal", reservaSelecionada.getFkEmbarque().getFkModal().getTipoModal());
		posicaoSelecionada.forEach(c -> model.addAttribute("assento_".concat(c), "red"));
		
		if(!posicaoSelecionada.contains(request.getParameter("posicao"))) {
			posicaoSelecionada.add(request.getParameter("posicao"));
			posicaoAuxiliar.add(request.getParameter("posicao"));		
			
			model.addAttribute("assento_".concat(request.getParameter("posicao")), "red");
			model.addAttribute("ReservasSelecionadas", posicaoAuxiliar);
			
		}else {
			
			model.addAttribute("ErrorMessage", true);
			model.addAttribute("ReservasSelecionadas", posicaoAuxiliar);
			return "assento";
		}
		
		return "assento";
	}
	
	
	Viagem viagem = null;
	Reserva reservaRealizada = null;
	@GetMapping("/pagamento/{codReserva}")
	public String paginaPagamento(@PathVariable("codReserva")Long codReserva, Cartao cartao, Model model) {
		reservaRealizada = new Reserva();
		reservaRealizada = serviceReserva.findByCodReserva(codReserva).orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
		
		model.addAttribute("reserva", reservaRealizada);
		
		reservaRealizada.setPosicaoPoltrona(new ArrayList<>(posicaoSelecionada));
		serviceReserva.save(reservaRealizada);
		
		return "pagamento";
	}
	
	
	private static int paymentControl = 0;
	@PostMapping("/pagamento-cartao")
	public String formaPagamento(Cartao cartao, HttpServletRequest request, Model model) {
		String parcela = null;
		pagamento = new Pagamento();
		model.addAttribute("reserva", reservaRealizada);
		
		if(paymentControl == 1) {
			
			Cartao c = serviceCartao.findByIdCartao(Configuracao.getCartaoForId().getIdCartao()).get();		
			try {		
				
				if(request.getParameter("tipoPag").equalsIgnoreCase("AVISTA")) {
					this.pagamento.setFormaPagamento("AVISTA");
					this.pagamento.setParcelamento("1");
					
				}else if(request.getParameter("tipoPag").equalsIgnoreCase("PARCELA")){
					this.pagamento.setFormaPagamento("PARCELA");
					
					parcela = request.getParameter("parcela");
					this.pagamento.setParcelamento(parcela);
				}

				this.pagamento.setFkPassageiro(usuarioLogado);
				this.pagamento.setFkCartao(serviceCartao.findByIdCartao(Configuracao.getCartaoForId().getIdCartao()).get());
				this.pagamento.setFkProprietaria(reservaRealizada.getFkEmbarque().getFkProprietaria());
				
				this.pagamento.setPagamentoFeito(false);
				servicePagamento.save(this.pagamento);
				
			}catch(Exception e) {
				System.out.println("Isso é planejado, não se acanhem! :)");
				e.printStackTrace();
			}
			
		}else {		
		
			if(request.getParameter("tipo").equalsIgnoreCase("CREDITO")) {
				cartao.setTipoCartao("CRÉDITO");
						
			}else if(request.getParameter("tipo").equalsIgnoreCase("DEBITO")) {
				cartao.setTipoCartao("DÉBITO");
						
			}else {
				return "dinheiro";
			}	
			
			serviceCartao.save(cartao);
			Configuracao.setCartaoForId(serviceCartao.findByIdCartao(cartao.getIdCartao()).get());
		}
		
		model.addAttribute("cartao", cartao);
		model.addAttribute("confirmed", true);
		
		if(paymentControl == 0) {
			paymentControl = 1;
		
			return "pagamento";
			
		}else {
			paymentControl = 0;
			
			return "redirect:/compra/" + Configuracao.getCartaoForId().getIdCartao().toString();
		}
	}
	
	
	Double soma = 0.0, parcela = 0.0;
	Boolean keyCartao = true, keySave = false, keyPc = true;
	@GetMapping("/compra/{idCartao}")
	public String buscarCompra(@PathVariable(name = "idCartao")Long idCartao, Cartao cartao, PreCadastrado preCadastrado, Model model) {
		this.cartao = serviceCartao.findByIdCartao(idCartao).orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado"));
	
		int startNumber = 0, endNumber = 0;
		if(posicaoAuxiliar.size() != 1) {
			startNumber = 1;
			endNumber = posicaoAuxiliar.size();
			
			model.addAttribute("notPc", 1);
			
		}else {
			keyPc = false;
			keyCartao = false;
			model.addAttribute("notPc", 0);
			
			test();
		}
		
		model.addAttribute("startNumber", startNumber);
		model.addAttribute("endNumber", endNumber);		
		
		model.addAttribute("cartao", this.cartao);
		model.addAttribute("isConfirmed", !keyCartao);
		
		DecimalFormat df = new DecimalFormat("#,##0.00");		
		model.addAttribute("valorTotal", df.format(soma));
		model.addAttribute("valorParcelado", df.format(parcela));

		return "compra";
	}
	
	public void test() {
		soma = Double.valueOf(reservaRealizada.getValorReserva());
		System.out.println("Sem ninguem: " + soma);
		if(this.cartao.getTipoCartao().equalsIgnoreCase("CRÉDITO") && Integer.valueOf(this.pagamento.getParcelamento()) > 4) {
			soma += (Double.valueOf(reservaRealizada.getValorReserva()) * 0.05);
		}
		
		System.out.println("Entrou: "+soma);
		if((ChronoUnit.YEARS.between(usuarioLogado.getDataDeNascimentoPassageiro(), LocalDate.now()) > 2
				&& ChronoUnit.YEARS.between(usuarioLogado.getDataDeNascimentoPassageiro(), LocalDate.now()) < 10)
				&& ChronoUnit.YEARS.between(usuarioLogado.getDataDeNascimentoPassageiro(), LocalDate.now()) > 21)
				{
					soma -= (soma * 0.4);
				}
		
		if(this.pagamento.getFormaPagamento().equalsIgnoreCase("PARCELA")) {
			parcela = (soma / Integer.valueOf(this.pagamento.getParcelamento()));
		}
		
		System.out.println("Sem ninguem: " + soma);
		System.out.println("Sem ninguem: " + parcela);
		keySave = true;
		Configuracao.saveCartaoForCompra(this.cartao, cartao, serviceCartao);
	}
	 
	
	@PostMapping("/realizar-compra")
	public String realizarCompra(Cartao cartao, PreCadastrado preCadastrado, Model model, HttpServletRequest request) {
		Cartao c = serviceCartao.findByIdCartao(this.cartao.getIdCartao()).orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado"));
		Reserva r = serviceReserva.findById(reservaSelecionada.getIdReserva()).orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
				
		int keyTicket = 0;
		
		// logic inverted
		String [] cpfArray;
		String [] dataArray;
		ArrayList<Long> cpfList = new ArrayList<>();
		ArrayList<LocalDate> dataList = new ArrayList<>();
		if(keyPc == true) {
			cpfArray = preCadastrado.getCpfPreCadastrado().split(",");
			cpfList = new ArrayList<>();
		
		
			dataArray = preCadastrado.getDataDeNascimentoPreCadastrado().split(",");
			dataList = new ArrayList<>();
			
			for(String cpfString : cpfArray) // CPF Validation
			{
				try {
					Long cpf = Long.valueOf(cpfString.trim());
					if(cpf > 9999999999L && cpf < 99999999999L) {
						cpfList.add(cpf);
						
					}else {
						throw new Exception("CPF não identificado");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
					
			for(String dataString : dataArray) { // Birthday Validation
				try {
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					dataList.add(LocalDate.parse(dataString, formatter));
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}	
		}
		
		
		// [...]
		
		
		if(keySave) {
			Configuracao.saveCartaoForCompra(c, cartao, serviceCartao);
		}
		
		if(keyCartao) {
			keySave = Configuracao.savePreCadastrado(preCadastrado, r, cpfList, dataList, servicePreCadastrado);
		}
		
		if(keyCartao) {			
			soma = Double.valueOf(reservaRealizada.getValorReserva()) * (servicePreCadastrado.getRepositoryPreCadastrado().count()+1);
			System.out.println("soma: " + soma);
			
			if(c.getTipoCartao().equalsIgnoreCase("CRÉDITO") && Integer.valueOf(this.pagamento.getParcelamento()) > 4) {
				soma += (Double.valueOf(reservaRealizada.getValorReserva()) * 0.05);
				
			}else if(c.getTipoCartao().equalsIgnoreCase("CRÉDITO") && Integer.valueOf(this.pagamento.getParcelamento()) <= 4) {
				
			}
			
			boolean isAccept = false;
			long[] coletorIdade = Configuracao.ageOfPassengers(usuarioLogado, servicePreCadastrado);
			for(int i = 0; i < coletorIdade.length; i++) {
				for(int j = 0; j < coletorIdade.length; j++) {
					if((coletorIdade[i] > 2 && coletorIdade[i] < 10) && coletorIdade[j] > 21) {
						isAccept = true;
					}
				}
			}
			
			if(isAccept) {
				soma -= (soma * 0.4);
			}
			
			if(this.pagamento.getFormaPagamento().equalsIgnoreCase("PARCELA"))
				parcela = (soma / Integer.valueOf(this.pagamento.getParcelamento()));
			
			System.out.println("Parcela: " + parcela);
			keyTicket = 1;
		
		}else {}
		
		int startNumber = 0, endNumber = 0;
		if(posicaoAuxiliar.size() != 1) {
			startNumber = 1;
			endNumber = posicaoAuxiliar.size();
			
			model.addAttribute("notPc", 1);
			
		}else {
			model.addAttribute("notPc", 0);
		}
		model.addAttribute("startNumber", startNumber);
		model.addAttribute("endNumber", endNumber);	
	
		
		if(keySave) {
			keyCartao = false;
		}
		
		if(keyTicket == 1) {
			return "redirect:/compra/" + Configuracao.getCartaoForId().getIdCartao().toString();
			
		}else {
			this.pagamento.setPagamentoFeito(true);
			servicePagamento.save(this.pagamento);
			
			Ticket ticket = new Ticket();
			Alocacao alocacao = new Alocacao();
			
			alocacao.setFkPagamento(this.pagamento);
			alocacao.setFkPassageiro(usuarioLogado);
			alocacao.setFkReserva(r);
			
			alocacao.setValorTotal(soma);
			alocacao.setDataSolicitacao(LocalDateTime.now());
			
			ticket.setFkPagamento(this.pagamento);
			ticket.setDataGeracao(LocalDateTime.now());
			Configuracao.GeneratingCodeForTicket(ticket);
			
			serviceTicket.save(ticket);
			serviceAlocacao.save(alocacao);
			
			if(endNumber != 0) {
				Configuracao.saveAlocacao(alocacao, servicePreCadastrado);
				keyPc = true;
			}
			
			this.pagamento.setFkAlocacao(alocacao);
			servicePagamento.save(this.pagamento);
			
			r.setFkAlocacao(alocacao);
			serviceReserva.save(r);
			
			posicaoAuxiliar.clear();
			posicaoSelecionada.clear();
			
			return "redirect:/ticket";
		}
	}
	

	
	@GetMapping("/ticket")
	public String ticket(Ticket ticket, Model model) {
		Ticket t = serviceTicket.findByFkPagamento(this.pagamento);

		if (keyPc) {
			PreCadastrado[] pc = Configuracao.RedirectColetor();

			model.addAttribute("startNumber", 1);
			model.addAttribute("endNumber", pc.length);

			ArrayList<String> nomes = new ArrayList<>();
			ArrayList<String> cpf = new ArrayList<>();

			for (int i = 0; i < pc.length; i++) {
				nomes.add(pc[i].getNomePreCadastrado() + " " + pc[i].getSobrenomePreCadastrado());
				cpf.add(pc[i].getCpfPreCadastrado());
			}

			model.addAttribute("ticket", t);
			model.addAttribute("nomeConvidado", nomes);
			model.addAttribute("cpfConvidado", cpf);

		} else {

			model.addAttribute("startNumber", 1);
			model.addAttribute("endNumber", 1);
			model.addAttribute("ticket", t);
			model.addAttribute("nomeConvidado", "[]");
			model.addAttribute("cpfConvidado", "[]");
		}

		this.pagamento = null;
		this.reservaRealizada = null;
		this.reservaSelecionada = null;

		soma = 0.0;
		parcela = 0.0;
		keyCartao = true;
		keySave = false;
		keyPc = true;

		return "ticket";
	}

	// Endpoints teste
	
	// @GetMapping("/buscartipomodal/{registro}")
	// public ResponseEntity<String> buscarTipoModal(@PathVariable("registro") String registro) {

	// 	String tipo = repositoryReserva.buscarTipoModalPorRegistro(registro);

	// 	return ResponseEntity.ok(tipo);

	// }
}