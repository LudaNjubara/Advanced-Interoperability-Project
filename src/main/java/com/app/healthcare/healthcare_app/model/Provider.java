package com.app.healthcare.healthcare_app.model;

import com.app.healthcare.healthcare_app.request.ProviderRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Patient> patients;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Appointment> appointments;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String email;

    private String oib;

    private String imageUrl;

    public Provider(ProviderRequest providerRequest) {
        this.firstName = providerRequest.getFirstName();
        this.lastName = providerRequest.getLastName();
        this.address = providerRequest.getAddress();
        this.phoneNumber = providerRequest.getPhoneNumber();
        this.email = providerRequest.getEmail();
        this.oib = providerRequest.getOib();
        this.imageUrl = providerRequest.getImageUrl();
    }
}