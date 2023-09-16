package com.app.scentshelf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.scentshelf.models.Fragrance;
import com.app.scentshelf.repositories.FragranceRepository;

@Service
public class FragranceService {
    private final FragranceRepository repository;

    @Autowired
    public FragranceService(FragranceRepository repository) {
        this.repository = repository;
    }

    public List<Fragrance> getAllEntities() {
        return repository.findAll();
    }

    public Fragrance get(Long id) {
        return repository.findById(id).get();
    }

}

