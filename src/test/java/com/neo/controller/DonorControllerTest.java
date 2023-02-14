package com.neo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dto.DonorDto;
import com.neo.service.DonorService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DonorController.class})
@ExtendWith(SpringExtension.class)
class DonorControllerTest {
    @Autowired
    private DonorController donorController;

    @MockBean
    private DonorService donorService;

    /**
     * Method under test: {@link DonorController#deleteDonor(Long)}
     */
    @Test
    void testDeleteDonor() throws Exception {
        doNothing().when(donorService).deleteDonors((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/donors/{donorId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(donorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Donor Data delete sucessfully !!\",\"status\":true}"));
    }

    /**
     * Method under test: {@link DonorController#getAllDonors()}
     */
    @Test
    void testGetAllDonors() throws Exception {
        when(donorService.getAllDonors()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/donors");
        MockMvcBuilders.standaloneSetup(donorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DonorController#getAllDonors()}
     */
    @Test
    void testGetAllDonors2() throws Exception {
        when(donorService.getAllDonors()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/donors");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(donorController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DonorController#deleteDonor(Long)}
     */
    @Test
    void testDeleteDonor2() throws Exception {
        doNothing().when(donorService).deleteDonors((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/donors/{donorId}", 123L);
        deleteResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(donorController)
                .build()
                .perform(deleteResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Donor Data delete sucessfully !!\",\"status\":true}"));
    }

    /**
     * Method under test: {@link DonorController#saveDonor(DonorDto)}
     */
    @Test
    void testSaveDonor() throws Exception {
        DonorDto donorDto = new DonorDto();
        donorDto.setDonorAmount(1L);
        donorDto.setDonorContact("Donor Contact");
        donorDto.setDonorDOB("Donor DOB");
        donorDto.setDonorGender("Donor Gender");
        donorDto.setDonorId(123L);
        donorDto.setDonorName("Donor Name");
        donorDto.setDonorPAN("Donor PAN");
        String content = (new ObjectMapper()).writeValueAsString(donorDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/donors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(donorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link DonorController#updateDonor(DonorDto, Long)}
     */
    @Test
    void testUpdateDonor() throws Exception {
        DonorDto donorDto = new DonorDto();
        donorDto.setDonorAmount(1L);
        donorDto.setDonorContact("Donor Contact");
        donorDto.setDonorDOB("Donor DOB");
        donorDto.setDonorGender("Donor Gender");
        donorDto.setDonorId(123L);
        donorDto.setDonorName("Donor Name");
        donorDto.setDonorPAN("Donor PAN");
        String content = (new ObjectMapper()).writeValueAsString(donorDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/donors/{donorId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(donorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

