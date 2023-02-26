package com.Hackthon1.HackthonLoads.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "loads")
public class
Loads {
    @Id
    @Column(name = " Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "vendorId")
    int vendorId;

    @Column(name = "startDate")
    LocalDate startDate;

    @Column(name = "originId")
    int originId;

    @Column(name = "destinationId")
    int destinationId;

    @Column(name = "latitude")
    double latitude;

    @Column(name = "longitude")
    double longitude;

    @Column(name = " originDoaMiles")
    float originDoaMiles;

    @Column(name = "destinationDoaMiles")
    float destinationDoaMiles;

    @Column(name = "capacity")
    double capacity;

    @Column(name = "transportType")
    int TransportType;

    @Column(name = "instructions")
    String instructions;
}
