package com.dairyapplication.dairyApplication.service.impl;

import com.dairyapplication.dairyApplication.dto.FarmerFoodDistributionsDto;
import com.dairyapplication.dairyApplication.entity.FarmerFoodDistributions;
import com.dairyapplication.dairyApplication.entity.FarmersDetails;
import com.dairyapplication.dairyApplication.repository.FarmerFoodDistributionsRepository;
import com.dairyapplication.dairyApplication.repository.FarmerRepository;
import com.dairyapplication.dairyApplication.service.FarmerFoodDistributionsIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerFoodDistributionsIfaceImpl implements FarmerFoodDistributionsIface {
    @Autowired
    private FarmerFoodDistributionsRepository farmerFoodDistributionsRepository;
    @Autowired
   private FarmerRepository farmerRepository;


    @Override
    public FarmerFoodDistributions createFarmerFoodDistribution(FarmerFoodDistributionsDto farmerFoodDistributionsDto) {
      FarmersDetails existUser = farmerRepository.findByFarmerUniqueId(farmerFoodDistributionsDto.getFarmerUniqueid());
      if(existUser!=null){

      }

        return null;
    }
}