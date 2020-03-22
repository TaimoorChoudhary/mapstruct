package com.taimoor.mapstruct.repository;

import com.taimoor.mapstruct.dto.DoctorDto;
import com.taimoor.mapstruct.dto.PatientDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@Component
public class DoctorRepositoryEmbedded implements DoctorRepository {

    @Override
    public DoctorDto getDoctorById(int id) {

        List<PatientDto> patientDtoList = new ArrayList<>();

        patientDtoList.add(createPatient(1, "J. Smalling"));
        patientDtoList.add(createPatient(2, "Samantha Williams"));

        return createDoctor(id, "Dr. Sanders", "General", patientDtoList);
    }

    @Override
    public List<DoctorDto> getDoctors() {

        List<PatientDto> patientDtoList = new ArrayList<>();

        patientDtoList.add(createPatient(1, "J. Smalling"));
        patientDtoList.add(createPatient(2, "Samantha Williams"));
        patientDtoList.add(createPatient(3, "Alfred Tim"));
        patientDtoList.add(createPatient(4, "K. Oliver"));

        List<DoctorDto> doctorDtoList = new ArrayList<>();

        doctorDtoList.add(createDoctor(1, "Dr. Sanders", "General", patientDtoList.subList(0, 2)));
        doctorDtoList.add(createDoctor(2, "Dr. Goldberg", "General", patientDtoList.subList(2, 4)));

        return doctorDtoList;
    }

    private DoctorDto createDoctor(int id, String name, String speciality, List<PatientDto> patientDtos){

        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(id);
        doctorDto.setName(name);
        doctorDto.setSpecialization(speciality);
        doctorDto.setPatientDtoList(patientDtos);

        return doctorDto;
    }

    private PatientDto createPatient(int id, String name){

        return PatientDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}
