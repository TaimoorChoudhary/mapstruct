package com.taimoor.mapstruct.repository;

import com.taimoor.mapstruct.dto.DoctorDto;

import java.util.List;

/**
 * @author Taimoor Choudhary
 */
public interface DoctorRepository {

    DoctorDto getDoctorById(int id);
    List<DoctorDto> getDoctors();
}
