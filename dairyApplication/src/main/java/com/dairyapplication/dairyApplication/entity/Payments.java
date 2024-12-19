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
public class Payments {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long paymentId;
    private LocalDate paymentDate;
    private Double totalAmount;
    private Double advanceDeducted;
    private Double netAmount;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name="farmer_unique_id")
    private FarmersDetails details;
}
