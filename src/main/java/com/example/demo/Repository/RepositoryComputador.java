package com.example.demo.Repository;

import com.example.demo.Entity.EntityComputador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryComputador extends JpaRepository<EntityComputador, Long> {
}