package com.mahtuag.propertyManagement.model.request;

import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaseRequest {
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private Double rent;
    private Double deposit;
    private LeaseStatus status;
    private Long propertyId;
    private Long tenantId;

}
