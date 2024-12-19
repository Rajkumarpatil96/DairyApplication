package com.dairyapplication.dairyApplication.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class MilkQualityTests {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long testId;
    private LocalDate testDate;
    private Double fatPercentage;
    private Double snfPercentage;
    private Double acidityLevel;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collections collection;
}
