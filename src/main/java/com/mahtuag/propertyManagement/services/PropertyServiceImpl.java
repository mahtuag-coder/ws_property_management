package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.dto.requests.PropertyRequest;
import com.mahtuag.propertyManagement.dto.responses.PropertyResponse;
import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.exception.PropertyNotFoundException;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import com.mahtuag.propertyManagement.model.mappers.PropertyMapper;
import com.mahtuag.propertyManagement.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Override
    public Page<PropertyResponse> getAllProperties(Pageable pageable) {
        Page<Property> properties = propertyRepository.findAll(pageable);
        return properties.map(propertyMapper::toResponse);
    }

    @Override
    public PropertyResponse getPropertyById(Long id) {
        Property property =  propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property with id " + id + " not found"));

        return propertyMapper.toResponse(property);
    }

    @Override
    public Page<PropertyResponse> getPropertiesByStatus(PropertyStatus status, Pageable pageable) {
        Page<Property> properties = propertyRepository.getPropertiesByStatus(status, pageable);
        return properties.map(propertyMapper::toResponse);
    }

    @Override
    public PropertyResponse saveProperty(PropertyRequest propertyRequest) {
       Property property = propertyMapper.toEntity(propertyRequest);
       Property savedProperty = propertyRepository.save(property);

        return propertyMapper.toResponse(savedProperty);
    }

    @Override
    public void deletePropertyById(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property with id " + id + " not found"));

        propertyRepository.delete(property);

        log.info("Property with id " + id + " has been deleted");
    }
}
