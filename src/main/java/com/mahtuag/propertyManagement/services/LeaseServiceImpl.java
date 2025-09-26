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
import com.mahtuag.propertyManagement.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository leaseRepository;
    private final TenantRepository tenantRepository;
    private final PropertyService propertyService;
    private final PropertyRepository propertyRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<Lease> findAllLeasesByStatus(LeaseStatus status, Pageable pageable) {
        return leaseRepository.findAllLeasesByStatus(status, pageable);
    }

    @Override
    public Lease terminateLease(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId).orElseThrow(() -> new IllegalArgumentException("Lease with id: " + leaseId + " not found"));
        lease.setStatus(LeaseStatus.TERMINATED);
        leaseRepository.save(lease);

        Property property = lease.getProperty();
        property.setStatus(PropertyStatus.UNDER_MAINTENANCE);
        propertyRepository.save(property);

        return lease;
    }


    @Override
    @Scheduled(cron = "0 */5 * * * *")
    public void expireLeases() {
        int expiredCount = leaseRepository.expireLeases(LocalDate.now(), LeaseStatus.EXPIRED, "ADMIN", OffsetDateTime.now());
        if (expiredCount > 0) {
            System.out.println("Expired Lease count: " + expiredCount);
        }
    }

    @Override
    public Lease issueLease(LeaseRequest leaseRequest) {
        Tenant tenant = tenantRepository.findById(leaseRequest.getTenantId())
                .orElseThrow(() -> new IllegalArgumentException("Tenant with id: " + leaseRequest.getTenantId() + " not found"));

        Property property = propertyService.getPropertyById(leaseRequest.getPropertyId());

        if (property.getStatus() != PropertyStatus.AVAILABLE) {
            throw new LeaseValidationException("Property is not active");
        }

        if (tenant.getStatus() == TenantStatus.BLACKLISTED) {
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
