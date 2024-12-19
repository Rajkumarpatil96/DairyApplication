package com.dairyapplication.dairyApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class FoodStockDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;
    private String foodName;
    private Double quantity;
    private String brand;
    private Double buyRate;
    private Double saleRate;
    private Double amountPaid;
    private Double stockQuantityKg;
    private Double unitPrice;
}
