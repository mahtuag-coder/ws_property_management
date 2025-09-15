package com.mahtuag.propertyManagement.controller;

import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import com.mahtuag.propertyManagement.model.request.PropertyCreateRequest;
import com.mahtuag.propertyManagement.services.PropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping
    public ResponseEntity<Page<Property>> getAllProperties(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                           @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(propertyService.getAllProperties(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<Property>> getPropertiesByStatus(@PathVariable PropertyStatus status,
                                                                @RequestParam(required = false, defaultValue = "0") Integer page,
                                                                @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(propertyService.getPropertiesByStatus(status, pageable));
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody @Valid PropertyCreateRequest propertyRequest) {
        Property property = propertyService.addProperty(propertyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(property);
    }
}
