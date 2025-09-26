package com.mahtuag.propertyManagement.controller;

import com.mahtuag.propertyManagement.model.dto.PagedResponse;
import com.mahtuag.propertyManagement.model.dto.TenantResponse;
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

@RestController
@RequestMapping(value = "/tenants")
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
        TenantResponse tenant = tenantService.findTenantById(id);
        return ResponseEntity.ok(tenant);
    }


    @PostMapping
    public ResponseEntity<TenantResponse> createTenant(@RequestBody @Valid TenantRequest tenantRequest) {
        TenantResponse tenant = tenantService.createTenant(tenantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(tenant);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TenantResponse> updateTenant(@PathVariable Long id, @RequestBody @Valid TenantRequest tenantRequest) {
        TenantResponse tenant = tenantService.updateTenant(id, tenantRequest);
        return ResponseEntity.ok(tenant);
    }
}
