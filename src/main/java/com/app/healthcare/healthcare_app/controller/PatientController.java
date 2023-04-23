package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Patient;
import com.app.healthcare.healthcare_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/patients")
@RestController
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping(params = "facilityId")
    public List<Patient> getAllPatientsByFacilityId(@RequestParam Long facilityId) {
        return patientService.getAllPatientsByFacilityId(facilityId);
    }

    @GetMapping(params = "providerId")
    public List<Patient> getAllPatientsByProviderId(@RequestParam Long providerId) {
        return patientService.getAllPatientsByProviderId(providerId);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
