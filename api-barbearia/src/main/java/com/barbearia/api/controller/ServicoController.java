package com.barbearia.api.controller;

import com.barbearia.api.model.Servico;
import com.barbearia.api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> listar() {
        return servicoService.listarTodos();
    }

    @PostMapping
    public Servico criar(@RequestBody Servico servico) {
        return servicoService.salvar(servico);
    }
}