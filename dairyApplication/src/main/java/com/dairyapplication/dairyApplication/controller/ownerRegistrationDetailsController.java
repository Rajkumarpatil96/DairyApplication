package com.dairyapplication.dairyApplication.controller;

import com.dairyapplication.dairyApplication.dto.OwnerRegistrationDetailsDto;
import com.dairyapplication.dairyApplication.entity.OwnerRegistrationDetails;
import com.dairyapplication.dairyApplication.service.OwnerRegistrationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class ownerRegistrationDetailsController {
    @Autowired
    OwnerRegistrationDetailsService ownerRegistrationDetailsService;
    @PostMapping("/registerowner")
    public String registerOwner(@RequestBody OwnerRegistrationDetailsDto details){
      String number= details.getMobileNumber();
      String email=details.getEmailId();
        boolean emailExist=ownerRegistrationDetailsService.checkEmailExist(email);
        if( emailExist || ownerRegistrationDetailsService.checkOwnermobileNumberexist(number)){
            if(emailExist){
                return "email exist";
            }else {
                return "mobile number already exist";
            }

        }else{
           OwnerRegistrationDetails owner=ownerRegistrationDetailsService.createOwnerOfDairy(details);
            return "Owner Registered succesfully with this username.."+owner.getUserName();
        }

    }
    @PutMapping("/updateOwner/{unique}")
    public OwnerRegistrationDetails updateOwner(@RequestBody OwnerRegistrationDetailsDto dto,@PathVariable String unique){
        return ownerRegistrationDetailsService.updateOwner(unique,dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOwner(@PathVariable String id){
        return ownerRegistrationDetailsService.deleteOwner(id);
    }

}
