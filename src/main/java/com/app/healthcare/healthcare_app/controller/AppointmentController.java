package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Appointment;
import com.app.healthcare.healthcare_app.request.AppointmentPostRequest;
import com.app.healthcare.healthcare_app.request.AppointmentPutRequest;
import com.app.healthcare.healthcare_app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final JmsTemplate jmsTemplate;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, JmsTemplate jmsTemplate) {
        this.appointmentService = appointmentService;
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        jmsTemplate.convertAndSend("Getting all appointments");
        return appointmentService.getAllAppointments();
    }

    @GetMapping(params = "providerId")
    public List<Appointment> getAllAppointmentsByProviderId(@RequestParam Long providerId) {
        jmsTemplate.convertAndSend("Getting all appointments by provider ID: " + providerId);
        return appointmentService.getAllAppointmentsByProviderId(providerId);
    }

    @GetMapping(params = "patientId")
    public List<Appointment> getAllAppointmentsByPatientId(@RequestParam Long patientId) {
        jmsTemplate.convertAndSend("Getting all appointments by patient ID: " + patientId);
        return appointmentService.getAllAppointmentsByPatientId(patientId);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        jmsTemplate.convertAndSend("Getting appointment by ID: " + id);
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Appointment createAppointment(@Valid @RequestBody AppointmentPostRequest appointmentReq) {
        jmsTemplate.convertAndSend("Creating appointment with title: " + appointmentReq.getTitle());
        return appointmentService.createAppointment(appointmentReq);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody @Valid AppointmentPutRequest appointmentReq) {
        jmsTemplate.convertAndSend("Updating appointment with ID: " + id);
        return appointmentService.updateAppointment(id, appointmentReq);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        jmsTemplate.convertAndSend("Deleting appointment with ID: " + id);
        appointmentService.deleteAppointment(id);
    }
}

