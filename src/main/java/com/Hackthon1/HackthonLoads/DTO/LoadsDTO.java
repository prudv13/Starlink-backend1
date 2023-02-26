package com.Hackthon1.HackthonLoads.DTO;

import lombok.Data;


@Data
public class LoadsDTO {

    Integer originId;

    String startDate;

    Integer destinationId;

    Double latitude;

    Double longitude;

    Double capacity;

    Integer TransportType;

}
