package com.mahtuag.propertyManagement.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressRequest(
        @NotBlank(message = "Door number is required")
        @Size(max = 5, message = "Door number exceeds maximum allowed characters(5)")
        String doorNumber,
        @NotBlank(message = "Street name is required.")
        @Size(max = 100, message = "Street name exceeds maximum allowed characters(100).")
        String street,
        @NotBlank(message = "City is required.")
        String city,
        @NotBlank(message = "State is required.")
        String state,
        @NotBlank(message = "Zipcode is required.")
        @Size(max = 5, message = "Zip code exceeds maximum allowed length(5).")
        String zipcode) {
}
