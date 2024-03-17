package com.example.SpringMongoProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private String userId;
    private String name;
    private String date;
    private String time;
}
