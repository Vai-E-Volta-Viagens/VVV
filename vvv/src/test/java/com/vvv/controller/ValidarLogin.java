package com.vvv.controller;

import com.vvv.model.Passageiro;
import com.vvv.repository.RepositoryPassageiro;
import com.vvv.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


//Controller - RealizarCadastro
@SpringBootTest
public class ValidarLogin extends TestBase {

    @InjectMocks
    private ServicePassageiro servicePassageiro;

    @Mock
    RepositoryPassageiro repositorypassageiro;

    @Test
    public void testValidarLogin() throws Exception {
        Passageiro passageiro = new Passageiro();
        passageiro.setEmailPassageiro("test@example.com");
        passageiro.setSenhaPassageiro("Classico-12345");

        Passageiro passageiroRegistrado = new Passageiro();
        passageiroRegistrado.setEmailPassageiro("test@example.com");
        passageiroRegistrado.setSenhaPassageiro("12345");

        Mockito.when(repositorypassageiro.findByEmailPassageiroAndSenhaPassageiro(passageiro.getEmailPassageiro(),passageiro.getSenhaPassageiro())).thenReturn(passageiroRegistrado);

        var result = servicePassageiro.findByEmailPassageiroAndSenhaPassageiro(passageiro.getEmailPassageiro(),passageiro.getSenhaPassageiro());

        try {
            Assertions.assertEquals(result.getEmailPassageiro(), passageiro.getEmailPassageiro());
            Assertions.assertEquals(result.getSenhaPassageiro(), passageiro.getSenhaPassageiro());
        } catch (AssertionError e) {
            System.err.println("Email ou senha diferente.");
            throw e;
        }
        try {
            Assertions.assertNotNull(result.getSenhaPassageiro());
        } catch (AssertionError e) {
            System.err.println("Senha não preenchida.");
            throw e;
        }
    }
}
