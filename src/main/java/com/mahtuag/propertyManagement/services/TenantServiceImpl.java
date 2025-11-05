package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.dto.TenantResponse;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.mappers.TenantMapper;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import com.mahtuag.propertyManagement.repository.TenantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Override
    public TenantResponse createTenant(TenantRequest tenantRequest) {
        Tenant tenant = tenantRepository.save(tenantMapper.toEntity(tenantRequest));
        return tenantMapper.toResponse(tenant);
    }

    @Override
    public Page<TenantResponse> findAllTenants(Pageable pageable) {
        return tenantRepository.findAll(pageable)
                .map(tenantMapper::toResponse);
    }

    @Override
    public TenantResponse updateTenant(Long id, TenantRequest tenantRequest) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tenant with id " + id + " not found"));

        tenantMapper.updateTenantFromRequest(tenantRequest, tenant);
        Tenant updateTenant = tenantRepository.save(tenant);
        return tenantMapper.toResponse(updateTenant);
    }

    @Transactional
    @Override
    public List<TenantResponse> createTenants(List<TenantRequest> tenantRequests) {
        log.info("creating tenant with {} requests", tenantRequests.size());
        List<Tenant> tenantEntities = tenantRequests.stream()
                .map(tenantMapper::toEntity)
                .toList();

        List<Tenant> storedTenants = tenantRepository.saveAll(tenantEntities);

        return storedTenants.stream()
                .map(tenantMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteTenant(Long id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tenant with id " + id + " not found"));
        tenantRepository.delete(tenant);
    }

    @Override
    public TenantResponse findTenantById(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tenant with id " + id + " not found"));

        return tenantMapper.toResponse(tenant);
    }
}
