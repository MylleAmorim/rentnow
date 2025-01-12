package com.alugueagora.service;

import com.alugueagora.repository.RentsImageRepository;
import com.alugueagora.model.RentsImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RentsImageService {

    @Autowired
    private RentsImageRepository rentsImageRepository;

    public RentsImageModel save(RentsImageModel rents) {
        return rentsImageRepository.save(rents);
    }

    public List<RentsImageModel> findAll() {
        return rentsImageRepository.findAll();
    }

    public Optional<RentsImageModel> findById(UUID id) {
        return rentsImageRepository.findById(id);
    }

    public void delete(UUID id) {
        rentsImageRepository.deleteById(id);
    }
}
