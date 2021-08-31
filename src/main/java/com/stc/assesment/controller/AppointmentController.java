package com.stc.assesment.controller;

import com.stc.assesment.dto.AppointmentDTO;
import com.stc.assesment.service.AppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;

    @ApiOperation(notes = "", value = "API to get today appointments")
    @GetMapping("/today")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppointmentDTO> getAppointmentByToday() {
        List<AppointmentDTO> appointmentDTOS = appointmentService.getAllAppointmentsByToday();
        return appointmentDTOS;
    }

    @ApiOperation(notes = "date should be in this format yyyy-MM-dd", value = "API to get appointments by date")
    @GetMapping("/date")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppointmentDTO> getAppointmentByDate(@RequestParam @NotBlank String date) {
        List<AppointmentDTO> appointmentDTOS = appointmentService.getAllAppointmentsByDate(LocalDate.parse(date));
        return appointmentDTOS;
    }

    @ApiOperation(notes = "date should be in this format yyyy-MM-dd", value = "API to get create new appointment")
    @PostMapping("/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Long createNewAppointment(@RequestBody  @Valid AppointmentDTO appointmentDTO) {
        Long appointmentId = appointmentService.createNewAppointment(appointmentDTO);
        return appointmentId;
    }

    @ApiOperation(notes = "", value = "API to get cancel appointment")
    @PostMapping("/cancel/{appointmentId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void cancelAppointment(@PathVariable Long appointmentId , @RequestBody String cancellationReason) {
        appointmentService.cancelAppointment(appointmentId,cancellationReason);
    }
}
