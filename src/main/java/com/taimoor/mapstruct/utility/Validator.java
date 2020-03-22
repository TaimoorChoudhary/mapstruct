package com.taimoor.mapstruct.utility;

import com.taimoor.mapstruct.exception.ValidationException;
import org.springframework.stereotype.Component;

/**
 * @author Taimoor Choudhary
 */
@Component
public class Validator {

    public int validateId(int id) throws ValidationException {

        if(id == -1){
            throw new ValidationException("Invalid value in ID");
        }

        return id;
    }
}
