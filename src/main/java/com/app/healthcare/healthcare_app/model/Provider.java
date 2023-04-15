package com.app.healthcare.healthcare_app.model;

import com.app.healthcare.healthcare_app.request.ProviderRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private Facility facility;

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