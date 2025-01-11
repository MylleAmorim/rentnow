package com.alugueagora.service;

import com.rentNow.model.RentsModel;
import com.alugueagora.repository.RentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
public class RentsService {

    @Autowired
    private RentsRepository rentsRepository;

    public List<RentsModel> findAll() {

        return rentsRepository.findAll();
    }

    public Optional<RentsModel> findById(UUID id) {
        return rentsRepository.findById(id);
    }

    public RentsModel save(RentsModel rents) {
        return rentsRepository.save(rents);
    }

    public void delete(UUID id) {
        rentsRepository.deleteById(id);
    }
}