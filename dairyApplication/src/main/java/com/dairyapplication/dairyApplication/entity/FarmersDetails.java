package com.dairyapplication.dairyApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Blob;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Builder
public class FarmersDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long farmerId;
    private String farmerUniqueId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String milkType;
    private String address;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedOn;
    @Column(name="farmer_photo",columnDefinition = "MEDIUMBLOB")
    private byte[] farmerPhoto;
    private LocalDate dateOfJoining;
    private String status;

    @ManyToOne
    @JoinColumn(name = "owner_unique_id")
    private OwnerRegistrationDetails owner;




}
