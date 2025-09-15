package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.model.request.LeaseRequest;
import com.mahtuag.propertyManagement.repository.LeaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository leaseRepository;
    private final TenantService tenantService;
    private final PropertyService propertyService;

    @Override
    public Lease issueLease(LeaseRequest leaseRequest) {
        Tenant tenant = tenantService.getTenantById(leaseRequest.getTenantId());
        Property property = propertyService.getPropertyById(leaseRequest.getPropertyId());

        Lease lease = Lease.builder()
                .tenant(tenant)
                .property(property)
                .leaseStartDate(leaseRequest.getLeaseStartDate())
                .leaseEndDate(leaseRequest.getLeaseEndDate())
                .rent(leaseRequest.getRent())
                .deposit(leaseRequest.getDeposit())
                .status(leaseRequest.getStatus())
                .build();

        return leaseRepository.save(lease);
    }
}
