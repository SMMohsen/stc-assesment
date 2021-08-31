package com.stc.assesment.controller;

import com.stc.assesment.dto.AppointmentDTO;
import com.stc.assesment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patient")
public class PatientController {
    
    @Autowired
    private PatientService patientService;
    
    @GetMapping("/appointment/{patientId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppointmentDTO> getAppointmentHistory(@PathVariable Long patientId) {
        List<AppointmentDTO> appointmentDTOS = patientService.getAllAppointmentsByPatientId(patientId);
        return appointmentDTOS;
    }

    @GetMapping("/appointment/by-name")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppointmentDTO> getAppointmentHistory(@RequestParam String patientName) {
        List<AppointmentDTO> appointmentDTOS = patientService.getAllAppointmentsByPatientName(patientName);
        return appointmentDTOS;
    }
    
    

}
