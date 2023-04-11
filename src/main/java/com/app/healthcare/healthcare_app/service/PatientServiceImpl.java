package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Patient;
import com.app.healthcare.healthcare_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new RuntimeException("Patient not found with id: " + id);
        }
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patientToUpdate = optionalPatient.get();

            patientToUpdate.setFirstName(patient.getFirstName());
            patientToUpdate.setLastName(patient.getLastName());
            patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
            patientToUpdate.setAddress(patient.getAddress());
            patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
            patientToUpdate.setFacility(patient.getFacility());
            patientToUpdate.setOib(patient.getOib());
            patientToUpdate.setImageUrl(patient.getImageUrl());

            patient.setId(id);
            return patientRepository.save(patientToUpdate);
        } else {
            throw new RuntimeException("Patient not found with id: " + id);
        }
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
