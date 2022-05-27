package com.wizink;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HousesController {

    private final HouseService houseService;

    public HousesController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    public List<House> getHouses() {
        return houseService.getHouses();
    }

    @GetMapping("/houses/{id}")
    public House getHouse(@PathVariable("id") Long id) {
        return houseService.getHouse(id);
    }
}
