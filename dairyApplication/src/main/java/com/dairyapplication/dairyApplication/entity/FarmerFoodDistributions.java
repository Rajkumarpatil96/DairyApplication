package com.dairyapplication.dairyApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class FarmerFoodDistributions {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long distributionId;
    private String foodName;
    private Double rate;
    private Double quantity;
    private Double totalCost;
    private Double cashPayment;
    private LocalDate distributionDate;

    @ManyToOne
    @JoinColumn(name = "farmer_unique_id")
    private FarmersDetails farmer;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodStockDetails foodStock;
}
