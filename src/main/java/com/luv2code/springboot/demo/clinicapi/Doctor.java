package com.luv2code.springboot.demo.clinicapi;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients = new ArrayList<>();

    public Doctor() {
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        if (patient != null && !patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void viewPatientList() {
        System.out.println("Viewing patient list for " + name);
    }

    public void viewMedicalRecords() {
        System.out.println("Viewing medical records for " + name);
    }

    public void addOrUpdateDiagnosis() {
        System.out.println("Adding/Updating diagnosis");
    }

    public void prescribeMedication() {
        System.out.println("Prescribing medication");
    }

    public void requestMedicalTests() {
        System.out.println("Requesting medical tests");
    }
}
