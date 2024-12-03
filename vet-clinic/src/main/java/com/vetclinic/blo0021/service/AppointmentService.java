package com.vetclinic.blo0021.service;

import com.vetclinic.blo0021.model.Appointment;
import com.vetclinic.blo0021.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Fetch all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Add a new appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Find an appointment by ID
    public Appointment getAppointmentById(int appointmentID) {
        return appointmentRepository.findById(appointmentID)
                .orElseThrow(() -> new RuntimeException("Appointment not found!"));
    }

    // Update an appointment
    public Appointment updateAppointment(int appointmentID, Appointment updatedAppointment) {
        Appointment appointment = getAppointmentById(appointmentID);
        appointment.setDateTime(updatedAppointment.getDateTime());
        appointment.setNotes(updatedAppointment.getNotes());
        appointment.setDoctor(updatedAppointment.getDoctor());
        appointment.setPet(updatedAppointment.getPet());
        appointment.setIllness(updatedAppointment.getIllness());
        appointment.setMedicine(updatedAppointment.getMedicine());
        return appointmentRepository.save(appointment);
    }

    // Delete an appointment
    public void deleteAppointment(int appointmentID) {
        appointmentRepository.deleteById(appointmentID);
    }
}
