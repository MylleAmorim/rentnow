package com.alugueagora.repository;

import com.rentNow.model.Rents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentsRepository extends JpaRepository<Rents, UUID> {

}
