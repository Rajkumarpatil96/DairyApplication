package com.dairyapplication.dairyApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)

public class RateChart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String animalType;
    private String session;
    private double minFatPercentage;
    private double maxFatPercentage;
    private double pricePerLiter;
    private double baseFatPercentage;
    private double baseSNFPercentage;
    private LocalDate effectiveDate;
    @CreatedDate
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedOn;
    public RateChart(){

    }
}
