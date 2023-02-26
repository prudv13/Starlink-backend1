package com.Hackthon1.HackthonLoads.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    int customerId;

    @Column(name = "originId")
    @NotNull
    int originId;

    @Column(name = "destinationId")
    @NotNull
    int destinationId;

    @Column(name = "latitude")
    double latitude;

    @Column(name = "longitude")
    double longitude;

    @Column(name = "vehicleRequirements")
    @NotNull
    String vehicleRequirements;

    @Column(name = "serviceType")
    String ServiceType;

    @Column(name = "totalWeight")
    @NotNull
    float totalWeight;

    @CreationTimestamp
    @Column(name = "CreationDate")
    LocalDateTime creationDate;

    @Column(name = "deliveryDate")
    @NotNull
    LocalDate deliveryDate;

    @Column(name = "instructions")
    String instructions;

    @Column(name = "maxPrice")
    float maxPrice;

    @Column(name = "minPrice")
    float minPrice;

}
