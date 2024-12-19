package com.dairyapplication.dairyApplication.repository;

import com.dairyapplication.dairyApplication.entity.FoodStockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodStockDetailsRepository extends JpaRepository<FoodStockDetails,Long> {
}
