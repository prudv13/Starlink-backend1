package com.Hackthon1.HackthonLoads.Repository;

import com.Hackthon1.HackthonLoads.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Integer> {
    Cities findOneByCity(String City);
}
