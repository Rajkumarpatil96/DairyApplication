package com.dairyapplication.dairyApplication.service.impl;

import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.apputil.SessionUtil;
import com.dairyapplication.dairyApplication.dto.CollectionsDto;
import com.dairyapplication.dairyApplication.entity.Collections;
import com.dairyapplication.dairyApplication.entity.FarmersDetails;
import com.dairyapplication.dairyApplication.entity.RateChart;
import com.dairyapplication.dairyApplication.repository.CollectionsRepository;
import com.dairyapplication.dairyApplication.repository.FarmerRepository;
import com.dairyapplication.dairyApplication.repository.RateChartRepository;
import com.dairyapplication.dairyApplication.service.CollectionIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionIfaceImpl implements CollectionIface {
    @Autowired
    CollectionsRepository collectionsRepository;
    @Autowired
    private RateChartRepository rateChartRepository;
    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public ApiResponse createCollection(CollectionsDto collectionsDto) {
        try{
            if(collectionsDto != null) {
                FarmersDetails farmer = farmerRepository.findByFarmerUniqueId(collectionsDto.getFarmerUniqueId());
                if(farmer != null){
                    Collections collections = Collections.builder().animalType(collectionsDto.getAnimalType().toUpperCase()).fatPercentage(collectionsDto.getFatPercentage())
                            .quantityLiters(collectionsDto.getQuantityLiters()).details(farmer).snfPercentage(collectionsDto.getSnfPercentage()).build();
                    Double pricePerLiter = calculatePricePerLiterBasedOnCurrentSession(collectionsDto.getAnimalType().toUpperCase(), collectionsDto.getFatPercentage(), collectionsDto.getSnfPercentage());
                    collections.setSession(SessionUtil.getCurrentSession());
                    collections.setPricePerLiter(pricePerLiter);
                    collections.setTotalPrice(pricePerLiter * collectionsDto.getQuantityLiters());
                    collectionsRepository.save(collections);
                    return new ApiResponse("collection is added to the table", true, collections);
                }else{
                    return new ApiResponse("Farmer not found", false, null);
                }
            }
            else{
                return new ApiResponse("Collection not found", false, null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Something went wrong,please try after some time", false, null);
        }



    }



    @Override
    public ApiResponse getAllCollectionByFarmerUniqueId(String  uniqueId) {
        //FarmersDetails details = farmerRepository.findByFarmerUniqueId(uniqueId);
       List<Collections> collection=collectionsRepository.findByFarmerUniqueId(uniqueId);
       try{
           if (collection != null) {
               return new ApiResponse("all collections are fetched", true, collection);
           }
           return new ApiResponse("collection not found",false,null);
       }catch (Exception e){
           return new ApiResponse("something went wrong,please ty again later",false,null);
       }


    }

    @Override
    public ApiResponse updateCollection(Long collectionId, CollectionsDto collectionsDto) {
//        Double value=collectionsDto.getFatPercentage();
//     Collections collection=collectionsRepository.findByCollectionId(collectionId);
//     collection.setAnimalType(collectionsDto.getAnimalType()!=null?collectionsDto.getAnimalType():collection.getAnimalType());
//     collection.setFatPercentage(value!=null?collectionsDto.getFatPercentage():collection.getFatPercentage());
//     collection.


        return null;
    }

    @Override
    public ApiResponse deleteCollection(Long collectionId) {
        Collections collection = collectionsRepository.findById(collectionId).get();

            if (collection != null) {
                collectionsRepository.delete(collection);
                return new ApiResponse("Collection is deleted of this id" + collectionId, true, collection);
            }
            return new ApiResponse("collection is not found ",false,null);
        }

    @Override
    public ApiResponse getCollectionDateWise(String startDate, String endDate) {
        List<Collections>collections = collectionsRepository.findCollectionsBetweenDates(startDate,endDate);
        try{
            if(collections!=null){
                return  new ApiResponse("List of collection from "+startDate+" to the "+endDate,true,collections);
            }
            return new ApiResponse("collection not found from this "+startDate+" to"+endDate,false,null);
        }catch (Exception e){
            return new ApiResponse("something went wrong,please try again later",false,null);
        }

    }


    public double calculatePricePerLiterBasedOnCurrentSession(String animalType, double fatPercentage,double snfPercentage) {
        // Automatically determine the session
        String session = SessionUtil.getCurrentSession();

        // Use the determined session to calculate the price
        return calculatePricePerLiter(animalType, session, fatPercentage,snfPercentage);
    }

    public double calculatePricePerLiter(String animalType, String session, double fatPercentage, double snfPercentage) {
        Optional<RateChart> optionalRateChart = rateChartRepository.findActiveRateChart(animalType, session);

        if (optionalRateChart.isEmpty()) {
            throw new IllegalArgumentException("No rate chart found for the specified criteria.");
        }

        RateChart rateChart = optionalRateChart.get();

        if (fatPercentage < rateChart.getMinFatPercentage() || fatPercentage > rateChart.getMaxFatPercentage()) {
            throw new IllegalArgumentException("Fat percentage is out of range for the selected rate chart.");
        }
        //MilkRate=BaseRate+(FatDifference×RateperUnitFat)+(SNFDifference×RateperUnitSNF)
        Double fatDiff=fatPercentage-rateChart.getBaseFatPercentage();
        Double snfDiff=snfPercentage-rateChart.getBaseSNFPercentage();
        Double rate=rateChart.getPricePerLiter()+(fatDiff*(rateChart.getPricePerLiter()/rateChart.getBaseFatPercentage()))+(snfDiff*(rateChart.getPricePerLiter()/rateChart.getBaseSNFPercentage()));
        return Math.round(rate);
    }
}


