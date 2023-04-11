package com.app.healthcare.healthcare_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facility")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    public Facility(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
}
