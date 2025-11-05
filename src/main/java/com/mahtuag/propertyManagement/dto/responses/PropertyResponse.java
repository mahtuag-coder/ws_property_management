package com.mahtuag.propertyManagement.dto.responses;


import com.mahtuag.propertyManagement.model.enums.PropertyStatus;

public record PropertyResponse(
        Long id,
        PropertyStatus status,
        AddressResponse addressResponse) {
}
