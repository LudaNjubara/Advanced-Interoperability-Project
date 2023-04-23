package com.app.healthcare.healthcare_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private FacilityDTO facility;
    private PatientDTO patient;
    private ProviderDTO provider;
    private LocalDate appointmentDate;
    private String description;
}
