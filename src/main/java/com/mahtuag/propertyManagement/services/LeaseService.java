package com.mahtuag.propertyManagement.services;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.model.request.LeaseRequest;

public interface LeaseService {

    Lease issueLease(LeaseRequest lease);
}
