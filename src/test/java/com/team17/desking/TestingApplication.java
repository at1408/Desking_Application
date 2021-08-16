package com.team17.desking;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingApplication {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Working Great")));
    }

    @Test
    public void boookingControlTest() throws Exception {
        this.mockMvc.perform(get("/desking/booking/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("dateOfBooking")));
    }

    @Test
    public void userSignInControlCheck() throws Exception {
        this.mockMvc.perform(post("/desking/signin/rsc@gmail.com")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    public void testBuildingGetRequest() throws Exception {
        this.mockMvc.perform(get("/desking/buildings")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("buildingName")));
    }

    @Test
    public void testBuildingByIdGetRequest() throws Exception {
        this.mockMvc.perform(get("/desking/buildings/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testBuildingPostRequest() throws Exception {
        Object randomObj = new Object() {
            public final String buildingName = "Tower Y";
            public final int noOfFloor = 3;
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        this.mockMvc.perform(post("/desking/buildings/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    public void testBookingCreatePostRequest() throws Exception {
        Object randomObj = new Object() {
            public final long seat_ID= 12;
            public final String dateOfBooking = "2021-08-18T22:54:01.754Z";
            public final int floorNo = 3;
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        this.mockMvc.perform(post("/desking/booking/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    public void testSeatAddition() throws Exception {
        Object randomObj = new Object() {
            public final long buildingId= 12;
            public final boolean booked = true;
            public final boolean blocked = true;
            public final int floorNo = 3;
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        this.mockMvc.perform(post("/seats/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    }