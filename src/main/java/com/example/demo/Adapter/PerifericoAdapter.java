package com.example.demo.Adapter;

import com.example.demo.Dto.PerifericoDTO;
import com.example.demo.Entity.EntityComputador;
import com.example.demo.Entity.EntityPeriferico;

public class PerifericoAdapter {

    public static PerifericoDTO toDTO(EntityPeriferico entityPeriferico) {
        return PerifericoDTO.builder()
                .id(entityPeriferico.getId())
                .nome(entityPeriferico.getNome())
                .computadorId(entityPeriferico.getEntityComputador() != null ? entityPeriferico.getEntityComputador().getId() : null)
                .ComputadorNome(entityPeriferico.getEntityComputador() != null ? entityPeriferico.getEntityComputador().getNome() : null)
                .build();
    }

    public static EntityPeriferico toEntity(PerifericoDTO dto, EntityComputador entityComputador) {
        return EntityPeriferico.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .entityComputador(entityComputador)
                .build();
    }
}