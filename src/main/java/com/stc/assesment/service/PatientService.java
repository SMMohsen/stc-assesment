package com.stc.assesment.service;

import com.stc.assesment.dto.AppointmentDTO;
import com.stc.assesment.model.Appointment;
import com.stc.assesment.model.Patient;
import com.stc.assesment.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientRepository patientRepository;

    public List<AppointmentDTO> getAllAppointmentsByPatientId(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(IllegalArgumentException::new);
        return patient.getAppointments().stream().map(a -> modelMapper.map(a,AppointmentDTO.class)).collect(Collectors.toList());
    }


    public List<AppointmentDTO> getAllAppointmentsByPatientName(String patientName) {
        Patient patient = patientRepository.findByNameIgnoreCase(patientName).orElse(new Patient());
        return patient.getAppointments().stream().map(a -> modelMapper.map(a,AppointmentDTO.class)).collect(Collectors.toList());
    }


}
