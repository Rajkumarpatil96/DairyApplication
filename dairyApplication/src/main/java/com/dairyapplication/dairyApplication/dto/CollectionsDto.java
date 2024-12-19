package com.dairyapplication.dairyApplication.dto;

import com.dairyapplication.dairyApplication.entity.FarmersDetails;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
public class CollectionsDto {
    private String animalType;
    private Double quantityLiters;
    private double snfPercentage;
    private double fatPercentage;
    private String session;
    private Double totalPrice;
    private String farmerUniqueId;
    //private FarmersDetails details;

}
