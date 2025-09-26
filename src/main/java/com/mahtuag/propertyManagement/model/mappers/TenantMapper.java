package com.mahtuag.propertyManagement.model.mappers;

import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.dto.TenantResponse;
import com.mahtuag.propertyManagement.model.request.TenantRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TenantMapper {

    // Entity -> DTO
    TenantResponse toResponse(Tenant tenant);

    // DTO -> Entity
    Tenant toEntity(TenantRequest tenantRequest);

    // Partial updates
    @Mapping(target = "id", ignore = true)  // 🚨 don’t overwrite primary key
    void updateTenantFromRequest(TenantRequest tenantRequest, @MappingTarget Tenant tenant);
}
