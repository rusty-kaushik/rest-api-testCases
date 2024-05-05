package com.aniket.vendorrestapi.service.impl;

import com.aniket.vendorrestapi.exception.CloudVendorNotFoundException;
import com.aniket.vendorrestapi.model.CloudVendor;
import com.aniket.vendorrestapi.repository.CloudVendorRepository;
import com.aniket.vendorrestapi.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Successfully created a vendor";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Successfully created the vendor";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorID) {
        cloudVendorRepository.deleteById(cloudVendorID);
        return "Successfully deleted a vendor";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorID) {
        if(cloudVendorRepository.findById(cloudVendorID).isEmpty()){
            throw new CloudVendorNotFoundException("Requested Vendor does not exist");
        }
        return cloudVendorRepository.findById(cloudVendorID).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName)
    {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
