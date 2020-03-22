package com.taimoor.mapstruct.controller;

import com.taimoor.mapstruct.model.Patient;
import com.taimoor.mapstruct.service.PatientService;
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
@RequestMapping(value = "/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id){

        Patient patient = patientService.getPatient(id);

        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients(){

        List<Patient> patients = patientService.getPatients();

        return ResponseEntity.ok(patients);
    }
}
