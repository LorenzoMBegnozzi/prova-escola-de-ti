package com.example.demo.Entity;

import jakarta.persistence.*;
        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntityComputador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do computador é obrigaotrio")
    private String nome;

    @NotBlank(message = "A cor do computador é obrigatorio")
    private String cor;

    @NotNull(message = "a data de fabricaçao é obrigatoria")
    private LocalDate data;

    @OneToMany(mappedBy = "entityComputador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityPeriferico> perifericos;
}