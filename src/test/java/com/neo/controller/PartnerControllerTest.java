package com.neo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dto.PartnerDto;
import com.neo.service.PartnerService;

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

@ContextConfiguration(classes = {PartnerController.class})
@ExtendWith(SpringExtension.class)
class PartnerControllerTest {
    @Autowired
    private PartnerController partnerController;

    @MockBean
    private PartnerService partnerService;

    /**
     * Method under test: {@link PartnerController#getAllPartners()}
     */
    @Test
    void testGetAllPartners() throws Exception {
        when(partnerService.getAllPartners()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/partners");
        MockMvcBuilders.standaloneSetup(partnerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PartnerController#getAllPartners()}
     */
    @Test
    void testGetAllPartners2() throws Exception {
        when(partnerService.getAllPartners()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/partners");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(partnerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PartnerController#deletePartner(Long)}
     */
    @Test
    void testDeletePartner() throws Exception {
        doNothing().when(partnerService).deletePartner((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/partners/{partnerId}", 123L);
        MockMvcBuilders.standaloneSetup(partnerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Partner Data delete sucessfully !!\",\"status\":true}"));
    }

    /**
     * Method under test: {@link PartnerController#deletePartner(Long)}
     */
    @Test
    void testDeletePartner2() throws Exception {
        doNothing().when(partnerService).deletePartner((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/partners/{partnerId}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(partnerController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Partner Data delete sucessfully !!\",\"status\":true}"));
    }

    /**
     * Method under test: {@link PartnerController#savePartner(PartnerDto)}
     */
    @Test
    void testSavePartner() throws Exception {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setPartnerContact("Partner Contact");
        partnerDto.setPartnerId(123L);
        partnerDto.setPartnerOrganisation("Partner Organisation");
        partnerDto.setPartnerWebsite("Partner Website");
        String content = (new ObjectMapper()).writeValueAsString(partnerDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/partners")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(partnerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link PartnerController#updatePartner(PartnerDto, Long)}
     */
    @Test
    void testUpdatePartner() throws Exception {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setPartnerContact("Partner Contact");
        partnerDto.setPartnerId(123L);
        partnerDto.setPartnerOrganisation("Partner Organisation");
        partnerDto.setPartnerWebsite("Partner Website");
        String content = (new ObjectMapper()).writeValueAsString(partnerDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/partners/{partnerId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(partnerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

