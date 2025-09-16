package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.entity.Tenant;
import com.mahtuag.propertyManagement.exception.LeaseValidationException;
import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import com.mahtuag.propertyManagement.model.request.LeaseRequest;
import com.mahtuag.propertyManagement.repository.LeaseRepository;
import com.mahtuag.propertyManagement.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository leaseRepository;
    private final TenantService tenantService;
    private final PropertyService propertyService;
    private final PropertyRepository propertyRepository;

    @Override
    public Page<Lease> findAllLeasesByStatus(LeaseStatus status, Pageable pageable) {
        return leaseRepository.findAllLeasesByStatus(status, pageable);
    }

    @Override
    public Lease issueLease(LeaseRequest leaseRequest) {
        Tenant tenant = tenantService.getTenantById(leaseRequest.getTenantId());
        Property property = propertyService.getPropertyById(leaseRequest.getPropertyId());

        if(property.getStatus() != PropertyStatus.AVAILABLE) {
            throw new LeaseValidationException("Property is not active");
        }

        if(tenant.getStatus() == TenantStatus.BLACKLISTED) {
            throw new LeaseValidationException("Tenant is blacklisted");
        }

        Lease lease = Lease.builder()
                .tenant(tenant)
                .property(property)
                .leaseStartDate(leaseRequest.getLeaseStartDate())
                .leaseEndDate(leaseRequest.getLeaseEndDate())
                .rent(leaseRequest.getRent())
                .deposit(leaseRequest.getDeposit())
                .status(leaseRequest.getStatus())
                .build();

        Lease issuedLease = leaseRepository.save(lease);

        property.setStatus(PropertyStatus.RENTED);
        propertyRepository.save(property);

        return issuedLease;
    }
}
