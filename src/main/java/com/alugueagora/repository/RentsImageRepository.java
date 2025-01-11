package com.alugueagora.repository;

import com.rentNow.model.RentsImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentsImageRepository extends JpaRepository<RentsImageModel, UUID> {
}
