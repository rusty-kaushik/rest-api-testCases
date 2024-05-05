package com.aniket.vendorrestapi.service;

import com.aniket.vendorrestapi.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorID);
    public CloudVendor getCloudVendor(String cloudVendorID);
    public List<CloudVendor> getAllCloudVendor();
    public List<CloudVendor> getByVendorName(String vendorName);

}
