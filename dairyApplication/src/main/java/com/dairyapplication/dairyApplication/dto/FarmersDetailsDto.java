package com.dairyapplication.dairyApplication.dto;

import com.dairyapplication.dairyApplication.entity.OwnerRegistrationDetails;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Blob;
import java.time.LocalDate;
@Data
public class FarmersDetailsDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String milkType;
    private String address;
    private byte[] farmerPhoto;
    private LocalDate dateOfJoining;
    private String status;
    private OwnerRegistrationDetails owner;
}
