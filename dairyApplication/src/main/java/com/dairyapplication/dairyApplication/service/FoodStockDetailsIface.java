package com.dairyapplication.dairyApplication.service;

import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.dto.FoodStockDetailsDto;
import com.dairyapplication.dairyApplication.entity.FoodStockDetails;

public interface FoodStockDetailsIface {
    ApiResponse createFoodStockDetails(FoodStockDetailsDto foodStockDetailsDto);
}
