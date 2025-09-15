package com.mahtuag.propertyManagement.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
public class AuditEntityListener {

    @PrePersist
    public void prePersist(AuditEntity auditEntity) {
        auditEntity.setCreateDateTime(OffsetDateTime.now());
        auditEntity.setUpdateDateTime(OffsetDateTime.now());
        auditEntity.setCreatedBy("Gautham");
        auditEntity.setLastModifiedBy("Gautham");
    }
    @PreUpdate
    public void preUpdate(AuditEntity auditEntity) {
        auditEntity.setUpdateDateTime(OffsetDateTime.now());
        auditEntity.setLastModifiedBy("Gautham");
    }

}
