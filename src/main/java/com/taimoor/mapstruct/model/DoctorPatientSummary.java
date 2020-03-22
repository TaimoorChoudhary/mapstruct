package com.taimoor.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPatientSummary {

    private int doctorId;
    private int patientCount;

    private String doctorName;
    private String specialization;
    private String institute;

    private List<Integer> patientIds;
}
