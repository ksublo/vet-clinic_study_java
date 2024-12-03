package com.vetclinic.blo0021.controller;

import com.vetclinic.blo0021.model.Doctor;
import com.vetclinic.blo0021.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Add a new doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    // Get a specific doctor by ID
    @GetMapping("/{doctorID}")
    public Doctor getDoctorById(@PathVariable int doctorID) {
        return doctorService.getDoctorById(doctorID);
    }

    // Update a doctor's details
    @PutMapping("/{doctorID}")
    public Doctor updateDoctor(@PathVariable int doctorID, @RequestBody Doctor updatedDoctor) {
        return doctorService.updateDoctor(doctorID, updatedDoctor);
    }

    // Delete a doctor
    @DeleteMapping("/{doctorID}")
    public void deleteDoctor(@PathVariable int doctorID) {
        doctorService.deleteDoctor(doctorID);
    }
}
