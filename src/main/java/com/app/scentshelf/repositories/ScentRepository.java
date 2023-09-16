package com.app.scentshelf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.scentshelf.models.Scent;

public interface ScentRepository extends JpaRepository<Scent, Long> {
}

