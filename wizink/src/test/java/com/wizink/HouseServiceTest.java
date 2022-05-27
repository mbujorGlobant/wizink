package com.wizink;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.wizink.House;
import com.wizink.HouseClient;
import com.wizink.HouseService;

@SpringBootTest
public class HouseServiceTest {

    @Mock
    private HouseClient houseClient;

    @InjectMocks
    private HouseService houseService;

    @Test
    public void whenGetHousesEverythingOk() {
        List<House> houses = new ArrayList<>();
        houses.add(TestDataBuilder.createTestHouse());
        when(houseClient.getHouses())
                .thenReturn(houses);
        List<House> result = houseService.getHouses();
        Assert.assertEquals(result, houses);
    }

    @Test
    public void whenGetHouseByIdEverythingOk() {
        House expectedHouse = TestDataBuilder.createTestHouse();
        when(houseClient.getHouse(1L))
                .thenReturn(expectedHouse);
        House actualHouse = houseService.getHouse(1L);
        assertThat(actualHouse).isEqualTo(expectedHouse);
    }
}

