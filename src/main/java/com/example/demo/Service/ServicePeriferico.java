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

    private final RepositoryPerifirico repositoryPeriferico;
    private final RepositoryComputador repositoryComputador;

    public ServicePeriferico(RepositoryPerifirico repositoryPeriferico,
                             RepositoryComputador repositoryComputador) {
        this.repositoryPeriferico = repositoryPeriferico;
        this.repositoryComputador = repositoryComputador;
    }

    public PerifericoDTO salvar(PerifericoDTO dto) {
        EntityComputador computador = repositoryComputador.findById(dto.getComputadorId())
                .orElseThrow(() -> new RuntimeException("computador não encontrado"));

        EntityPeriferico entity = PerifericoAdapter.toEntity(dto, computador);
        return PerifericoAdapter.toDTO(repositoryPeriferico.save(entity));
    }

    public List<PerifericoDTO> listar() {
        return repositoryPeriferico.findAll()
                .stream()
                .map(PerifericoAdapter::toDTO)
                .collect(Collectors.toList());
    }

    public PerifericoDTO atualizar(Long id, PerifericoDTO dto) {
        EntityPeriferico existente = repositoryPeriferico.findById(id)
                .orElseThrow(() -> new RuntimeException("periférico n encontrado"));

        existente.setNome(dto.getNome());

        if (dto.getComputadorId() != null) {
            EntityComputador computador = repositoryComputador.findById(dto.getComputadorId())
                    .orElseThrow(() -> new RuntimeException("computador n encontrado"));
            existente.setEntityComputador(computador);
        }

        return PerifericoAdapter.toDTO(repositoryPeriferico.save(existente));
    }

    public void excluir(Long id) {
        repositoryPeriferico.deleteById(id);
    }
}
