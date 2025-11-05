package com.mahtuag.propertyManagement.model.request;

import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantRequest {
    @NotBlank(message = "First Name is required.")
    private String firstName;

    @NotBlank(message = "Last Name is required.")
    private String lastName;

    @Email(message = "Email is not valid.")
    private String email;

    @NotBlank(message = "Last Name is required.")
    private String phone;

    @NotNull(message = "Status is required")
    private TenantStatus status;

}
