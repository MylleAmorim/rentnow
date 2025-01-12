package com.alugueagora.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table (name= "rents_image")
public class RentsImageModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "rent_image_id")
    private UUID id;

    @Column(name = "rent_id")
    private String rentId;

    private String path;

}
