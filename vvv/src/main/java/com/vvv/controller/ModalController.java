/*package com.vvv.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/modal")
public class ModalController {
    
    String apiUrl = "http://localhost:8081/modal";

    private final WebClient webClient;

    public ModalController(WebClient webClient) {

        this.webClient = webClient;

    }

    @GetMapping("/verificastatus/{registro}")
    public Mono<String> verificaStatusModais(@PathVariable("registro") String registro) {

        return webClient.get()
                .uri(apiUrl + "/verificastatus/" + registro)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<String>() {
                });

    }

}*/