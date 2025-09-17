package com.mahtuag.propertyManagement.repository;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
    Page<Lease> findAllLeasesByStatus(LeaseStatus status, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Lease l SET l.status = :status, l.lastModifiedBy = :user, l.updateDateTime = :modifiedDateTime  WHERE l.leaseEndDate = :today")
    int expireLeases(@Param("today")LocalDate today, @Param("status") LeaseStatus status, @Param("user") String user, @Param("modifiedDateTime") OffsetDateTime modifiedDateTime);
}
