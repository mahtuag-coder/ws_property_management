package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import com.mahtuag.propertyManagement.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    public Tenant addTenant(TenantRequest tenantRequest) {
        Tenant tenant = Tenant.builder()
                .firstName(tenantRequest.getFirstName())
                .lastName(tenantRequest.getLastName())
                .email(tenantRequest.getEmail())
                .phone(tenantRequest.getPhone())
                .status(tenantRequest.getStatus())
                .build();

        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant updateTenant(TenantRequest tenantRequest) {
        return null;
    }

    @Override
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant with id " + id + " not found"));
    }

    @Override
    public Tenant getTenantByName(String name) {
        return null;
    }

    @Override
    public Tenant updateTenantStatus(Long id, TenantStatus status) {
        Tenant tenant = getTenantById(id);
        tenant.setStatus(status);
        return tenantRepository.save(tenant);
    }
}
