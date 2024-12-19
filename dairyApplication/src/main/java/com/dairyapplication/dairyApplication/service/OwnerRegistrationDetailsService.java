package com.dairyapplication.dairyApplication.service;

import com.dairyapplication.dairyApplication.dto.OwnerRegistrationDetailsDto;
import com.dairyapplication.dairyApplication.entity.OwnerRegistrationDetails;

public interface OwnerRegistrationDetailsService {
    OwnerRegistrationDetails createOwnerOfDairy(OwnerRegistrationDetailsDto ownerRegistrationDetailsDto);
    OwnerRegistrationDetails updateOwner(String uniqueId,OwnerRegistrationDetailsDto details);
    String deleteOwner(String id);
    OwnerRegistrationDetails getOwnerDetails(String id);
    boolean checkOwnermobileNumberexist(String mobileNumber);
    boolean checkEmailExist(String email);
}
