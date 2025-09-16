package com.mahtuag.propertyManagement.repository;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
    Page<Lease> findAllLeasesByStatus(LeaseStatus status, Pageable pageable);
}
