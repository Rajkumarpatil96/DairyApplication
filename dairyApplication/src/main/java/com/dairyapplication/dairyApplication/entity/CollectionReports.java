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
public class CollectionReports {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long reportId;
    private String reportMonth;
    private int reportYear;
    private Double totalEarnings;
    private int pdfReports;
    private LocalDate createdAt;
    private LocalDate updatedOn;
    private LocalDate reportDate;
    private String animalType;
    private String session;
    private Double totalQuantityLiters;
    private Double avgFatPercentage;

    @ManyToOne
    @JoinColumn(name = "farmer_unique_id")
    private FarmersDetails farmer;

}
