package com.example.demo.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerifericoDTO {
    private Long id;

    @NotBlank(message = "O nome do periferico é obrigatório")
    private String nome;

    private Long computadorId;

    private String ComputadorNome;
}
