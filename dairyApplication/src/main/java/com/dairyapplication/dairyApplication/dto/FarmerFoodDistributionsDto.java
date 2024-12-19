package com.dairyapplication.dairyApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerFoodDistributionsDto {

    private String foodName;
    private Double rate;
    private Double quantity;
    private Double totalCost;
    private Double cashPayment;
    private LocalDate distributionDate;
    private String farmerUniqueid;

}
