package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Facility;
import com.app.healthcare.healthcare_app.repository.FacilityRepository;
import com.app.healthcare.healthcare_app.request.FacilityPostRequest;
import com.app.healthcare.healthcare_app.request.FacilityPutRequest;
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
    public Facility createFacility(FacilityPostRequest facilityReq) {
        Facility facility = new Facility(facilityReq);
        return facilityRepository.save(facility);
    }

    @Override
    public Facility updateFacility(Long id, FacilityPutRequest facilityReq) {
        Optional<Facility> optionalFacility = facilityRepository.findById(id);
        if (optionalFacility.isPresent()) {
            Facility facilityToUpdate = optionalFacility.get();

            facilityToUpdate.setName(facilityReq.getName());
            facilityToUpdate.setAddress(facilityReq.getAddress());
            facilityToUpdate.setEmail(facilityReq.getEmail());
            facilityToUpdate.setImageUrl(facilityReq.getImageUrl());

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
