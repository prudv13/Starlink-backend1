package com.Hackthon1.HackthonLoads.Service;


import com.Hackthon1.HackthonLoads.Repository.CitiesRepository;
import com.Hackthon1.HackthonLoads.entity.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {

    @Autowired
    CitiesRepository citiesRepository;

    public List<Cities> getCities() {
        return citiesRepository.findAll();
    }

    public Optional<Cities> getCityById(int id) {
        return citiesRepository.findById(id);
    }

}
