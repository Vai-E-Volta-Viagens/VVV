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
public class VerificaEmailExistente extends TestBase{

    @InjectMocks
    private ServicePassageiro servicePassageiro;

    @Mock
    RepositoryPassageiro repositorypassageiro;

    @Test
    public void testRealizarCadastro() throws Exception {
        Passageiro passageiro = new Passageiro();
        passageiro.setEmailPassageiro("test@example.com");
        passageiro.setSenhaPassageiro("Classico-12345");
        passageiro.setSobrenomePassageiro("Dias");
        passageiro.setDataDeNascimentoPassageiro(LocalDate.of(2001, 03, 30));
        passageiro.setNacionalidadePassageiro("Brasileiro");
        passageiro.setProfissaoPassageiro("Programador");
        passageiro.setSexoPassageiro("Masculino");

        Passageiro passageiroSimul = new Passageiro();
        passageiroSimul.setEmailPassageiro("test@exam.com");

        Mockito.when(repositorypassageiro.findByEmailPassageiro(passageiro.getEmailPassageiro())).thenReturn(passageiroSimul);

        var result = servicePassageiro.findByEmailPassageiro(passageiro.getEmailPassageiro());

        try {
            Assertions.assertNotEquals(result.getEmailPassageiro(), passageiro.getEmailPassageiro());
        }catch (AssertionError e) {
            System.err.println("Os emails dos passageiros são iguais.");
            throw e;
        }
        try {
            Assertions.assertNotNull(result.getSenhaPassageiro());
        }catch (AssertionError e) {
            System.err.println("Senha não preenchida.");
            throw e;
        }
    }

    @Test
    public void testNaoRealizarCadastro() throws Exception {
        Passageiro passageiro = new Passageiro();
        passageiro.setEmailPassageiro("test@example.com");
        passageiro.setSobrenomePassageiro("Dias");
        passageiro.setDataDeNascimentoPassageiro(LocalDate.of(2001, 03, 30));
        passageiro.setNacionalidadePassageiro("Brasileiro");
        passageiro.setProfissaoPassageiro("Programador");
        passageiro.setSexoPassageiro("Masculino");

        Passageiro passageiroSimul = new Passageiro();

        passageiroSimul.setEmailPassageiro("test@example.com");

        Mockito.when(repositorypassageiro.findByEmailPassageiro(passageiro.getEmailPassageiro())).thenReturn(passageiroSimul);
        var result = servicePassageiro.findByEmailPassageiro(passageiro.getEmailPassageiro());

        try {
            Assertions.assertNotEquals(result.getEmailPassageiro(), passageiro.getEmailPassageiro());
        }catch (AssertionError e) {
            System.err.println("E-mail já cadastrado.");
            throw e;
        }
        try {
            Assertions.assertNotNull(passageiro.getSenhaPassageiro());
        }catch (AssertionError e) {
            System.err.println("Senha não preenchida.");
            throw e;
        }
    }
}