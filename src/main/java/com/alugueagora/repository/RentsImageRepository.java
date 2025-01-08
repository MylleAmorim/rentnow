package com.alugueagora.repository;

import com.rentNow.model.RentsImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RentsImageRepository extends JpaRepository<RentsImageModel, UUID> {
}
