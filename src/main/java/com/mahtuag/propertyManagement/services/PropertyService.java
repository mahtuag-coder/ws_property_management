package com.mahtuag.propertyManagement.services;


import com.mahtuag.propertyManagement.entity.Property;

import java.util.List;

public interface PropertyService {

    List<Property> getAllProperties();

    Property getPropertyById(Long id);
}
