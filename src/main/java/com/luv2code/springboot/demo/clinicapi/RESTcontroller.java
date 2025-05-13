package com.luv2code.springboot.demo.clinicapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:63342") // Allow requests from your frontend origin
public class RESTcontroller {

    databaseHandler dbHandler = new databaseHandler("postgres", "postgres", "clinic");

    @GetMapping("/patients")
    public String getAllPatients() throws Exception {
        return dbHandler.GetAllPatients();
    }

    @PostMapping("/doctors")
    public void addDoctor(@RequestParam int id, @RequestParam String name, @RequestParam String specialization,
                          @RequestParam int workHours, @RequestParam int numberOfPatients) throws SQLException {
        dbHandler.AddDoctor(id, name, specialization, workHours, numberOfPatients);
    }

    @PostMapping("/patients")
    public void addPatient(@RequestParam int id, @RequestParam String name, @RequestParam int fees) throws SQLException {
        dbHandler.AddPatient(id, name, fees);
    }

    @PostMapping("/workers")
    public void addWorker(@RequestParam int id, @RequestParam String name, @RequestParam int salary,
                          @RequestParam String position) throws SQLException {
        dbHandler.AddWorker(id, name, salary, position);
    }

    @PostMapping("/nurses")
    public void addNurse(@RequestParam int id, @RequestParam String name, @RequestParam int doctorId,
                         @RequestParam int salary) throws SQLException {
        dbHandler.AddNurse(id, name, doctorId, salary);
    }

    @PostMapping("/appointments")
    public void addAppointment(@RequestParam int id, @RequestParam int doctorId, @RequestParam int patientId ,@RequestParam String date) throws SQLException {
        dbHandler.AddAppointment(id, doctorId, patientId, date);
    }

    @GetMapping("/allappointment")
    public String getAppointments() throws SQLException {
        return dbHandler.getAppointmens();
    }
    @GetMapping("/patients/fees-above")
    public String getPatientsWithFeesAbove(@RequestParam double minFees) throws SQLException {
        return dbHandler.getPatientsWithFeesAbove(minFees);
    }

    @GetMapping("/doctors/specialization-count")
    public String getDoctorCountBySpecialization(@RequestParam int minCount) throws SQLException {
        return dbHandler.getDoctorCountBySpecialization(minCount);
    }

    @GetMapping("/appointments/patient-doctor")
    public String getAppointmentsWithPatientAndDoctor() throws SQLException {
        return dbHandler.getAppointmentsWithPatientAndDoctor();
    }

    @GetMapping("/doctors/nurses")
    public String getDoctorsWithNurses() throws SQLException {
        return dbHandler.getDoctorsWithNurses();
    }

    @GetMapping("/patients/by-doctor")
    public String getPatientsByDoctor(@RequestParam int doctorId) throws SQLException {
        return dbHandler.getPatientsByDoctor(doctorId);
    }

    @GetMapping("/appointments/total")
    public int getTotalAppointments() throws SQLException {
        return dbHandler.getTotalAppointments();
    }

    @GetMapping("/doctors/total-fees")
    public String getTotalFeesByDoctor() throws SQLException {
        return dbHandler.getTotalFeesByDoctor();
    }

    @GetMapping("/workers/average-salary")
    public double getAverageWorkerSalary() throws SQLException {
        return dbHandler.getAverageWorkerSalary();
    }

    @GetMapping("/doctors/appointment-count")
    public String getDoctorsWithAppointmentCount() throws SQLException {
        return dbHandler.getDoctorsWithAppointmentCount();
    }
    @PostMapping("/patients/delete")
    public void deletePatient(@RequestParam int id) throws SQLException {
        dbHandler.DeletePatient(id);
    }

    @PostMapping("/patients/update")
    public void updatePatient(@RequestParam int id, @RequestParam String name, @RequestParam int fees) throws SQLException {
        dbHandler.UpdatePatient(id, name, fees);
    }
}