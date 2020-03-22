package com.taimoor.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Taimoor Choudhary
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private int id;
    private String name;
    private LocalDate dateOfBirth;
}
