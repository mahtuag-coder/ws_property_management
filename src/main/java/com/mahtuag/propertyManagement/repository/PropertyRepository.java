package com.mahtuag.propertyManagement.repository;

import com.mahtuag.propertyManagement.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
