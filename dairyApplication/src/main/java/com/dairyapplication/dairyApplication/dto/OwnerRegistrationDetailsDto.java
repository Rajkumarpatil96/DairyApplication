package com.dairyapplication.dairyApplication.dto;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
@Data
public class OwnerRegistrationDetailsDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String ownerUniqueId;
    private String address;
    private String userName;
    private String password;
    private String pincode;
    private String gender;
    private LocalDate dateOfBirth;
    private String taluka;
    private String district;
    private String state;
    private String role;
    private String status;
    private String photo;
}
