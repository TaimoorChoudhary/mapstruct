package com.taimoor.mapstruct.controller;

import com.taimoor.mapstruct.model.Doctor;
import com.taimoor.mapstruct.model.DoctorPatientSummary;
import com.taimoor.mapstruct.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id){
        
        Doctor doctor = doctorService.getDoctor(id);

        return ResponseEntity.ok(doctor);
    }

    @GetMapping(value = "/{id}/summary")
    public ResponseEntity<DoctorPatientSummary> getDoctorSummary(@PathVariable int id){

        DoctorPatientSummary doctorSummary = doctorService.getDoctorSummary(id);

        return ResponseEntity.ok(doctorSummary);
    }
    @GetMapping
    public ResponseEntity<List<Doctor>> getDoctors(){

        List<Doctor> doctors = doctorService.getDoctors();

        return ResponseEntity.ok(doctors);
    }
}
