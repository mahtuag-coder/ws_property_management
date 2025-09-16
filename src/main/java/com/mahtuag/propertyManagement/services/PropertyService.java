package com.mahtuag.propertyManagement.services;


import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import com.mahtuag.propertyManagement.model.request.PropertyCreateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PropertyService {

    Page<Property> getAllProperties(Pageable pageable);

    Property getPropertyById(Long id);

    Page<Property> getPropertiesByStatus(PropertyStatus status, Pageable pageable);

    Property saveProperty(PropertyCreateRequest propertyCreateRequest);
}
