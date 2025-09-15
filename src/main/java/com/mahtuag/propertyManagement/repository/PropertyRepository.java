package com.mahtuag.propertyManagement.repository;

import com.mahtuag.propertyManagement.entity.Property;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Page<Property> getPropertiesByStatus(PropertyStatus status, Pageable pageable);
}
