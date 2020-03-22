package com.taimoor.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
//@Builder (commenting builder because MapStruct is unable to use it in Before and After mapping methods)
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private int id;
    private String name;
    private String degree;
    private String externalId;
    private String specialization;
    private LocalDateTime availability;
    private List<PatientDto> patientDtoList;
}