package com.dairyapplication.dairyApplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
@Table
public class OwnerRegistrationDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String mobileNumber;
    private String emailId;
    private String ownerUniqueId;
    private String address;
    private String userName;
    private String password;
    private String pincode;
    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String taluka;
    private String district;
    private String state;
    private String role;
    private String status;
    @Column(name="photo",columnDefinition = "MEDIUMBLOB")
    private byte[] photo;
}
