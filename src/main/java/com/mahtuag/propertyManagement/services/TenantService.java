package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TenantService {

    Page<Tenant> findAllTenants(Pageable pageable);
    Tenant addTenant(TenantRequest tenant);
    Tenant updateTenant(TenantRequest tenant);
    Tenant getTenantById(Long id);
    List<Tenant> getTenantsByName(String firstName, String lastName);
    Tenant updateTenantStatus(Long id, TenantStatus status);
}
