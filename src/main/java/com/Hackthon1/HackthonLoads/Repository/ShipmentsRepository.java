package com.Hackthon1.HackthonLoads.Repository;

import com.Hackthon1.HackthonLoads.entity.Shipments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipments, Integer> {

    List<Shipments> findByOriginIdAndDestinationIdAndTotalWeight(Integer origin, Integer destination, Float totalWeight);

}
