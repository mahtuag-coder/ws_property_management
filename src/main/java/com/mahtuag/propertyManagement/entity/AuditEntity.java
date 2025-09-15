package com.mahtuag.propertyManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditEntity extends BaseEntity {

    @Column(name = "create_date_time", nullable = false)
    private OffsetDateTime createDateTime;
    @Column(name = "update_date_time", nullable = false)
    private OffsetDateTime updateDateTime;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "last_modified_by", nullable = false)
    private String lastModifiedBy;
}
