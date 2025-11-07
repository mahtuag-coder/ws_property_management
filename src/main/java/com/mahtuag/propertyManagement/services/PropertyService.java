package com.mahtuag.propertyManagement.services;


import com.mahtuag.propertyManagement.dto.requests.PropertyRequest;
import com.mahtuag.propertyManagement.dto.responses.PropertyResponse;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PropertyService {

    Page<PropertyResponse> getAllProperties(Pageable pageable);

    PropertyResponse getPropertyById(Long id);

    Page<PropertyResponse> getPropertiesByStatus(PropertyStatus status, Pageable pageable);

    PropertyResponse saveProperty(PropertyRequest propertyCreateRequest);

    PropertyResponse updateProperty(Long id, PropertyRequest propertyUpdateRequest);

    void deletePropertyById(Long id);
}
