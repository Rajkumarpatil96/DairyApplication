package com.dairyapplication.dairyApplication.repository;

import com.dairyapplication.dairyApplication.entity.Collections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionsRepository extends JpaRepository<Collections,Long> {
    @Query(value = "select * from collections where farmer_unique_id =?1", nativeQuery = true)
    List<Collections> findByFarmerUniqueId(String uniqueId);

    Collections findByCollectionId(Long collectionId);

    @Query(value = "SELECT * FROM collections WHERE updated_on BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Collections> findCollectionsBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);
}