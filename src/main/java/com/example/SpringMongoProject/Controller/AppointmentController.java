package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Appointment;
import com.example.SpringMongoProject.Service.AppointmentService;
import com.example.SpringMongoProject.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(value = "/create")
    private Appointment createAppointment(@RequestBody AppointmentDto appointmentDto){
        return this.appointmentService.createAppointment(appointmentDto);
    }
}
