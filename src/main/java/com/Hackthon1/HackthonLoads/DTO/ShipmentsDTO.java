package com.Hackthon1.HackthonLoads.DTO;

import lombok.Data;

@Data
public class ShipmentsDTO {

    Integer originId;

    Integer destinationId;

    Double latitude;

    Double longitude;

    Double totalWeight;

    String creationDate;

    String vehicleRequirements;

    String deliveryDate;
}
