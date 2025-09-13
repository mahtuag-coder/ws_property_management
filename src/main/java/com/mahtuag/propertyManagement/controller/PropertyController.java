package com.mahtuag.propertyManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @GetMapping
    public ResponseEntity<String> getProperties() {
        return ResponseEntity.ok("Hello from PropertyController");
    }
}
