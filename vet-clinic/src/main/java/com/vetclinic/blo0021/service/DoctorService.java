package com.vetclinic.blo0021.service;

import com.vetclinic.blo0021.model.Doctor;
import com.vetclinic.blo0021.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Fetch all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Add a new doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Find a doctor by ID
    public Doctor getDoctorById(Long doctorID) {
        return doctorRepository.findById(doctorID).orElseThrow(() -> new RuntimeException("Doctor not found!"));
    }

    // Update a doctor's details
    public Doctor updateDoctor(Long doctorID, Doctor updatedDoctor) {
        Doctor doctor = getDoctorById(doctorID);
        doctor.setFirstName(updatedDoctor.getFirstName());
        doctor.setLastName(updatedDoctor.getLastName());
        doctor.setSpecialization(updatedDoctor.getSpecialization());
        return doctorRepository.save(doctor);
    }

    // Delete a doctor
    public void deleteDoctor(Long doctorID) {
        doctorRepository.deleteById(doctorID);
    }
}
