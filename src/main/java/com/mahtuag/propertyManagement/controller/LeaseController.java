package com.mahtuag.propertyManagement.controller;

import com.mahtuag.propertyManagement.entity.Lease;
import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import com.mahtuag.propertyManagement.model.request.LeaseRequest;
import com.mahtuag.propertyManagement.services.LeaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/lease")
@RequiredArgsConstructor
public class LeaseController {

    private final LeaseService leaseService;

    @GetMapping("/{status}")
    public ResponseEntity<Page<Lease>> getAllLeasesByStatus(@PathVariable LeaseStatus status,
                                                            @RequestParam(defaultValue = "0", required = false) Integer page,
                                                            @RequestParam(defaultValue = "10", required = false) Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(leaseService.findAllLeasesByStatus(status, pageable));
    }

    @PostMapping
    public ResponseEntity<Lease> addLease(@RequestBody LeaseRequest leaseRequest) {
        Lease lease = leaseService.issueLease(leaseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(lease);
    }

    @PatchMapping("/{id}/terminate")
    public ResponseEntity<Lease> terminateLease(@PathVariable Long id) {
        Lease lease = leaseService.terminateLease(id);
        return ResponseEntity.status(HttpStatus.OK).body(lease);
    }
}
