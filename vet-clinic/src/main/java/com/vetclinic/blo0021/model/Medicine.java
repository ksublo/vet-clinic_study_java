package com.vetclinic.blo0021.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicineID;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;
}
