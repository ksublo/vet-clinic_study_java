package com.vetclinic.blo0021.controller;

import com.vetclinic.blo0021.model.Appointment;
import com.vetclinic.blo0021.model.Doctor;
import com.vetclinic.blo0021.model.Host;
import com.vetclinic.blo0021.model.Pet;
import com.vetclinic.blo0021.repository.DoctorRepository;
import com.vetclinic.blo0021.repository.PetRepository;
import com.vetclinic.blo0021.service.AppointmentService;
import com.vetclinic.blo0021.service.DoctorService;
import com.vetclinic.blo0021.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PetRepository petRepository;

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Add a new appointment
    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        int doctorID = appointment.getDoctor().getDoctorID();
        Doctor doctor = doctorRepository.findById(doctorID)
                .orElseThrow(() -> new NoSuchElementException("Doctor not found with id " + doctorID));

        int petID = appointment.getPet().getPetID();
        Pet pet = petRepository.findById(petID)
                .orElseThrow(() -> new NoSuchElementException("Pet not found with id " + petID));


        appointment.setDoctor(doctor);
        appointment.setPet(pet);

        return appointmentService.saveAppointment(appointment);
    }


    // Get a specific appointment by ID
    @GetMapping("/{appointmentID}")
    public Appointment getAppointmentById(@PathVariable int appointmentID) {
        return appointmentService.getAppointmentById(appointmentID);
    }

    // Update an appointment
    @PutMapping("/{appointmentID}")
    public Appointment updateAppointment(@PathVariable int appointmentID, @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateAppointment(appointmentID, updatedAppointment);
    }

    // Delete an appointment
    @DeleteMapping("/{appointmentID}")
    public void deleteAppointment(@PathVariable int appointmentID) {
        appointmentService.deleteAppointment(appointmentID);
    }
}
