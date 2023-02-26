package com.Hackthon1.HackthonLoads.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@Data
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    int cityId;

    @Column(name = "city")
    String city;

    @Column(name = "latitude")
    double latitude;

    @Column(name = "longitude")
    double longitude;

    @Column(name = "country")
    String country;
}
