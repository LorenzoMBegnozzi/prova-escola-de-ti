package com.example.demo.Repository;

import com.example.demo.Entity.EntityPeriferico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPerifirico extends JpaRepository<EntityPeriferico, Long> {
}
