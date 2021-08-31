package com.stc.assesment.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "appointment" ,schema = "stc_assesment")
@Entity
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "status")
    private String status;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}
