package com.luv2code.springboot.demo.clinicapi;
public class Receptionist {
    private String name;
    private String location;

    public Receptionist(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Receptionist() {
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void manageAppointments() {
        System.out.println("Managing appointments");
    }

    public void registerNewPatients() {
        System.out.println("Registering new patients");
    }

    public void updatePatientInformation() {
        System.out.println("Updating patient information");
    }

    public void checkDoctorAvailability() {
        System.out.println("Checking doctor availability");
    }
}
