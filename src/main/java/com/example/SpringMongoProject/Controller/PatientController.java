package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Patient;
import com.example.SpringMongoProject.Service.PatientServices;
import com.example.SpringMongoProject.dto.PatientNicReqDto;
import com.example.SpringMongoProject.dto.PatientRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    private PatientServices patientServices;


    @PostMapping(value = "/save")
    private Patient savePatient(@RequestBody PatientRegisterDto patientDto){
        return patientServices.saveorUpdate(patientDto);
    }


    @GetMapping(value = "/getAll")
    private Iterable<Patient>getPatients(){


        return patientServices.listAll();
    }


    @PutMapping(value = "/edit/{id}")
    private void update(@RequestBody Patient patient,@PathVariable(name="id")String _id){


        patient.set_id(_id);
//        patientServices.saveorUpdate(patient);
//        return patient;
    }


    @DeleteMapping(value = "/delete/{id}")
    private void deletePatient(@PathVariable("id") String _id){
        patientServices.deletePatient(_id);

    }


    @RequestMapping("/search/{id}")
    private Patient getPatients(@PathVariable(name="id")String patientId){
        return patientServices.getPatientByID(patientId);
    }

    @PostMapping("/get-reg-ids")
    private List<String> getRegIdsByNic(@RequestBody PatientNicReqDto patientNicReqDto){
        return this.patientServices.getRegIdsByNic(patientNicReqDto.getNic());
    }

    @PostMapping(value = "/reports")
    private List<Patient> getReports(@RequestBody PatientNicReqDto nic) {
        return this.patientServices.getReportData(nic.getNic());
    }
}
