package com.dairyapplication.dairyApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodStockDetailsDto {
    private String foodName;
    private Double quantity;
    private String brand;
    private Double buyRate;
    private Double saleRate;
    private Double amountPaid;
    private Double stockQuantityKg;
    private Double unitPrice;
}
