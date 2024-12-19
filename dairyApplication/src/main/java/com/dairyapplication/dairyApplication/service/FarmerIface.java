package com.dairyapplication.dairyApplication.service;

import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.dto.FarmersDetailsDto;
import com.dairyapplication.dairyApplication.entity.FarmersDetails;

import java.util.List;

public interface FarmerIface {
ApiResponse createFarmer(FarmersDetailsDto farmersDetailsDto);
List<FarmersDetails> getAllFarmers();
ApiResponse updateFarmer(String farmerUniqueId, FarmersDetailsDto updatedFarmer);

    String deleteFarmer(String uniqueid);
    ApiResponse getFarmerById(String uniqueId);
    ApiResponse getFarmersListBySearchType(int type,String value);
    ApiResponse getFarmerdetailsByMobileOrName(String mobileNumber,String name);
}
