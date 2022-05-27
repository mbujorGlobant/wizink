package com.wizink;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseClient houseClient;

    public HouseService(HouseClient houseClient) {
        this.houseClient = houseClient;
    }

    public List<House> getHouses() {
        return houseClient.getHouses() ;
    }

    public House getHouse(Long id) {
        return houseClient.getHouse(id);
    }
}
