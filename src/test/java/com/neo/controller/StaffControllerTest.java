package com.neo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dto.StaffDto;
import com.neo.service.StaffService;

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

@ContextConfiguration(classes = {StaffController.class})
@ExtendWith(SpringExtension.class)
class StaffControllerTest {
    @Autowired
    private StaffController staffController;

    @MockBean
    private StaffService staffService;

    /**
     * Method under test: {@link StaffController#saveStaff(StaffDto)}
     */
    @Test
    void testSaveStaff() throws Exception {
        when(staffService.saveStaff((StaffDto) any())).thenReturn(new StaffDto());

        StaffDto staffDto = new StaffDto();
        staffDto.setStaffAadhaar("Staff Aadhaar");
        staffDto.setStaffContact("Staff Contact");
        staffDto.setStaffDOB("Staff DOB");
        staffDto.setStaffDepartment("Staff Department");
        staffDto.setStaffDesignation("Staff Designation");
        staffDto.setStaffGender("Staff Gender");
        staffDto.setStaffId(123L);
        staffDto.setStaffName("Staff Name");
        String content = (new ObjectMapper()).writeValueAsString(staffDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/staff")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(staffController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"staffId\":null,\"staffName\":null,\"staffContact\":null,\"staffAadhaar\":null,\"staffDesignation\":null,"
                                        + "\"staffDepartment\":null,\"staffGender\":null,\"staffDOB\":null}"));
    }

    /**
     * Method under test: {@link StaffController#updateStaff(StaffDto, Long)}
     */
    @Test
    void testUpdateStaff() throws Exception {
        when(staffService.updateStaff((StaffDto) any(), (Long) any())).thenReturn(new StaffDto());

        StaffDto staffDto = new StaffDto();
        staffDto.setStaffAadhaar("Staff Aadhaar");
        staffDto.setStaffContact("Staff Contact");
        staffDto.setStaffDOB("Staff DOB");
        staffDto.setStaffDepartment("Staff Department");
        staffDto.setStaffDesignation("Staff Designation");
        staffDto.setStaffGender("Staff Gender");
        staffDto.setStaffId(123L);
        staffDto.setStaffName("Staff Name");
        String content = (new ObjectMapper()).writeValueAsString(staffDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/{staffId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(staffController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"staffId\":null,\"staffName\":null,\"staffContact\":null,\"staffAadhaar\":null,\"staffDesignation\":null,"
                                        + "\"staffDepartment\":null,\"staffGender\":null,\"staffDOB\":null}"));
    }

    /**
     * Method under test: {@link StaffController#getAllStaff()}
     */
    @Test
    void testGetAllStaff() throws Exception {
        when(staffService.getAllStaff()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/staff");
        MockMvcBuilders.standaloneSetup(staffController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StaffController#getAllStaff()}
     */
    @Test
    void testGetAllStaff2() throws Exception {
        when(staffService.getAllStaff()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/staff");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(staffController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StaffController#deleteStaff(Long)}
     */
    @Test
    void testDeleteStaff() throws Exception {
        doNothing().when(staffService).deleteStaff((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/{staffId}", 123L);
        MockMvcBuilders.standaloneSetup(staffController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Staff Data delete sucessfully !!\",\"status\":false}"));
    }

    /**
     * Method under test: {@link StaffController#deleteStaff(Long)}
     */
    @Test
    void testDeleteStaff2() throws Exception {
        doNothing().when(staffService).deleteStaff((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/{staffId}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(staffController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Staff Data delete sucessfully !!\",\"status\":false}"));
    }
}

