package com.example.demo.Adapter;

import com.example.demo.Dto.ComputadorDTO;
import com.example.demo.Entity.EntityComputador;

public class ComputadorAdapter {

    public static ComputadorDTO toDTO(EntityComputador entityComputador) {
        return ComputadorDTO.builder()
                .id(entityComputador.getId())
                .nome(entityComputador.getNome())
                .cor(entityComputador.getCor())
                .data(entityComputador.getData())
                .build();
    }

    public static EntityComputador ToEntity(ComputadorDTO dto) {
        return EntityComputador.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .cor(dto.getCor())
                .data(dto.getData())
                .build();
    }
}
