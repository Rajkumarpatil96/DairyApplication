package com.dairyapplication.dairyApplication.service;

import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.dto.CollectionsDto;
import com.dairyapplication.dairyApplication.entity.Collections;


import java.util.List;

public interface CollectionIface {
    ApiResponse createCollection(CollectionsDto collectionsDto);
    ApiResponse getAllCollectionByFarmerUniqueId(String uniqueId);
    ApiResponse updateCollection(Long collectionId,CollectionsDto collectionsDto);
    ApiResponse deleteCollection(Long collectionId);
    ApiResponse getCollectionDateWise(String startDate,String endDate);
    //ApiResponse getCollectionFarmerWise();

}
