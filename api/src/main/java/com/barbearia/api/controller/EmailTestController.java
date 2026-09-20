package com.barbearia.api.controller;

import com.barbearia.api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste-email")
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<String> testarEnvio(
            @RequestParam(defaultValue = "yyanngoncalves@gmail.com") String para) {
        try {
            emailService.enviarEmailConfirmacao(
                    para,
                    "Cliente Teste",
                    "Corte e Barba",
                    "25/09/2026 às 15:00"
            );
            return ResponseEntity.ok("E-mail enviado com sucesso para: " + para);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}