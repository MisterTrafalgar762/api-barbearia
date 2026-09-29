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
    private BarbeiroRepository barbeiroRepository;

    public List<Barbeiro> listarTodos() {
        return barbeiroRepository.findAll();
    }

    public Optional<Barbeiro> buscarPorId(Integer id) {
        return barbeiroRepository.findById(id);
    }

    public Barbeiro salvar(Barbeiro barbeiro) {
        return barbeiroRepository.save(barbeiro);
    }

    public void excluir(Integer id) {
        barbeiroRepository.deleteById(id);
    }
}