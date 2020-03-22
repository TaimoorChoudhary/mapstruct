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
public class Education {

    private String degreeName;
    private String institute;
    private Integer yearOfPassing;
}
