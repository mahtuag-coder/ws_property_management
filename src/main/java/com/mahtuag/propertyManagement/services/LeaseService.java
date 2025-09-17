package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import com.mahtuag.propertyManagement.model.request.LeaseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LeaseService {

    Lease issueLease(LeaseRequest lease);

    Page<Lease> findAllLeasesByStatus(LeaseStatus status, Pageable pageable);

    Lease terminateLease(Long leaseId);

    void expireLeases();
}
