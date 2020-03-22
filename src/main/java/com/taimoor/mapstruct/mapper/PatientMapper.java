package com.taimoor.mapstruct.mapper;

import com.taimoor.mapstruct.dto.PatientDto;
import com.taimoor.mapstruct.model.Patient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Taimoor Choudhary
 */
@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MMM/yyyy")
    Patient toModel(PatientDto patientDto);

    @InheritInverseConfiguration
    PatientDto toDto(Patient patient);
}
