package com.stc.assesment.repository;

import com.stc.assesment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    public Optional<Patient> findByNameIgnoreCase(String name);
}
