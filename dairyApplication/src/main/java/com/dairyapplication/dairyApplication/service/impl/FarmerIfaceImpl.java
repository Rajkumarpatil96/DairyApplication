package com.dairyapplication.dairyApplication.service.impl;

import com.dairyapplication.dairyApplication.Exception.FarmerServiceAsset;
import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.apputil.MilkType;
import com.dairyapplication.dairyApplication.apputil.PasswordEncrypter;
import com.dairyapplication.dairyApplication.dto.FarmersDetailsDto;
import com.dairyapplication.dairyApplication.entity.FarmersDetails;
import com.dairyapplication.dairyApplication.repository.FarmerRepository;
import com.dairyapplication.dairyApplication.service.FarmerIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Service
public class FarmerIfaceImpl implements FarmerIface {
    @Autowired
    FarmerRepository farmerRepository;

    @Override
    public ApiResponse createFarmer(FarmersDetailsDto farmersDetailsDto) {
        FarmersDetails farmer = FarmersDetails.builder().farmerUniqueId(UUID.randomUUID().toString()).dateOfJoining(LocalDate.now())
                .emailId(farmersDetailsDto.getEmailId()).firstName(farmersDetailsDto.getFirstName())
                .lastName(farmersDetailsDto.getLastName()).address(farmersDetailsDto.getAddress()).farmerPhoto(farmersDetailsDto.getFarmerPhoto())
                .milkType(String.valueOf(farmersDetailsDto.getMilkType().equalsIgnoreCase("cow") ? MilkType.COW : MilkType.BUFFELLOW))
                .mobileNumber(farmersDetailsDto.getMobileNumber()).status(PasswordEncrypter.STATUS_ACTIVE)
                .build();
        farmerRepository.save(farmer);
        return new ApiResponse("Farmer created Succesfully", true, farmer);
    }

    @Override
    public List<FarmersDetails> getAllFarmers() {

        return farmerRepository.findAll();
    }

    @Override
    public ApiResponse updateFarmer(String farmerId, FarmersDetailsDto farmersDetailsDto) {
        FarmersDetails existingFarmer = farmerRepository.findByFarmerUniqueId(farmerId);
        try{
            if(existingFarmer!=null) {
                existingFarmer.setAddress(farmersDetailsDto.getAddress() != null ? farmersDetailsDto.getAddress() : existingFarmer.getAddress());
                existingFarmer.setFarmerPhoto(farmersDetailsDto.getFarmerPhoto() != null ? farmersDetailsDto.getFarmerPhoto() : existingFarmer.getFarmerPhoto());
                existingFarmer.setEmailId(farmersDetailsDto != null ? farmersDetailsDto.getEmailId() : existingFarmer.getEmailId());
                existingFarmer.setFirstName(farmersDetailsDto.getFirstName() != null ? farmersDetailsDto.getFirstName() : existingFarmer.getFirstName());
                existingFarmer.setLastName(farmersDetailsDto.getLastName() != null ? farmersDetailsDto.getLastName() : existingFarmer.getLastName());
                existingFarmer.setMilkType(String.valueOf(farmersDetailsDto.getMilkType().equalsIgnoreCase("COW") ? MilkType.COW : MilkType.BUFFELLOW));
                existingFarmer.setMobileNumber(farmersDetailsDto.getMobileNumber() != null ? farmersDetailsDto.getMobileNumber() : existingFarmer.getMobileNumber());
                farmerRepository.save(existingFarmer);

                return new ApiResponse("existing user updated succesfully", true, existingFarmer);
            }
            return new ApiResponse("farmer not found",false,null);
        }catch (Exception e){
            return new ApiResponse("something went wrong,please try again later",false,null);

        }

    }

    @Override
    public String deleteFarmer(String uniqueid) {
        FarmersDetails farmer = farmerRepository.findByFarmerUniqueId(uniqueid);
        if (farmer != null) {
            farmerRepository.delete(farmer);
            return "farmer deleted  with this id" + uniqueid;
        }
        return "farmer did not found with this  " + uniqueid;
    }

    @Override
    public ApiResponse getFarmerById(String uniqueId) {
        System.out.println(uniqueId);
        FarmersDetails farmer = farmerRepository.findByFarmerUniqueId(uniqueId);
        try{
            if (farmer != null) {
                return new ApiResponse("Farmer fetched successfully", true, farmer);
            }
            return new ApiResponse("farmer not found", false, null);
        }catch (Exception e){
            return  new ApiResponse("something went wrong, please try again later",false,null);
        }

    }

    @Override
    public ApiResponse getFarmersListBySearchType(int type, String value) {
        List<String> farmerList = null;
        try{
            switch (type) {
                case 1:
                    farmerList = farmerRepository.getFarmerListByFarmerName(value);
                    FarmerServiceAsset.notNullorEmpty(farmerList,"farmer not found for this : "+value);
                    break;
                case 2:
                    farmerList = farmerRepository.getFarmerListByMobileNumber(value);
                    FarmerServiceAsset.notNullorEmpty(farmerList,"farmer not found for this : "+value);
                    break;
                default:
                    throw new RuntimeException("Type not found");
            }
                return new ApiResponse("Farmer list fetched succesfully",true,farmerList);

    }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Something went wrong,please try again later",false,null);
        }

    }

    @Override
    public ApiResponse getFarmerdetailsByMobileOrName(String mobileNumber, String name) {
        try {
            FarmersDetails farmer=farmerRepository.findByMobileNumberOrFirstName(mobileNumber,name);
            if(farmer!=null){
                return new ApiResponse("farmer fetched succesfully",true,farmer);
            }
            return new ApiResponse("Farmer details not found",false,null);

        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Something went wrong ,please try again later",false,null);

        }

    }


}
