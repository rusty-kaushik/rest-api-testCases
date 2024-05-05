package com.aniket.vendorrestapi.repository;

import com.aniket.vendorrestapi.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest  {

    // GIVEN - WHEN - THEN

    @Autowired
    CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor
                ("1","noida","Aniket","9958032167");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // TEST CASES

    // SUCCESS TEST CASE

    @Test
    void testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Aniket");
        assertThat(cloudVendorList.get(0).getVendorID()).isEqualTo(cloudVendor.getVendorID());
        assertThat(cloudVendorList.get(0).getVendorName()).isEqualTo(cloudVendor.getVendorName());
    }

    //FAILURE TEST CASE

    @Test
    void testFindByVendorName_NotFound(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Kaushik");
        assertThat(cloudVendorList.isEmpty()).isTrue();

    }
}
