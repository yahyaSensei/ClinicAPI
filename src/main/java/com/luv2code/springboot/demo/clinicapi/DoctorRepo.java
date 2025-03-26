package com.luv2code.springboot.demo.clinicapi;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {}