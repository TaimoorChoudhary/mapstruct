package com.taimoor.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@Data
//@Builder (commenting builder because MapStruct is unable to use it in Before and After mapping methods
// and @InheritConfiguration)
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private int id;
    private String name;
    private String externalId;
    private String specialty;
    private LocalDateTime availability;
    private List<Patient> patientList;
}
