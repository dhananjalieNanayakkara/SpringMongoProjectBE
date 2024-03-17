package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Patient;
import com.example.SpringMongoProject.Entity.Payment;
import com.example.SpringMongoProject.Entity.User;
import com.example.SpringMongoProject.Repo.PatientRepo;
import com.example.SpringMongoProject.Repo.PaymentRepo;
import com.example.SpringMongoProject.Repo.UserRepo;
import com.example.SpringMongoProject.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private PaymentRepo paymentRepo;
    public Payment doPay(PaymentDto paymentDto) throws Exception {
        Payment payment = new Payment();
        payment.setUserId(paymentDto.getUserId());
        payment.setCardType(paymentDto.getCardType());
        payment.setCardNo(paymentDto.getCardNo());
        payment.setCvv(paymentDto.getCvv());
        payment.setExDate(paymentDto.getExDate());

        Optional<Patient> patient = patientRepo.findBy_id(paymentDto.getUserId());
        if(patient.isPresent()){
            patient.get().setPayment(true);
            patientRepo.save(patient.get());
        }else{
            throw new Exception("Internal Server Error");
        }

        return paymentRepo.save(payment);
    }
}
