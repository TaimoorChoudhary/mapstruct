package com.taimoor.mapstruct.repository;

import com.taimoor.mapstruct.dto.PatientDto;

import java.util.List;

/**
 * @author Taimoor Choudhary
 */
public interface PatientRepository {

    PatientDto getPatientById(int id);
    List<PatientDto> getPatients();
}
