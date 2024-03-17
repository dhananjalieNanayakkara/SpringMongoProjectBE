package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Patient;
import com.example.SpringMongoProject.Repo.PatientRepo;
import com.example.SpringMongoProject.dto.PatientRegisterDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServices {

    @Autowired
    private PatientRepo repo;
    public Patient saveorUpdate(PatientRegisterDto patientDto) {

        Patient patient = new Patient();
        patient.setNic(patientDto.getNic());
        patient.setName(patientDto.getName());
        patient.setContact(patientDto.getContact());
        patient.setAddress(patientDto.getAddress());
        patient.setEmail(patientDto.getEmail());
        patient.setDoctor(patientDto.getDoctor());
        patient.setPayment(false);
        return repo.save(patient);

    }

    public Iterable<Patient> listAll() {
        return this.repo.findAll();
    }

    public void deletePatient(String id) {
        repo.deleteById(id);
    }

    public Patient getPatientByID(String patientId) {
        return repo.findById(patientId).get();
    }

    public List<String> getRegIdsByNic(String nic){
        List<Patient> patients =  repo.findAllByNic(nic);
        List<String> ids = new ArrayList();
        for (int i = 0; i < patients.size(); i++){
            ids.add(patients.get(i).get_id());
        }

        return ids;
    }

    public List<Patient> getReportData(String nic){
        List<Patient> list = this.repo.findAll();
        return list.stream().filter(patient -> patient.getNic().equals(nic)).toList();
    }
}
