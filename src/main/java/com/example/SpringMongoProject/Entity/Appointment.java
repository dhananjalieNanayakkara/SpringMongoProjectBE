package com.example.SpringMongoProject.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Document(collection = "appointment")
@Data
public class Appointment {
    @Id
    private String id;
    private String userId;
    private String name;
    private LocalDate date;
    private LocalTime time;
}
