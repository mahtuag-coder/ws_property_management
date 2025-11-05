package com.mahtuag.propertyManagement.model.mappers;

import com.mahtuag.propertyManagement.dto.requests.AddressRequest;
import com.mahtuag.propertyManagement.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "doorNumber", target = "doorNumber")
    @Mapping(source = "zipcode", target = "zipcode") // optional if same name
    Address toEntity(AddressRequest addressRequest);
    AddressRequest toResponse(Address address);
}
