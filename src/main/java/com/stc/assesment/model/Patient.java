package com.stc.assesment.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "patient",schema = "stc_assesment")
@Entity
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
