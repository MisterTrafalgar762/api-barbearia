package com.barbearia.api.controller;

import com.barbearia.api.model.Barbeiro;
import com.barbearia.api.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @GetMapping
    public List<Barbeiro> listar() {
        return barbeiroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbeiro> buscarPorId(@PathVariable Integer id) {
        return barbeiroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Barbeiro criar(@RequestBody Barbeiro barbeiro) {
        return barbeiroService.salvar(barbeiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barbeiro> atualizar(
            @PathVariable Integer id,
            @RequestBody Barbeiro barbeiro) {

        return barbeiroService.buscarPorId(id)
                .map(existente -> {
                    barbeiro.setIdBarbeiro(id);
                    return ResponseEntity.ok(barbeiroService.salvar(barbeiro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        if (barbeiroService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        barbeiroService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}