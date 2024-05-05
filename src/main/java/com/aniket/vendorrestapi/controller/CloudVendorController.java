package com.aniket.vendorrestapi.controller;


import com.aniket.vendorrestapi.model.CloudVendor;
import com.aniket.vendorrestapi.response.ResponseHandler;
import com.aniket.vendorrestapi.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

        CloudVendorService cloudVendorService;

        public CloudVendorController(CloudVendorService cloudVendorService) {
            this.cloudVendorService = cloudVendorService;
        }

        @GetMapping("{vendorID}") // defines the type of service it provides using the annotations
        public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorID") String vendorID){
            return ResponseHandler.responseBuilder(
                    "Requested Vendor Details given here",
                    HttpStatus.OK,
                    cloudVendorService.getCloudVendor(vendorID)
            );
        }

        @GetMapping()
        public List<CloudVendor> getAllCloudVendorDetails(){
            return cloudVendorService.getAllCloudVendor();
        }

        @PostMapping
        public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
            cloudVendorService.createCloudVendor(cloudVendor);
            return "Successfully created a vendor";
        }

        @PutMapping
        public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
            cloudVendorService.updateCloudVendor(cloudVendor);
            return "Successfully updated a vendor";
        }

        @DeleteMapping("{vendorID}")
        public String deleteCloudVendorDetails(@PathVariable("vendorID") String vendorID){
            cloudVendorService.deleteCloudVendor(vendorID);
            return "Successfully deleted a vendor";
        }
}
