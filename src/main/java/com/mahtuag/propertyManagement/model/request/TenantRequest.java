package com.mahtuag.propertyManagement.model.request;

import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private TenantStatus status;
}
