package com.stc.assesment.repository;

import com.stc.assesment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    public List<Appointment> findByAppointmentDate(LocalDate date);

}
