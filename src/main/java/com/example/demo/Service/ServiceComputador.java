package com.example.demo.Service;

import com.example.demo.Adapter.ComputadorAdapter;
import com.example.demo.Dto.ComputadorDTO;
import com.example.demo.Entity.EntityComputador;
import com.example.demo.Repository.RepositoryComputador;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceComputador {

    private final RepositoryComputador repository;

    public ServiceComputador(RepositoryComputador repositoryComputador) {
        this.repository = repositoryComputador;
    }

    public ComputadorDTO salvar(ComputadorDTO dto) {
        EntityComputador entityComputador = ComputadorAdapter.ToEntity(dto);
        return ComputadorAdapter.toDTO(repository.save(entityComputador));
    }
    public List<ComputadorDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ComputadorAdapter::toDTO)
                .collect(Collectors.toList());
    }

    public ComputadorDTO atualizar(Long id, ComputadorDTO dto) {
        EntityComputador existente = (EntityComputador) repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        existente.setNome(dto.getNome());
        return ComputadorAdapter.toDTO(repository.save(existente));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
}
