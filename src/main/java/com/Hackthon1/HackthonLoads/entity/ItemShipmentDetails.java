package com.Hackthon1.HackthonLoads.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemDetails")
@Data
public class ItemShipmentDetails {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "itemName")
    String itemName;

    @Column(name = "itemType")
    String item_type;

    @Column(name = "itemDescription")
    String itemDescription;

    @Column(name = "quantity")
    float quantity;

}
