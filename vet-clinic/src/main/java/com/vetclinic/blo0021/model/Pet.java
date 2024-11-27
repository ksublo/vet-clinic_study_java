package com.vetclinic.blo0021.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "Pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petID;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String species;

    @Column(length = 20)
    private String breed;

    private Integer age;

    @Column(nullable = false)
    private Character sex;

    private Float weight;

    @ManyToOne
    @JoinColumn(name = "hostID", nullable = false)
    private Host host;
}
