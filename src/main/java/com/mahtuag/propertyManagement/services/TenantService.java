package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.model.dto.TenantResponse;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TenantService {

    Page<TenantResponse> findAllTenants(Pageable pageable);
    TenantResponse findTenantById(Long id);
    TenantResponse createTenant(TenantRequest tenant);
    TenantResponse updateTenant(TenantRequest tenant);
}
