package com.example.demo.Service;

import com.example.demo.Adapter.PerifericoAdapter;
import com.example.demo.Dto.PerifericoDTO;
import com.example.demo.Entity.EntityComputador;
import com.example.demo.Entity.EntityPeriferico;
import com.example.demo.Repository.RepositoryComputador;
import com.example.demo.Repository.RepositoryPerifirico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePeriferico {
    private final RepositoryPerifirico repositoryPerifirico;
    private final RepositoryComputador repositoryComputador;

    public ServicePeriferico(RepositoryPerifirico repositoryPerifirico, RepositoryComputador repositoryComputador) {
        this.repositoryPerifirico = repositoryPerifirico;
        this.repositoryComputador = repositoryComputador;
    }

    public PerifericoDTO salvar(PerifericoDTO dto) {
        EntityComputador entityComputador = repositoryComputador.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        EntityPeriferico entityPeriferico = PerifericoAdapter.toEntity(dto, entityComputador);
        return PerifericoAdapter.toDTO(repositoryPerifirico.save(produto));
    }

    public List<PerifericoDTO> listar() {
        return repositoryPerifirico.findAll()
                .stream()
                .map(repositoryPerifirico::toDTO)
                .collect(Collectors.toList());
    }

    public PerifericoDTO atualizar(Long id, PerifericoDTO dto) {
        EntityPeriferico existente = repositoryPerifirico.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        existente.setNome(dto.getNome());
        existente.setPreco(dto.getPreco());
        return PerifericoAdapter.toDTO(repositoryPerifirico.save(existente));
    }

    public void excluir(Long id) {
        repositoryPerifirico.deleteById(id);
    }
}



