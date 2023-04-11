package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Facility;
import com.app.healthcare.healthcare_app.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    @Autowired
    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility getFacilityById(Long id) {
        Optional<Facility> optionalFacility = facilityRepository.findById(id);
        if (optionalFacility.isPresent()) {
            return optionalFacility.get();
        } else {
            throw new RuntimeException("Facility not found with id: " + id);
        }
    }

    @Override
    public Facility createFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public Facility updateFacility(Long id, Facility facility) {
        Optional<Facility> optionalFacility = facilityRepository.findById(id);
        if (optionalFacility.isPresent()) {
            Facility facilityToUpdate = optionalFacility.get();

            facilityToUpdate.setName(facility.getName());
            facilityToUpdate.setAddress(facility.getAddress());
            facilityToUpdate.setEmail(facility.getEmail());
            facilityToUpdate.setImageUrl(facility.getImageUrl());

            return facilityRepository.save(facilityToUpdate);
        } else {
            throw new RuntimeException("Facility not found with id: " + id);
        }
    }

    @Override
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }
}
