package com.example.SpringMongoProject.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
@Data
public class Patient {
    @Id
    private String _id;
    private String name;
    private String address;
    private String nic;
    private String contact;
    private String email;
    private String doctor;
    private boolean payment;
}
