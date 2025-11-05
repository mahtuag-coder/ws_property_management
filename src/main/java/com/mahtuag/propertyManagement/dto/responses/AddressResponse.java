package com.mahtuag.propertyManagement.dto.responses;

public record AddressResponse(Long id, String doorNumber, String street, String city, String state, String zipcode) {
}
