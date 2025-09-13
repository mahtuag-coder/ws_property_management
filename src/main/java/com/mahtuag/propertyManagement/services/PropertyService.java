package com.mahtuag.propertyManagement.services;


import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PropertyService {

    Page<Property> getAllProperties(Pageable pageable);

    Property getPropertyById(Long id);

    Page<Property> getPropertiesByStatus(PropertyStatus status, Pageable pageable);
}
