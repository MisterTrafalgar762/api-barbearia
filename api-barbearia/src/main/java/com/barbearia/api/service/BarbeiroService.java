package com.barbearia.api.service;

import com.barbearia.api.model.Barbeiro;
import com.barbearia.api.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository repository;

    public List<Barbeiro> listarTodos() {
        return repository.findAll();
    }

    public Optional<Barbeiro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Barbeiro salvar(Barbeiro barbeiro) {
        return repository.save(barbeiro);
    }

    public Barbeiro atualizar(Long id, Barbeiro barbeiroAtualizado) {
        return repository.findById(id).map(barbeiro -> {
            barbeiro.setNome(barbeiroAtualizado.getNome());
            barbeiro.setEmail(barbeiroAtualizado.getEmail());
            barbeiro.setTelefone(barbeiroAtualizado.getTelefone());
            barbeiro.setEspecialidade(barbeiroAtualizado.getEspecialidade());
            return repository.save(barbeiro);
        }).orElseThrow(() -> new RuntimeException("Barbeiro não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Barbeiro não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}