package com.vvv.controller;

import java.util.ArrayList;

import com.vvv.configuration.Configuracao;
import com.vvv.model.Passageiro;
import com.vvv.model.Reserva;
import com.vvv.model.Viagem;
import com.vvv.service.ServiceCidade;
import com.vvv.service.ServiceEndereco;
import com.vvv.service.ServiceEstado;
import com.vvv.service.ServiceModal;
import com.vvv.service.ServicePassageiro;
import com.vvv.service.ServiceReserva;
import com.vvv.service.ServiceViagem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

// Classe realizada pelo controle das execuções entre a interface e o back-end
@Controller
public class ControllerProject {
	public ModelAndView mav;
	private Passageiro usuarioLogado;
	
	private ServiceEstado serviceEstado;
	private ServiceCidade serviceCidade;
	private ServiceEndereco serviceEndereco;
	private ServicePassageiro servicePassageiro;
	
	private ServiceModal serviceModal;
	private ServiceViagem serviceViagem;
	private ServiceReserva serviceReserva;
	
	public ControllerProject(ServiceEndereco serviceEndereco, ServicePassageiro servicePassageiro, ServiceEstado serviceEstado, ServiceCidade serviceCidade, ServiceModal serviceModal, ServiceViagem serviceViagem, ServiceReserva serviceReserva) {
		this.serviceEndereco = serviceEndereco;
		this.servicePassageiro = servicePassageiro;
		this.serviceCidade = serviceCidade;
		this.serviceEstado = serviceEstado;
		
		this.serviceModal = serviceModal;
		this.serviceViagem = serviceViagem;
		this.serviceReserva = serviceReserva;
	}
	
	// Método responsável por inicializar a janela Login
	@GetMapping("/login")
	public String startLogin(Passageiro passageiro) {
		return "login";
	}
	
	// Método responsável por validar o cadastro
	@PostMapping("/bem-vindo")
	public String validarLogin(Passageiro passageiro, Viagem viagem, RedirectAttributes ra, Model model) {
		this.usuarioLogado = servicePassageiro.findByEmailPassageiroAndSenhaPassageiro(passageiro.getEmailPassageiro(), passageiro.getSenhaPassageiro());
		
		if(usuarioLogado != null) {
			
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
		
		serviceEstado.save(passageiro.getEndereco().getCidade().getEstado());
		serviceCidade.save(passageiro.getEndereco().getCidade());
		serviceEndereco.save(passageiro.getEndereco());
		
		pass.setEndereco(passageiro.getEndereco());
		
		Configuracao.addDataInUsuarioLogado(this.usuarioLogado, pass);
		servicePassageiro.save(pass);
		
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
			
			ArrayList<Reserva> reservaDisponivel = new ArrayList<>();
			Viagem vgm = serviceViagem.findAllByCidadeOrigemAndCidadeDestinoAndDataPartidaAndDataVolta(viagem.getCidadeOrigem(), viagem.getCidadeDestino(), viagem.getDataPartida(), viagem.getDataVolta());
			
			if(vgm != null) {
				reservaDisponivel = serviceReserva.findByViagem(vgm);
				System.out.println(reservaDisponivel);
	
				//mav = new ModelAndView("reserva");
				model.addAttribute("reservas", reservaDisponivel);
				
				return "reserva";
				
			}else {
				
				return "redirect:/bem-vindo";
			}
		}else {
			
			ra.addFlashAttribute("ErrorMessage", true);
			return "redirect:/bem-vindo";
		}
	}
	
	@GetMapping("/pagamento/{codReserva}")
	public String paginaPagamento(@PathVariable("codReserva")Long codReserva, Model model) {
		Reserva reserva = serviceReserva.findByCodReserva(codReserva).orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
		
		model.addAttribute("reserva", reserva);
		
		return "pagamento";
	}
}
