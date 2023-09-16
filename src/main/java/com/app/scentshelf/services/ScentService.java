package com.app.scentshelf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.scentshelf.models.Scent;
import com.app.scentshelf.repositories.ScentRepository;

@Service
public class ScentService {

    private final ScentRepository repository;

    @Autowired
    public ScentService(ScentRepository repository) {
        this.repository = repository;
    }

    public List<Scent> getAllEntities() {
        return repository.findAll();
    }

    public Scent get(Long id) {
        return repository.findById(id).get();
    }
}
