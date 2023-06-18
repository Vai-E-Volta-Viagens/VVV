package com.vvv.controller;

import com.vvv.model.Passageiro;
import com.vvv.service.ServiceCidade;
import com.vvv.service.ServiceEndereco;
import com.vvv.service.ServiceEstado;
import com.vvv.service.ServicePassageiro;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

public class UpdatePerfilTest {

    @WebMvcTest(ControllerProject.class)
    public class PerfilControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ServicePassageiro servicePassageiro;

        @MockBean
        private ServiceEstado serviceEstado;

        @MockBean
        private ServiceCidade serviceCidade;

        @MockBean
        private ServiceEndereco serviceEndereco;

        @Test
        public void testUpdatePerfil() throws Exception {
            // Criar um objeto Passageiro para representar os dados do passageiro no teste
            Passageiro passageiro = new Passageiro();
            passageiro.setCpfPassageiro(Long.valueOf("123456789"));
            // Definir outros atributos do passageiro...

            // Configurar o comportamento dos mocks
            Mockito.when(servicePassageiro.findById(Mockito.anyLong())).thenReturn(Optional.of(passageiro));
            // Configurar outros comportamentos dos mocks...

            // Enviar uma requisição POST para o endpoint /perfil com os dados do passageiro
            mockMvc.perform(MockMvcRequestBuilders.post("/perfil")
                            .flashAttr("passageiro", passageiro))
                    .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                    .andExpect(MockMvcResultMatchers.redirectedUrl("redirect:perfil"))
                    .andExpect(MockMvcResultMatchers.flash().attributeExists("Message"));

            // Verificar o comportamento esperado
            Mockito.verify(servicePassageiro).findById(Mockito.anyLong());
            Mockito.verify(serviceEstado).save(Mockito.any());
            Mockito.verify(serviceCidade).save(Mockito.any());
            Mockito.verify(serviceEndereco).save(Mockito.any());
            Mockito.verify(servicePassageiro).save(Mockito.any());
        }
    }
}
