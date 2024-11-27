package com.vetclinic.blo0021.controller;

import com.vetclinic.blo0021.model.Appointment;
import com.vetclinic.blo0021.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Add a new appointment
    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    // Get a specific appointment by ID
    @GetMapping("/{appointmentID}")
    public Appointment getAppointmentById(@PathVariable Long appointmentID) {
        return appointmentService.getAppointmentById(appointmentID);
    }

    // Update an appointmentt
    @PutMapping("/{appointmentID}")
    public Appointment updateAppointment(@PathVariable Long appointmentID, @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateAppointment(appointmentID, updatedAppointment);
    }

    // Delete an appointment
    @DeleteMapping("/{appointmentID}")
    public void deleteAppointment(@PathVariable Long appointmentID) {
        appointmentService.deleteAppointment(appointmentID);
    }
}
