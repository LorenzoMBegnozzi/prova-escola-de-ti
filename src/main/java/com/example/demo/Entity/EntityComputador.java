package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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

    @NotBlank(message = "a data de fabricaçao é obrigatoria")
    private Data data;

    @OneToMany(mappedBy = "computador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityPeriferico> perifericos;
}
