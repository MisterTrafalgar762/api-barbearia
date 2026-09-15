package com.barbearia.api.controller;

import com.barbearia.api.model.Servico;
import com.barbearia.api.repository.ServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public List<Servico> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Servico salvar(@Valid @RequestBody Servico servico) {
        return repository.save(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @Valid @RequestBody Servico servicoAtualizado) {
        return repository.findById(id)
                .map(servico -> {
                    servico.setNome(servicoAtualizado.getNome());
                    servico.setPreco(servicoAtualizado.getPreco());
                    Servico atualizado = repository.save(servico);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}