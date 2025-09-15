package com.mahtuag.propertyManagement.controller;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import com.mahtuag.propertyManagement.services.TenantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tenant")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Tenant tenant = tenantService.getTenantById(id);
        return ResponseEntity.ok(tenant);
    }

    @PostMapping
    public ResponseEntity<Tenant> createTenant(@RequestBody @Valid TenantRequest tenantRequest) {
        Tenant tenant = tenantService.addTenant(tenantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(tenant);
    }

    @PatchMapping("/status/{status}")
    public ResponseEntity<Tenant> updateTenantStatus(@RequestParam(required = true) Long id, @PathVariable TenantStatus status) {
        Tenant tenant = tenantService.updateTenantStatus(id, status);
        return ResponseEntity.ok(tenant);
    }
}
