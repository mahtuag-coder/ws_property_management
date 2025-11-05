package com.mahtuag.propertyManagement.dto.requests;

import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PropertyRequest(
        @Valid
        @NotNull(message = "Address is required.")
        AddressRequest addressRequest,
        @NotBlank(message = "Status is required.")
        PropertyStatus status){
}
