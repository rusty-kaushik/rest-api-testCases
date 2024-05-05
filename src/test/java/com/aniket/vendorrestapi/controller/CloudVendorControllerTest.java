package com.aniket.vendorrestapi.controller;

import com.aniket.vendorrestapi.model.CloudVendor;
import com.aniket.vendorrestapi.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("1","NOIDA","Aniket","999999");
        cloudVendorTwo = new CloudVendor("2","DELHI","kaushik","888888");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetCloudVendorDetails() throws Exception{
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);

        this.mockMvc.perform(get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendor()).thenReturn(cloudVendorList);

        this.mockMvc.perform(get("/cloudvendor")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateCloudVendorDetails() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);  // converts into json keep it in a utility class

        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Successfully created a vendor");

        this.mockMvc.perform(post("/cloudvendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateCloudVendorDetails() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);  // converts into json keep it in a utility class

        when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("Successfully created the vendor");

        this.mockMvc.perform(put("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteCloudVendorDetails() throws Exception{
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Successfully deleted a vendor");

        this.mockMvc.perform(delete("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }
}