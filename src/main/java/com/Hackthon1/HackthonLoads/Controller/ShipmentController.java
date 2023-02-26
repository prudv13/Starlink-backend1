package com.Hackthon1.HackthonLoads.Controller;

import com.Hackthon1.HackthonLoads.DTO.LiveEventDTO;
import com.Hackthon1.HackthonLoads.DTO.ShipmentsDTO;
import com.Hackthon1.HackthonLoads.Repository.ShipmentsRepository;
import com.Hackthon1.HackthonLoads.Service.ShipmentService;
import com.Hackthon1.HackthonLoads.entity.Shipments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
@CrossOrigin("*")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;
    @Autowired
    ShipmentsRepository shipmentsRepository;

    @GetMapping("/getAllShipments")
    public List<Shipments> getAllShipments() {
        return shipmentService.getShipments();
    }

    @PostMapping("/addShipment")
    public Shipments addShipments(@Validated @RequestBody Shipments newShipments) {
        return shipmentService.addShipments(newShipments);
    }


    @GetMapping("/getShipmentsByFilter")
    public List<Shipments> getShipmentsByFilter(@RequestBody ShipmentsDTO newShipmentsDTO) {
        return shipmentService.getDataByDetails(newShipmentsDTO);
    }


    @GetMapping("/fetchLatestEvents")
    public Shipments getLatestShipment(@RequestBody LiveEventDTO liveEventDTO) {

        return shipmentService.latestShipment(liveEventDTO);

    }

}
