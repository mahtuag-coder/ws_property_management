package com.mahtuag.propertyManagement.model.mappers;

import com.mahtuag.propertyManagement.dto.requests.PropertyRequest;
import com.mahtuag.propertyManagement.dto.responses.PropertyResponse;
import com.mahtuag.propertyManagement.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface PropertyMapper {
    @Mapping(source = "addressRequest", target = "address")
    Property toEntity(PropertyRequest propertyRequest);
    @Mapping(source = "address", target = "addressResponse")
    PropertyResponse toResponse(Property property);
}
