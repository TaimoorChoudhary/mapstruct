package com.taimoor.mapstruct.mapper;

import com.taimoor.mapstruct.constant.PaymentType;
import com.taimoor.mapstruct.constant.PaymentTypeView;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Taimoor Choudhary
 */
@Mapper
public interface PaymentTypeMapper {

    PaymentTypeMapper INSTANCE = Mappers.getMapper(PaymentTypeMapper.class);

    @ValueMappings({
            @ValueMapping(source = "CARD_VISA", target = "CARD"),
            @ValueMapping(source = "CARD_MASTER", target = "CARD"),
            @ValueMapping(source = "CARD_CREDIT", target = "CARD")
    })
    PaymentTypeView paymentTypeToPaymentTypeView(PaymentType paymentType);


    @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CARD")
    PaymentTypeView TypeToTypeView(PaymentType paymentType);
}
