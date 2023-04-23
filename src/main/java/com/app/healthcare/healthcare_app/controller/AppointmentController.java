package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Appointment;
import com.app.healthcare.healthcare_app.model.Patient;
import com.app.healthcare.healthcare_app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    //private final JmsTemplate jmsTemplate;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping(params = "providerId")
    public List<Patient> getAllAppointmentsByProviderId(@RequestParam Long providerId) {
        return appointmentService.getAllAppointmentsByProviderId(providerId);
    }
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        //jmsTemplate.convertAndSend("appointmentQueue", "Created appointment with ID: " + createdAppointment.getId());
        return appointmentService.createAppointment(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        //jmsTemplate.convertAndSend("appointmentQueue", "Deleted appointment with ID: " + id);
    }
}

