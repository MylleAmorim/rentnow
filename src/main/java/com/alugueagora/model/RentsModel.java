package com.alugueagora.model;


import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "rents",schema = "public")
public class RentsModel {
    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private UUID id;

    @Column(name = "description")
    private Double description;

    @Column(name = "summary")
    private Double summary;

    @Column(name = "rent_price")
    private Double price;

    @Column(name = "rent_condominium")
    private Double condominium;

    private Double fees;

    @Column(name = "create_at")
    private Timestamp createAt;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCondominium() {
        return condominium;
    }

    public void setCondominium(Double condominium) {
        this.condominium = condominium;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Double getDescription() {
        return description;
    }

    public void setDescription(Double description) {
        this.description = description;
    }

    public Double getSummary() {
        return summary;
    }

    public void setSummary(Double summary) {
        this.summary = summary;
    }
}

