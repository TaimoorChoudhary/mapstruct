package com.taimoor.mapstruct.mapper;

import com.taimoor.mapstruct.dto.DoctorDto;
import com.taimoor.mapstruct.exception.ValidationException;
import com.taimoor.mapstruct.model.Doctor;
import com.taimoor.mapstruct.model.DoctorPatientSummary;
import com.taimoor.mapstruct.model.Education;
import com.taimoor.mapstruct.model.Patient;
import com.taimoor.mapstruct.utility.Validator;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Taimoor Choudhary
 */
@Mapper(uses = {PatientMapper.class, Validator.class}, componentModel = "spring", imports = {LocalDateTime.class, UUID.class})
public interface DoctorMapper {

    // NOTE: Uncomment the following if the Spring component model is not used
    //DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);


    @Mapping(source = "doctorDto.specialization", target = "specialty")
    @Mapping(source = "doctorDto.patientDtoList", target = "patientList")
    Doctor toModel(DoctorDto doctorDto);

    @InheritConfiguration
    void updateModel(DoctorDto doctorDto, @MappingTarget Doctor doctor);

    @Mapping(source = "doctor.patientList", target = "patientDtoList")
    @Mapping(source = "doctor.specialty", target = "specialization", defaultValue = "Information Not Available")
    DoctorDto toDto(Doctor doctor) throws ValidationException;

    @Mapping(target = "id", constant = "-1")
    @Mapping(target = "externalId", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "doctor.availability", target = "availability", defaultExpression = "java(LocalDateTime.now())")
    @Mapping(source = "doctor.patientList", target = "patientDtoList")
    @Mapping(source = "doctor.specialty", target = "specialization")
    DoctorDto toDtoWithExpression(Doctor doctor);

    @Mapping(source = "doctor.specialty", target = "specialization")
    @Mapping(source = "education.degreeName", target = "degree")
    @Mapping(source = "doctor.patientList", target = "patientDtoList")
    DoctorDto toDto(Doctor doctor, Education education);

    default DoctorPatientSummary toDoctorPatientSummary(Doctor doctor, Education education){

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
