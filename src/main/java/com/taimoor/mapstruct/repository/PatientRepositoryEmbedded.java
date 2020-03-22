package com.taimoor.mapstruct.repository;

import com.taimoor.mapstruct.dto.PatientDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@Component
public class PatientRepositoryEmbedded implements PatientRepository {

    @Override
    public PatientDto getPatientById(int id) {

        return createPatient(id, "Samuel Bradford", LocalDate.of(1987, 1, 17));
    }

    @Override
    public List<PatientDto> getPatients() {
        PatientDto patientDtoOne = createPatient(1, "Samuel Bradford", LocalDate.of(1987, 1, 17));
        PatientDto patientDtoTwo = createPatient(2, "Micheal J.Jonson", LocalDate.of(1993, 7, 01));

        List<PatientDto> patientDtoList = new ArrayList<>();

        patientDtoList.add(patientDtoOne);
        patientDtoList.add(patientDtoTwo);

        return patientDtoList;
    }

    private PatientDto createPatient(int id, String name, LocalDate dateOfBirth){

        return PatientDto.builder()
                .id(id)
                .name(name)
                .dateOfBirth(dateOfBirth)
                .build();
    }
}
