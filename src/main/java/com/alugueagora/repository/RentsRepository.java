package com.alugueagora.repository;

import com.rentNow.model.RentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentsRepository extends JpaRepository<RentsModel, UUID> {

}
