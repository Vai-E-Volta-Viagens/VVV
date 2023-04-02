package com.vvv.controller;

import com.vvv.configuration.Configuracao;
import com.vvv.model.Cadastro;
import com.vvv.model.Login;
import com.vvv.service.ServiceCadastro;
import com.vvv.service.ServiceEndereco;
import com.vvv.service.ServiceLogin;
import com.vvv.service.ServicePassageiro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerLogin {
	private ServiceLogin serviceLogin;
	private ServiceCadastro serviceCadastro;
	private ServiceEndereco serviceEndereco;
	private ServicePassageiro servicePassageiro;
	
	public ControllerLogin(ServiceLogin serviceLogin, ServiceCadastro serviceCadastro, ServiceEndereco serviceEndereco, ServicePassageiro servicePassageiro) {
		this.serviceLogin = serviceLogin;
		this.serviceCadastro = serviceCadastro;
		this.serviceEndereco = serviceEndereco;
		this.servicePassageiro = servicePassageiro;
	}
	
	@GetMapping("/login")
	public String startLogin(Login login) {
		return "login";
	}
	
	@PostMapping("/bem-vindo")
	public String validarLogin(Login login, Cadastro cadastro, RedirectAttributes ra, Model model) {
		Login usuarioLogado = serviceLogin.findByEmailLoginAndSenhaLogin(login.getEmailLogin(), login.getSenhaLogin());
		
		if(usuarioLogado != null) {
			
			model.addAttribute("username", serviceCadastro.findById(usuarioLogado.getIdLogin()).get().getPrimeiroNome());
			return "reserva";
			
		}else {
			ra.addFlashAttribute("ErrorMessage", "Login/Senha não identificados");
			return "redirect:login";
		}
	}
	
	@GetMapping("/cadastre-se")
	public String iniciarCadastro(Cadastro cadastro) {
		return "cadastro";
	}
	
	@PostMapping("/realizar-cadastro")
	public String realizarCadastro(Login login, Cadastro cadastro, RedirectAttributes ra) {
		if(serviceLogin.findByEmailLogin(login.getEmailLogin()) == null) {
			if(serviceLogin.findBySenhaLogin(login.getSenhaLogin()) ==  null) {
				
				serviceLogin.save(cadastro.getLogin());
				
				Configuracao.RegistrationDate(cadastro);
				
				serviceCadastro.save(cadastro);
				System.out.println(cadastro);
				
				return "redirect:login";
				
			}else {
				
				ra.addFlashAttribute("ExistingRegistration", "Esta senha já está cadastrada em nosso sistema!");
				return "cadastro";
			}
		}
		
		ra.addFlashAttribute("ExistingRegistration", "Este email já está cadastrado em nosso sistema!");
		return "cadastro";
	}
}
