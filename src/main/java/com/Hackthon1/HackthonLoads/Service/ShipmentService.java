package com.Hackthon1.HackthonLoads.Service;

import com.Hackthon1.HackthonLoads.DTO.LiveEventDTO;
import com.Hackthon1.HackthonLoads.DTO.ShipmentsDTO;
import com.Hackthon1.HackthonLoads.Repository.ShipmentsRepository;
import com.Hackthon1.HackthonLoads.entity.Shipments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    ShipmentsRepository shipmentsRepository;

    public List<Shipments> getShipments() {
        return shipmentsRepository.findAll();
    }


    public Shipments addShipments(Shipments newShipments) {
        return shipmentsRepository.save(newShipments);
    }

    public List<Shipments> getDataByDetails(ShipmentsDTO shipmentsDTO) {

        List<Shipments> shipmentsList = shipmentsRepository.findAll();
        System.out.println(shipmentsList);
        List<Shipments> availableLoads = new ArrayList<>();
        boolean IsValid;

        if (shipmentsDTO.getOriginId() != null && shipmentsDTO.getDestinationId() != null) {
            for (Shipments data : shipmentsList) {
                IsValid = false;
                if (data.getOriginId() == shipmentsDTO.getOriginId() && data.getDestinationId() == shipmentsDTO.getDestinationId()) {
                    IsValid = true;
                }
                if (shipmentsDTO.getTotalWeight() != null && data.getTotalWeight() > shipmentsDTO.getTotalWeight()) {

                    IsValid = false;
                }

                if (shipmentsDTO.getDeliveryDate() != null && !data.getDeliveryDate().isEqual(LocalDate.parse(shipmentsDTO.getDeliveryDate()))) {
                    IsValid = false;
                }

                if (shipmentsDTO.getVehicleRequirements() != null && data.getVehicleRequirements() == shipmentsDTO.getVehicleRequirements()) {
                    IsValid = false;
                }

                if (IsValid) {
                    availableLoads.add(data);
                }
            }
            return availableLoads;
        } else if (shipmentsDTO.getLatitude() != null && shipmentsDTO.getLongitude() != null) {
            for (Shipments data : shipmentsList) {
                IsValid = false;
                if (data.getLatitude() == shipmentsDTO.getLatitude() && data.getLongitude() == shipmentsDTO.getLongitude()) {
                    IsValid = true;
                }
                if (shipmentsDTO.getTotalWeight() != null && data.getTotalWeight() > shipmentsDTO.getTotalWeight()) {

                    IsValid = false;
                }

                if (shipmentsDTO.getDeliveryDate() != null && !data.getDeliveryDate().isEqual(LocalDate.parse(shipmentsDTO.getDeliveryDate()))) {
                    IsValid = false;
                }

                if (shipmentsDTO.getVehicleRequirements() != null && data.getVehicleRequirements() == shipmentsDTO.getVehicleRequirements()) {
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

    public Shipments latestShipment(LiveEventDTO newLiveEventDTO) {

        List<Shipments> allShipments = shipmentsRepository.findByOriginIdAndDestinationIdAndTotalWeight(newLiveEventDTO.getOriginId(), newLiveEventDTO.getDestinationId(), newLiveEventDTO.getTotalWeight());
        Comparator<Shipments> comparator = Comparator.comparing(Shipments::getCreationDate);
        return allShipments.stream().max(comparator).orElse(new Shipments());
    }
}
