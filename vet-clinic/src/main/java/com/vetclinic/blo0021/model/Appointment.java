package com.vetclinic.blo0021.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentID;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(length = 500)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "doctorID", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "petID", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "illnessID", nullable = true)
    private Illness illness;

    @ManyToOne
    @JoinColumn(name = "medicineID", nullable = true)
    private Medicine medicine;
}
