package com.mahtuag.propertyManagement.repository;

import com.mahtuag.propertyManagement.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
}
