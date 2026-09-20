package com.barbearia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.Agendamento;
import com.barbearia.api.repository.AgendamentoRepository;
import com.barbearia.api.service.EmailService;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private EmailService emailService;

    public Agendamento salvar(Agendamento agendamento) {
        // 1. Salva o agendamento na base de dados
        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        
       
        emailService.enviarEmailConfirmacao(agendamentoSalvo);
        
        return agendamentoSalvo;
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }
}