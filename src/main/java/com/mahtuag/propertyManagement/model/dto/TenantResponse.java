package com.mahtuag.propertyManagement.model.dto;

import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private TenantStatus status;
}
