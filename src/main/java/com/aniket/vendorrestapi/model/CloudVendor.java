package com.aniket.vendorrestapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloud_vendor_info")
public class CloudVendor {

    @Id
    private String vendorID;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;

    public CloudVendor() {
    }

    public CloudVendor(String vendorID, String vendorAddress, String vendorName, String vendorPhoneNumber) {
        this.vendorID = vendorID;
        this.vendorAddress = vendorAddress;
        this.vendorName = vendorName;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }
}
