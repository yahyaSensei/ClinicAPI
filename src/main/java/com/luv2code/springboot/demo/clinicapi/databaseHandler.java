package com.luv2code.springboot.demo.clinicapi;

import java.sql.*;

public class databaseHandler {
    String username;
    String password;
    String databaseName;
    Connection conn;
    public databaseHandler(String username, String password, String databaseName) {
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        String url = "jdbc:postgresql://localhost:5432/"+databaseName;
        String user = username;
        String pass = password;
        try {
            // Step 1: Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Step 2: Establish the connection
            this.conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to PostgreSQL!");

        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
        }
    }
    public String GetAllPatients() throws Exception {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM patients;");
            StringBuilder patientsJson = new StringBuilder();
            patientsJson.append("[");
            while (rs.next()) {
                patientsJson.append("{")
                    .append("\"id\":").append(rs.getInt(1)).append(",")
                    .append("\"name\":\"").append(rs.getString(2)).append("\",")
                    .append("\"otherField\":\"").append(rs.getString(3)).append("\"")
                    .append("},");
            }
            if (patientsJson.length() > 1) {
                patientsJson.setLength(patientsJson.length() - 1); // Remove trailing comma
            }
            patientsJson.append("]");
            return patientsJson.toString();
        }

    public void AddDoctor(int id, String name, String specialization, int workHours, int numberOfPatients) throws SQLException {
        String query = "CALL AddDoctor(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, specialization);
            stmt.setInt(4, workHours);
            stmt.setInt(5, numberOfPatients);
            stmt.execute();
        }
    }

    public void AddPatient(int id, String name, int fees) throws SQLException {
        String query = "CALL AddPatient(?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, fees);
            stmt.execute();
        }
    }

    public void AddWorker(int id, String name, int salary, String position) throws SQLException {
        String query = "CALL AddWorker(?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, salary);
            stmt.setString(4, position);
            stmt.execute();
        }
    }

    public void AddNurse(int id, String name, int doctorId, int salary) throws SQLException {
        String query = "CALL AddNurse(?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, doctorId);
            stmt.setInt(4, salary);
            stmt.execute();
        }
    }

    public void AddAppointment(int id, int doctorId, int patientId) throws SQLException {
        String query = "CALL AddAppointment(?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setInt(2, doctorId);
            stmt.setInt(3, patientId);
            stmt.execute();
        }
    }
    public String getAppointmens() throws SQLException {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM show_appointments();");
        StringBuilder appointmentsJson = new StringBuilder();
        appointmentsJson.append("[");
        while (rs.next()) {
            appointmentsJson.append("{")
                    .append("\"patientName\":\"").append(rs.getString(1)).append("\",")
                    .append("\"doctorName\":\"").append(rs.getString(5)).append("\",")
                    .append("\"dateAndTime\":\"").append(rs.getString(6)).append("\"")
                    .append("},");
        }
        if (appointmentsJson.length() > 1) {
            appointmentsJson.setLength(appointmentsJson.length() - 1); // Remove trailing comma
        }
        appointmentsJson.append("]");
        return appointmentsJson.toString();
    }
}
