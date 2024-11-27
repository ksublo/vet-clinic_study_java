package com.vetclinic.blo0021.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "Host")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostID;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(length = 50)
    private String email;
}
