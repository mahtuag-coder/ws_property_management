package com.mahtuag.propertyManagement.controller;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.model.request.LeaseRequest;
import com.mahtuag.propertyManagement.services.LeaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lease")
@RequiredArgsConstructor
public class LeaseController {

    private final LeaseService leaseService;

    @PostMapping
    public ResponseEntity<Lease> addLease(@RequestBody LeaseRequest leaseRequest) {
        Lease lease = leaseService.issueLease(leaseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(lease);
    }
}
