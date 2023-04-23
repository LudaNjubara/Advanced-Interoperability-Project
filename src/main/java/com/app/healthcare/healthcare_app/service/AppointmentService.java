package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Appointment;
import com.app.healthcare.healthcare_app.model.Patient;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    List<Patient> getAllAppointmentsByProviderId(Long providerId);

    Appointment getAppointmentById(Long id);

    Appointment createAppointment(Appointment appointment);

    Appointment updateAppointment(Long id, Appointment appointment);

    void deleteAppointment(Long id);


}
