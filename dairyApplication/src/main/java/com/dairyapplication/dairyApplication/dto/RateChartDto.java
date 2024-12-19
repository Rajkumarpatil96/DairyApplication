package com.dairyapplication.dairyApplication.dto;

import lombok.Data;


import java.time.LocalDate;
@Data
public class RateChartDto {
    private String animalType;
    private String session;
    private double minFatPercentage;
    private double maxFatPercentage;
    private double pricePerLiter;
    private double baseFatPercentage;
    private double baseSNFPercentage;
    private LocalDate effectiveDate;

}
