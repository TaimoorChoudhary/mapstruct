package com.taimoor.mapstruct.service;

import com.taimoor.mapstruct.dto.PatientDto;
import com.taimoor.mapstruct.mapper.PatientMapper;
import com.taimoor.mapstruct.model.Patient;
import com.taimoor.mapstruct.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Taimoor Choudhary
 */
@Service
public class PatientService {

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    PatientRepository patientRepository;

    public Patient getPatient(int id){

        return patientMapper.toModel(patientRepository.getPatientById(id));
    }

    public List<Patient> getPatients(){

        List<PatientDto> patientDtoList = patientRepository.getPatients();

        return patientDtoList.stream()
                .map(patientMapper::toModel)
                .collect(Collectors.toList());
    }
}
