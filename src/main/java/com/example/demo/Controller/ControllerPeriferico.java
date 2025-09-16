package com.example.demo.Controller;

import com.example.demo.Dto.PerifericoDTO;
import com.example.demo.Service.ServicePeriferico;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perifericos")
public class ControllerPeriferico {
    private final ServicePeriferico servicePeriferico;

    public ControllerPeriferico(ServicePeriferico servicePeriferico) {
        this.servicePeriferico = servicePeriferico;
    }

    @PostMapping
    public PerifericoDTO criar(@Valid @RequestBody PerifericoDTO dto) {
        return servicePeriferico.salvar(dto);
    }

    @GetMapping
    public List<PerifericoDTO> listar() {
        return servicePeriferico.listar();
    }

    @PutMapping("/{id}")
    public PerifericoDTO atualizar(@PathVariable Long id, @Valid @RequestBody PerifericoDTO dto) {
        return servicePeriferico.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        servicePeriferico.excluir(id);
    }
}