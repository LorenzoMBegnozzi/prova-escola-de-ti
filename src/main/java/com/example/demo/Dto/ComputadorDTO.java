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
public class ComputadorDTO {
    private Long id;

    @NotBlank(message = "O nome do computador é obrigaotrio")
    private String nome;

    @NotBlank(message = "A cor do computador é obrigatorio")
    private String cor;

    @NotBlank(message = "a data de fabricaçao é obrigatoria")
    private Data data;
}