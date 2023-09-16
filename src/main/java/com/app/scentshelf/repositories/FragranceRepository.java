package com.app.scentshelf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.scentshelf.models.Fragrance;

public interface FragranceRepository extends JpaRepository<Fragrance, Long> {
}