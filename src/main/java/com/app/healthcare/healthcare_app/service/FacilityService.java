package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Facility;

import java.util.List;

public interface FacilityService {
    List<Facility> getAllFacilities();

    Facility getFacilityById(Long id);

    Facility createFacility(Facility facility);

    Facility updateFacility(Long id, Facility facility);

    void deleteFacility(Long id);
}
