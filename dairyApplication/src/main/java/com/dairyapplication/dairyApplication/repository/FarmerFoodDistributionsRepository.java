package com.dairyapplication.dairyApplication.repository;

import com.dairyapplication.dairyApplication.entity.FarmerFoodDistributions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerFoodDistributionsRepository extends JpaRepository<FarmerFoodDistributions,Long> {
}
