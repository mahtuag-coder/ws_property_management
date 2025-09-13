package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.exception.PropertyNotFoundException;
import com.mahtuag.propertyManagement.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property with id " + id + " not found"));
    }
}
