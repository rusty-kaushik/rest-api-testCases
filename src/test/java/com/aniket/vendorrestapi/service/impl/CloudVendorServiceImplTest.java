package com.aniket.vendorrestapi.service.impl;

import com.aniket.vendorrestapi.model.CloudVendor;
import com.aniket.vendorrestapi.repository.CloudVendorRepository;
import com.aniket.vendorrestapi.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable; // close all the resources when all the test cases are executed
    CloudVendor cloudVendor;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1","NOIDA","Aniket","9999");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Successfully created a vendor");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Successfully created the vendor");
    }

    @Test
    void testDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());

        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Successfully deleted a vendor");
    }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void testGetByVendorName() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorName("Aniket"))
                .thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));


        assertThat(cloudVendorService.getByVendorName("Aniket").get(0).getVendorID())
                .isEqualTo(cloudVendor.getVendorID());
    }

    @Test
    void testGetAllCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll())
                .thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));


        assertThat(cloudVendorService.getAllCloudVendor().get(0).getVendorPhoneNumber())
                .isEqualTo(cloudVendor.getVendorPhoneNumber());
    }
}