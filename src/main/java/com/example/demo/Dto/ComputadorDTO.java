package com.example.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComputadorDTO {
    private Long id;

    @NotBlank(message = "O nome do computador é obrigatório")
    private String nome;

    @NotBlank(message = "A cor do computador é obrigatória")
    private String cor;

    @NotNull(message = "A data de fabricação é obrigatória")
    private LocalDate data;
}