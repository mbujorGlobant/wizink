package com.wizink;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "houses", url = "${got.service.url}")
public interface HouseClient {

    @RequestMapping(method = RequestMethod.GET, value = "/houses")
    List<House> getHouses();

    @RequestMapping(method = RequestMethod.GET, value = "/houses/{id}")
    House getHouse(@PathVariable("id") Long id);
}