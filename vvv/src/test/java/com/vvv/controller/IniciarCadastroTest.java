package com.vvv.controller;

import com.vvv.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ControllerProject.class)
public class IniciarCadastroTest {

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
    public void testIniciarCadastro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cadastre-se"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("cadastro"));
    }
}