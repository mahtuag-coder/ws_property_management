package com.mahtuag.propertyManagement.controller;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.dto.PagedResponse;
import com.mahtuag.propertyManagement.model.dto.TenantResponse;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import com.mahtuag.propertyManagement.services.TenantService;
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
@RequestMapping(value = "/tenant")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @GetMapping
    public ResponseEntity<PagedResponse<TenantResponse>> getAllTenants(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                              @RequestParam(defaultValue = "10", required = false) Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TenantResponse> tenantPage = tenantService.findAllTenants(pageable);

        return ResponseEntity.ok(PagedResponse.fromPage(tenantPage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantResponse> getTenantById(@PathVariable Long id) {
        TenantResponse tenant = tenantService.getTenantResponseById(id);
        return ResponseEntity.ok(tenant);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Tenant>> getTenantsByName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return ResponseEntity.ok(tenantService.getTenantsByName(firstName, lastName));
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
