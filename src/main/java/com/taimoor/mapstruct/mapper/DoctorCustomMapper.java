package com.taimoor.mapstruct.mapper;

import com.taimoor.mapstruct.dto.DoctorDto;
import com.taimoor.mapstruct.model.Doctor;
import com.taimoor.mapstruct.model.DoctorPatientSummary;
import com.taimoor.mapstruct.model.Education;
import com.taimoor.mapstruct.model.Patient;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Taimoor Choudhary
 */
@Mapper(uses = {PatientMapper.class}, componentModel = "spring", imports = {ArrayList.class})
public abstract class DoctorCustomMapper {

    @BeforeMapping
    protected void validate(Doctor doctor) {
        if(doctor.getPatientList() == null){
            doctor.setPatientList(new ArrayList<>());
        }
    }

    @AfterMapping
    protected void updateResult(@MappingTarget DoctorDto doctorDto) {

        doctorDto.setName(doctorDto.getName().toUpperCase());
        doctorDto.setDegree(doctorDto.getDegree().toUpperCase());
        doctorDto.setSpecialization(doctorDto.getSpecialization().toUpperCase());
    }

    @Mapping(source = "doctor.patientList", target = "patientDtoList")
    @Mapping(source = "doctor.specialty", target = "specialization")
    public abstract DoctorDto toDoctorDto(Doctor doctor);

    public DoctorPatientSummary toDoctorPatientSummary(Doctor doctor, Education education){

        return DoctorPatientSummary.builder()
                .doctorId(doctor.getId())
                .doctorName(doctor.getName())
                .patientCount(doctor.getPatientList().size())
                .patientIds(doctor.getPatientList()
                        .stream().map(Patient::getId).collect(Collectors.toList()))
                .institute(education.getInstitute())
                .specialization(education.getDegreeName())
                .build();
    }
}
