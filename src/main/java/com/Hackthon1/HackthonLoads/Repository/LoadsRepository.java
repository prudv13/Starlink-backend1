package com.Hackthon1.HackthonLoads.Repository;

import com.Hackthon1.HackthonLoads.entity.Loads;
import com.Hackthon1.HackthonLoads.entity.QualifiedVendorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadsRepository extends JpaRepository<Loads, Integer> {

    @Query(value = "select l.vendorId as VendorId, " +
            "ST_AsText(l.location) as Location " +
            "from loads l " +
            "where l.Id = :id", nativeQuery = true)
    QualifiedVendorDTO searchById(Integer id);

}
