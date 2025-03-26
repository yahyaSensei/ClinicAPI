package com.luv2code.springboot.demo.clinicapi;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @ManyToOne
    private Doctor doctor;

    public Patient(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void bookCancelAppointment() {
        System.out.println("Booking or cancelling appointment for " + name);
    }

    public void viewTestResults() {
        System.out.println("Viewing test results for " + name);
    }

    public void updatePersonalInformation() {
        System.out.println("Updating personal info for " + name);
    }

    public void viewMedicalRecords() {
        System.out.println("Viewing medical records for " + name);
    }

    public void receivePrescriptions() {
        System.out.println("Receiving prescription for " + name);
    }
}
