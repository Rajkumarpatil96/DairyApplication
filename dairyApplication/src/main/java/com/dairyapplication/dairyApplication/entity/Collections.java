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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
@EntityListeners(AuditingEntityListener.class)
public class Collections {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long collectionId;
    private String animalType;
    private Double quantityLiters;
    private Double pricePerLiter;
    @CreatedDate
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedOn;
    private double snfPercentage;
    private double fatPercentage;
    private String session;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name="farmer_unique_id")
    private FarmersDetails details;
}
