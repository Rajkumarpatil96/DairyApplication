package com.dairyapplication.dairyApplication.repository;

import com.dairyapplication.dairyApplication.entity.FarmersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerRepository  extends JpaRepository<FarmersDetails,Long> {
    FarmersDetails findByFarmerUniqueId(String uniqueId);
    @Query(value = "select first_name from farmers_details where first_name like %?1%;",nativeQuery = true)
    List<String> getFarmerListByFarmerName( String name);

    // LIKE query for mobile
    @Query(value = "select mobile_number from farmers_details where mobile_number like %?1%;",nativeQuery = true)
    List<String> getFarmerListByMobileNumber( String mobileNumber);

    @Query(value = "SELECT * FROM farmers_details WHERE mobile_number = ?1 OR first_name = ?2", nativeQuery = true)
    FarmersDetails findByMobileNumberOrFirstName(String mobileNumber,String firstName);

}
