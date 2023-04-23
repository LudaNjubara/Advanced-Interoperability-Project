package com.app.healthcare.healthcare_app.repository;

import com.app.healthcare.healthcare_app.model.Appointment;
import com.app.healthcare.healthcare_app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Patient> getAllAppointmentsByProviderId(Long providerId);
}
