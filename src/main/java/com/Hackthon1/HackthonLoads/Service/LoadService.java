package com.Hackthon1.HackthonLoads.Service;


import com.Hackthon1.HackthonLoads.DTO.LoadPostDTO;
import com.Hackthon1.HackthonLoads.DTO.LoadsDTO;
import com.Hackthon1.HackthonLoads.Repository.CitiesRepository;
import com.Hackthon1.HackthonLoads.Repository.LoadsRepository;
import com.Hackthon1.HackthonLoads.entity.Cities;
import com.Hackthon1.HackthonLoads.entity.Loads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LoadService {
    @Autowired
    LoadsRepository loadsRepository;

    @Autowired
    CitiesRepository citiesRepository;


    public List<Loads> getAllLoads() {
        return loadsRepository.findAll();
    }


    public Loads addLoadData(LoadPostDTO newLoad) {
        Loads load = new Loads();
        Cities origin = citiesRepository.findOneByCity(newLoad.getOrigin().trim());
        Cities destination = citiesRepository.findOneByCity(newLoad.getDestination().trim());
        load.setOriginId(origin.getCityId());
        load.setDestinationId(destination.getCityId());
        load.setCapacity(Double.parseDouble(newLoad.getCapacity().trim()));
        load.setStartDate(LocalDate.parse(newLoad.getStartDate().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        load.setTransportType(MapToVehicle(newLoad.getTransportType()));
        return loadsRepository.save(load);
    }

    public Integer MapToVehicle(String vehicle) {
        switch (vehicle.trim()) {
            case "NONE":
                return 0;
            case "BIKE":
                return 1;
            case "AUTO":
                return 2;
            case "VAN":
                return 3;
            case "TRUCK":
                return 4;
        }
        return 0;
    }

    public List<Loads> getDataByLocation(LoadsDTO loadsDTO) {

        List<Loads> loadsList = loadsRepository.findAll();
        List<Loads> availableLoads = new ArrayList<>();
        boolean IsValid;
        if (loadsDTO.getOriginId() != null && loadsDTO.getDestinationId() != null) {
            for (Loads data : loadsList) {
                IsValid = false;
                if (data.getOriginId() == loadsDTO.getOriginId() && data.getDestinationId() == loadsDTO.getDestinationId()) {
                    IsValid = true;
                }
                if (loadsDTO.getCapacity() != null && data.getCapacity() < loadsDTO.getCapacity()) {
                    IsValid = false;
                }

                if (loadsDTO.getStartDate() != null && !data.getStartDate().isEqual(LocalDate.parse(loadsDTO.getStartDate()))) {
                    IsValid = false;
                }

                if (loadsDTO.getTransportType() != null && data.getTransportType() != loadsDTO.getTransportType()) {
                    IsValid = false;
                }

                if (IsValid) {
                    availableLoads.add(data);
                }
            }
            return availableLoads;
        } else if (loadsDTO.getLatitude() != null && loadsDTO.getLongitude() != null) {

            for (Loads data : loadsList) {
                IsValid = false;
                if (data.getLatitude() == loadsDTO.getLatitude() && data.getLongitude() == loadsDTO.getLongitude()) {
                    IsValid = true;
                }
                if (loadsDTO.getCapacity() != null && data.getCapacity() < loadsDTO.getCapacity()) {
                    IsValid = false;
                }

                if (loadsDTO.getStartDate() != null && !data.getStartDate().isEqual(LocalDate.parse(loadsDTO.getStartDate()))) {
                    IsValid = false;
                }

                if (loadsDTO.getTransportType() != null && data.getTransportType() != loadsDTO.getTransportType()) {
                    IsValid = false;
                }

                if (IsValid) {
                    availableLoads.add(data);
                }
            }
            return availableLoads;
        } else {
            return Collections.emptyList();
        }
    }

}
