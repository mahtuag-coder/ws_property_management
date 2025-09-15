package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.request.TenantRequest;

public interface TenantService {

    Tenant addTenant(TenantRequest tenant);
    Tenant updateTenant(TenantRequest tenant);
    Tenant getTenantById(Long id);
    Tenant getTenantByName(String name);
    Tenant updateTenantStatus(Long id, TenantStatus status);
}
