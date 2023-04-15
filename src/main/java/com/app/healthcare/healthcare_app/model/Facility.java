package com.app.healthcare.healthcare_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "facility")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String email;

    private String imageUrl;

    @OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Provider> providers;

    @OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Patient> patients;


    public Facility(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
}
