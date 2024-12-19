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
public class FarmerAdvances {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long advanceId;
    private Double amount;
    private Double interestRate;
    private LocalDate createdAt;
    private String comments;
    private LocalDate advanceDate;
    private String purpose;
    private String repaymentStatus;
    private LocalDate repaymentDate;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "farmer_unique_id")
    private FarmersDetails farmer;
}
