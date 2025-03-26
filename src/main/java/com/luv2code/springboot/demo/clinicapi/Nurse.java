package com.luv2code.springboot.demo.clinicapi;

public class Nurse {
    private String name;
    private String location;

    public Nurse(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Nurse() {
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void helpDoctor() {
        System.out.println("Helping the doctor");
    }
}
