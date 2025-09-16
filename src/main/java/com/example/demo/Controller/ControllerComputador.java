package com.example.demo.Controller;

import com.example.demo.Dto.ComputadorDTO;
import com.example.demo.Service.ServiceComputador;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computadores")
public class ControllerComputador {
    private final ServiceComputador serviceComputador;

    public ControllerComputador(ServiceComputador serviceComputador) {
        this.serviceComputador = serviceComputador;
    }

    @PostMapping
    public ComputadorDTO criar(@Valid @RequestBody ComputadorDTO dto) {
        return serviceComputador.salvar(dto);
    }

    @GetMapping
    public List<ComputadorDTO> listar(){
        return serviceComputador.listar();
    }

    @PostMapping("/{id}")
    public ComputadorDTO atualizar(@PathVariable Long id, @Valid @RequestBody ComputadorDTO dto) {
        return serviceComputador.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        serviceComputador.excluir(id);
    }
}

