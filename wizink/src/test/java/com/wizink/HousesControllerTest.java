package com.wizink;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.wizink.House;
import com.wizink.HouseService;

@WebMvcTest
public class HousesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HouseService houseService;

    @Test
    public void whenGetHousessEverythingOk() throws Exception {
        List<House> houses = new ArrayList<>();
        houses.add(TestDataBuilder.createTestHouse());
        Mockito.when(houseService.getHouses()).thenReturn(houses);
        mockMvc.perform(get("/api/houses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", Matchers.equalTo(houses.get(0).getName())))
                .andExpect(jsonPath("$.[0].seats[0]", Matchers.equalTo(houses.get(0).getSeats().get(0))))
                .andExpect(jsonPath("$.[0].coatOfArms", Matchers.equalTo(houses.get(0).getCoatOfArms())))
                .andExpect(jsonPath("$.[0].region", Matchers.equalTo(houses.get(0).getRegion())));
    }

    @Test
    public void whenGetHouseEverythingOk() throws Exception {
        House expectedHouse = TestDataBuilder.createTestHouse();
        Mockito.when(houseService.getHouse(1L)).thenReturn(expectedHouse);
        mockMvc.perform(get("/api/houses/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.equalTo(expectedHouse.getName())))
                .andExpect(jsonPath("$.seats[0]", Matchers.equalTo(expectedHouse.getSeats().get(0))))
                .andExpect(jsonPath("$.coatOfArms", Matchers.equalTo(expectedHouse.getCoatOfArms())))
                .andExpect(jsonPath("$.region", Matchers.equalTo(expectedHouse.getRegion())))
                .andExpect(jsonPath("$.words", Matchers.equalTo(expectedHouse.getWords())));
    }
}

