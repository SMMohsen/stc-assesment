package com.stc.assesment.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.stc.assesment.constant.AppointmentStatus;
import com.stc.assesment.constant.CancellationReason;
import com.stc.assesment.dto.AppointmentDTO;
import com.stc.assesment.model.Appointment;
import com.stc.assesment.repository.AppointmentRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentRepository appointmentRepository;




    public List<AppointmentDTO> getAllAppointmentsByToday() {
        List<Appointment> appointments = appointmentRepository.findByAppointmentDate(LocalDate.now());
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        return appointments.stream().map(a -> modelMapper.map(a,AppointmentDTO.class)).collect(Collectors.toList());
    }

    public Long createNewAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = modelMapper.map(appointmentDTO,Appointment.class);
        appointment.setStatus(AppointmentStatus.ACTIVE.toString());
        appointmentRepository.save(appointment);
        return appointment.getId();
    }

    public List<AppointmentDTO> getAllAppointmentsByDate(LocalDate date) {
        List<Appointment> appointments = appointmentRepository.findByAppointmentDate(date);

        return appointments.stream().map(a -> modelMapper.map(a,AppointmentDTO.class)).collect(Collectors.toList());
    }

    public void cancelAppointment(Long appointmentId , CancellationReason cancellationReason) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(IllegalArgumentException::new);
        appointment.setStatus(AppointmentStatus.CANCEL.toString());
        appointment.setCancellationReason(cancellationReason.name());
        appointmentRepository.save(appointment);
    }



}
