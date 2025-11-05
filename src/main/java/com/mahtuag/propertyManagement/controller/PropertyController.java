package com.mahtuag.propertyManagement.controller;

import com.mahtuag.propertyManagement.dto.requests.PropertyRequest;
import com.mahtuag.propertyManagement.dto.responses.PropertyResponse;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import com.mahtuag.propertyManagement.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping
    public ResponseEntity<Page<PropertyResponse>> getAllProperties(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                           @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(propertyService.getAllProperties(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyResponse> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<PropertyResponse>> getPropertiesByStatus(@PathVariable PropertyStatus status,
                                                                @RequestParam(required = false, defaultValue = "0") Integer page,
                                                                @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(propertyService.getPropertiesByStatus(status, pageable));
    }

    @PostMapping
    public ResponseEntity<PropertyResponse> createProperty(@RequestBody PropertyRequest propertyRequest) {
        PropertyResponse property = propertyService.saveProperty(propertyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(property);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePropertyById(@RequestParam(required = true) Long id) {
        propertyService.deletePropertyById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
