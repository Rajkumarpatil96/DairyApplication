package com.dairyapplication.dairyApplication.service.impl;

import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.dto.FarmerFoodDistributionsDto;
import com.dairyapplication.dairyApplication.dto.FoodStockDetailsDto;
import com.dairyapplication.dairyApplication.entity.FarmerFoodDistributions;
import com.dairyapplication.dairyApplication.entity.FoodStockDetails;
import com.dairyapplication.dairyApplication.repository.FoodStockDetailsRepository;
import com.dairyapplication.dairyApplication.service.FarmerFoodDistributionsIface;
import com.dairyapplication.dairyApplication.service.FoodStockDetailsIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodStockDetailsIfaceImpl  implements FoodStockDetailsIface {
    @Autowired
    private FoodStockDetailsRepository foodStockDetailsRepository;
    @Override
    public ApiResponse createFoodStockDetails(FoodStockDetailsDto foodStockDetailsDto) {
        try{
            if(foodStockDetailsDto != null){
               FoodStockDetails foodStockDetail = FoodStockDetails.builder().foodId(113L).stockQuantityKg(foodStockDetailsDto.getStockQuantityKg()).foodName(foodStockDetailsDto.getFoodName()).amountPaid(foodStockDetailsDto.getAmountPaid())
                        .brand(foodStockDetailsDto.getBrand()).buyRate(foodStockDetailsDto.getBuyRate())
                        .saleRate(foodStockDetailsDto.getSaleRate()).unitPrice(foodStockDetailsDto.getBuyRate()/ foodStockDetailsDto.getStockQuantityKg()).quantity(foodStockDetailsDto.getQuantity())
                        .build();
                foodStockDetailsRepository.save(foodStockDetail);
                return new ApiResponse("Food stocks details added succesfully",true,foodStockDetail);
            }
            return new ApiResponse("Food Stock Details not added ",false,null);
        }catch(Exception e){
            e.printStackTrace();
            return new ApiResponse("Something went wrong, please try again",false,null);
        }

    }
}
