package com.alugueagora.service;

import com.rentNow.model.Rents;
import com.alugueagora.repository.RentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RentsService {

    @Autowired
    private RentsRepository rentsRepository;

    public List<Rents> findAll() {
        return rentsRepository.findAll();
    }

    public Optional<Rents> findById(UUID id) {
        return rentsRepository.findById(id);
    }

    public Rents save(RentsService rents) {
        return rentsRepository.save(rents);
    }

    public void deleteById(UUID id) {
        rentsRepository.deleteById(id);
    }
}