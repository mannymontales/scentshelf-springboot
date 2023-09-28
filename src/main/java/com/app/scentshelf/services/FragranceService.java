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

    public Fragrance createFragrance(Fragrance fragrance) {
        return repository.save(fragrance);
    }

    public Fragrance updateFragrance(Long id, Fragrance newFragranceData) {

        Fragrance originalFragrance = repository.findById(id).get();

        originalFragrance.setName(newFragranceData.getName());
        originalFragrance.setBrand(newFragranceData.getBrand());
        originalFragrance.setImage_url(newFragranceData.getImage_url());
        originalFragrance.setNotes(newFragranceData.getNotes());

        return repository.save(originalFragrance);
    }

    public Boolean deleteFragrance(Long id) {
        repository.deleteById(id);
        return true;
    }

}

