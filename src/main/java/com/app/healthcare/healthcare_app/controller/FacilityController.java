package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Facility;
import com.app.healthcare.healthcare_app.service.FacilityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/facilities")
@RestController
public class FacilityController {
    private final FacilityService facilityService;
    private final ModelMapper modelMapper;

    @Autowired
    public FacilityController(FacilityService facilityService, ModelMapper modelMapper) {
        this.facilityService = facilityService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable Long id) {
        return facilityService.getFacilityById(id);
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return facilityService.createFacility(facility);
    }

    @PutMapping("/{id}")
    public Facility updateFacility(@PathVariable Long id, @RequestBody Facility facility) {
        return facilityService.updateFacility(id, facility);
    }

    @DeleteMapping("/{id}")
    public void deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
    }
}
