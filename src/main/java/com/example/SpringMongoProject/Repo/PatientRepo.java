package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepo extends MongoRepository<Patient,String> {
 Optional<Patient> findBy_id(String id);

 List<Patient> findAllByNic(String nic);

}
