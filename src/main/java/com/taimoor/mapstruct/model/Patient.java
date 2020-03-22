package com.taimoor.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Taimoor Choudhary
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    private int id;
    private String name;
    private String dateOfBirth;
}
