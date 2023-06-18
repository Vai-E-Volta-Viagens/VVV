package com.vvv.controller;

import com.vvv.configuration.Configuracao;
import com.vvv.model.Passageiro;
import com.vvv.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;

@WebMvcTest(ControllerProject.class)
public class RealizarCadastroTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceEndereco serviceEndereco;
    @MockBean
    private ServicePassageiro servicePassageiro;
    @MockBean
    private ServiceEstado serviceEstado;
    @MockBean
    private ServiceCidade serviceCidade;
    @MockBean
    private ServiceModal serviceModal;
    @MockBean
    private ServiceViagem serviceViagem;
    @MockBean
    private ServicePreCadastrado servicePreCadastrado;
    @MockBean
    private ServiceCartao serviceCartao;
    @MockBean
    private ServiceReserva serviceReserva;
    @MockBean
    private ServiceAlocacao serviceAlocacao;
    @MockBean
    private ServiceEmbarque serviceEmbarque;
    @MockBean
    private ServiceTicket serviceTicket;
    @MockBean
    private ServicePagamento servicePagamento;

    @Test
    public void testRealizarCadastro() throws Exception {
        Passageiro passageiro = new Passageiro();
        passageiro.setEmailPassageiro("test@example.com");
        passageiro.setRgPassageiro(Long.valueOf("12244523211")); // Deveria poder ser String
        passageiro.setCpfPassageiro(Long.valueOf("12124565574"));
        passageiro.setSobrenomePassageiro("Dias");
        passageiro.setDataDeNascimentoPassageiro(LocalDate.of(2001, 03, 30));
        passageiro.setNacionalidadePassageiro("Brasileiro");
        passageiro.setProfissaoPassageiro("Programador");
        passageiro.setSexoPassageiro("Masculino");
        passageiro.setPrimeiroNomePassageiro("Vitor");
        passageiro.setTelefonePassageiro(Long.valueOf("951442323"));
        //passageiro.setSenhaPassageiro("Classico-12345");
        passageiro.setCodPassageiro(Long.valueOf("123"));
        passageiro.setDataCadastro(LocalDateTime.now());
        passageiro.setIdPassageiro(Long.valueOf(12145));

        Mockito.when(servicePassageiro.findByEmailPassageiro(passageiro.getEmailPassageiro())).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/realizar-cadastro")
                        .flashAttr("passageiro", passageiro))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("login"));
    }



    @Test
    public void testNaoRealizarCadastro() throws Exception {
        Passageiro passageiro = new Passageiro();
        passageiro.setEmailPassageiro("test@example.com");
        passageiro.setRgPassageiro(Long.valueOf("12244523211")); // Deveria poder ser String
        passageiro.setCpfPassageiro(Long.valueOf("12124565574"));
        passageiro.setSobrenomePassageiro("Dias");
        passageiro.setDataDeNascimentoPassageiro(LocalDate.of(2001, 03, 30));
        passageiro.setNacionalidadePassageiro("Brasileiro");
        passageiro.setProfissaoPassageiro("Programador");
        passageiro.setSexoPassageiro("Masculino");
        passageiro.setPrimeiroNomePassageiro("Vitor");
        passageiro.setTelefonePassageiro(Long.valueOf("951442323"));
        passageiro.setSenhaPassageiro("Classico-12345");
        passageiro.setCodPassageiro(Long.valueOf("123"));
        passageiro.setDataCadastro(LocalDateTime.now());

        Mockito.when(servicePassageiro.findByEmailPassageiro(passageiro.getEmailPassageiro())).thenReturn(passageiro);

        mockMvc.perform(MockMvcRequestBuilders.post("/realizar-cadastro")
                        .flashAttr("passageiro", passageiro))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("cadastre-se"));
    }
}
