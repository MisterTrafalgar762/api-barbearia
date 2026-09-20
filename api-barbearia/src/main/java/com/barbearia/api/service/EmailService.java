package com.barbearia.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.Agendamento;

@Service
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    public void enviarEmailConfirmacao(Agendamento agendamento) {
        if (mailSender == null) {
            System.out.println("Serviço de e-mail não configurado no ambiente local.");
            return;
        }

        if (agendamento == null || agendamento.getCliente() == null) {
            System.out.println("Agendamento ou Cliente não fornecido para envio de e-mail.");
            return;
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("barbearia@api.com");
            message.setTo(agendamento.getCliente().getEmail());
            message.setSubject("Confirmação de Agendamento - Barbearia");
            message.setText("Olá " + agendamento.getCliente().getNome() + ",\n\n" +
                    "O seu agendamento foi realizado com sucesso!\n" +
                    "Data e Hora: " + agendamento.getDataHora() + "\n\n" +
                    "Obrigado por escolher os nossos serviços!");

            mailSender.send(message);
            System.out.println("E-mail de confirmação enviado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}