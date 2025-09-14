package com.mahtuag.propertyManagement.model.request;

import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyCreateRequest {
    @NotNull(message = "Status is required.")
    private PropertyStatus status;

    @NotNull(message = "Door number is required.")
    private String doorNum;
    @NotNull(message = "Street name is required.")
    private String street;
    @NotNull(message = "City name is required.")
    private String city;
    @NotNull(message = "State name is required.")
    private String state;
    @NotNull(message = "Zip code is required.")
    private String zip;
}
