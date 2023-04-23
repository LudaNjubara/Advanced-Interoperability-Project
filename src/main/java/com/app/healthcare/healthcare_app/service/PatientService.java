package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    List<Patient> getAllPatientsByFacilityId(Long facilityId);

    List<Patient> getAllPatientsByProviderId(Long providerId);

    Patient getPatientById(Long id);

    Patient createPatient(Patient patient);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);
}
