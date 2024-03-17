package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepo extends MongoRepository<Appointment, String> {
}
