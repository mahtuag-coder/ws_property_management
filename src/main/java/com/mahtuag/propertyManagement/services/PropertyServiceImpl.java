package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.exception.PropertyNotFoundException;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import com.mahtuag.propertyManagement.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    public Page<Property> getAllProperties(Pageable pageable) {
        return propertyRepository.findAll(pageable);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property with id " + id + " not found"));
    }

    @Override
    public Page<Property> getPropertiesByStatus(PropertyStatus status, Pageable pageable) {
        return propertyRepository.getPropertiesByStatus(status, pageable);
    }
}
