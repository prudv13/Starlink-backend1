package com.Hackthon1.HackthonLoads.Controller;

import com.Hackthon1.HackthonLoads.DTO.LoadPostDTO;
import com.Hackthon1.HackthonLoads.DTO.LoadsDTO;
import com.Hackthon1.HackthonLoads.Service.CitiesService;
import com.Hackthon1.HackthonLoads.Service.LoadService;
import com.Hackthon1.HackthonLoads.entity.Cities;
import com.Hackthon1.HackthonLoads.entity.Loads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class loadsController {


    @Autowired
    CitiesService citiesService;

    @Autowired
    LoadService loadService;


    @PostMapping("/addData")
    public Loads addData(@Validated @RequestBody LoadPostDTO loads) {
        return loadService.addLoadData(loads);
    }

    @GetMapping("/getAllLoads")
    public List<Loads> getLoads() {
        return loadService.getAllLoads();
    }

    ;

    @GetMapping("/getAllCities")
    public List<Cities> getCities() {
        return citiesService.getCities();
    }

    @GetMapping("/getCity/{id}")
    public Optional<Cities> getCityById(@PathVariable(value = "id") int id) {
        return citiesService.getCityById(id);
    }

    @GetMapping("/getDataByDetails")
    public List<Loads> getDataByDetails(@RequestBody LoadsDTO loadsDTO) {
        System.out.println(loadsDTO);
        return loadService.getDataByLocation(loadsDTO);
    }


}
