package com.dairyapplication.dairyApplication.controller;


import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.dto.FoodStockDetailsDto;
import com.dairyapplication.dairyApplication.service.FoodStockDetailsIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FoodStockDetailsController {
    @Autowired
    private FoodStockDetailsIface foodStockDetailsIface;

    @PostMapping("/foodstockDetails")
    public ApiResponse addFoodStockDetails(@RequestBody FoodStockDetailsDto foodStockDetailsDto){
        return foodStockDetailsIface.createFoodStockDetails(foodStockDetailsDto);
    }
}
