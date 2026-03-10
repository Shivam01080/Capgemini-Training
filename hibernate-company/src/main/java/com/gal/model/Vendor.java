package com.gal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private int vendorId;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    // Default constructor (Required by JPA)
    public Vendor() {}

    // Constructor without ID
    public Vendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "Vendor[vendorId=%d, vendorName='%s']"
                .formatted(vendorId, vendorName);
    }
}