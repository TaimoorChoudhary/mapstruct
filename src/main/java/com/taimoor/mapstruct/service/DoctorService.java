package com.taimoor.mapstruct.service;

import com.taimoor.mapstruct.dto.DoctorDto;
import com.taimoor.mapstruct.mapper.DoctorCustomMapper;
import com.taimoor.mapstruct.mapper.DoctorMapper;
import com.taimoor.mapstruct.model.Doctor;
import com.taimoor.mapstruct.model.DoctorPatientSummary;
import com.taimoor.mapstruct.model.Education;
import com.taimoor.mapstruct.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Taimoor Choudhary
 */
@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorCustomMapper doctorCustomMapper;

    public Doctor getDoctor(int id){

        return doctorMapper.toModel(doctorRepository.getDoctorById(id));
    }

    public DoctorPatientSummary getDoctorSummary(int id){

        Doctor doctor = doctorMapper.toModel(doctorRepository.getDoctorById(id));
        Education education = Education.builder()
                .degreeName("Medical")
                .institute("Cardiology Institute")
                .yearOfPassing(2018)
                .build();

        return doctorCustomMapper.toDoctorPatientSummary(doctor, education);
    }

    public List<Doctor> getDoctors(){

        List<DoctorDto> doctorDtoList = doctorRepository.getDoctors();

        return doctorDtoList.stream()
                .map(doctorMapper::toModel)
                .collect(Collectors.toList());
    }

}
