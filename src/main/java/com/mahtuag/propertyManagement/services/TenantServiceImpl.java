package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.dto.TenantResponse;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import com.mahtuag.propertyManagement.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<TenantResponse> findAllTenants(Pageable pageable) {
        return tenantRepository.findAll(pageable)
                .map(this::buildTenantResponse);
    }

    @Override
    public Tenant updateTenant(TenantRequest tenantRequest) {
        return null;
    }

    @Override
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tenant with id " + id + " not found"));
    }

    @Override
    public List<Tenant> getTenantsByName(String firstName, String lastName) {
        return tenantRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(firstName, lastName);
    }

    @Override
    public Tenant updateTenantStatus(Long id, TenantStatus status) {
        Tenant tenant = getTenantById(id);
        tenant.setStatus(status);
        return tenantRepository.save(tenant);
    }

    private TenantResponse buildTenantResponse(Tenant tenant) {
        return TenantResponse.builder()
                .name(tenant.getLastName() + ", " + tenant.getFirstName())
                .email(tenant.getEmail())
                .phone(tenant.getPhone())
                .status(tenant.getStatus())
                .build();
    }
}
