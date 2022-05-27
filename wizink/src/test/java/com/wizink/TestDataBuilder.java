package com.wizink;


import java.util.Arrays;
import java.util.Collections;

import com.wizink.House;

public class TestDataBuilder {

    private TestDataBuilder() {
    }

    public static House createTestHouse() {
        House house = new House();
        house.setName("House Algood");
        house.setSeats(Arrays.asList("Godsgrace"));
        house.setWords("No Foe May Pass");
        house.setCoatOfArms("A golden wreath, on a blue field with a gold border(Azure, a garland of laurel within a bordure or)");
        house.setRegion("The Westerlands");
        return house;
    }


}
