package com.barbearia.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public void enviarEmailConfirmacao(String destinatario, String nomeCliente, String servico, String dataHora) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom(remetente);
        mensagem.setTo(destinatario);
        mensagem.setSubject("Confirmação de Agendamento - Barbearia");
        mensagem.setText("Olá, " + nomeCliente + "!\n\n"
                + "O seu agendamento foi confirmado com sucesso.\n"
                + "Serviço: " + servico + "\n"
                + "Horário: " + dataHora + "\n\n"
                + "Obrigado pela preferência!");

        mailSender.send(mensagem);
    }
}