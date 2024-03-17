package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Appointment;
import com.example.SpringMongoProject.Repo.AppointmentRepo;
import com.example.SpringMongoProject.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    public Appointment createAppointment(AppointmentDto appointmentDto){

        Appointment appointment = new Appointment();
        appointment.setUserId(appointmentDto.getUserId());
        appointment.setName(appointmentDto.getName());
        appointment.setDate(LocalDate.parse(appointmentDto.getDate()));
        appointment.setTime(LocalTime.parse(appointmentDto.getTime()));
        return this.appointmentRepo.save(appointment);
    }
}
