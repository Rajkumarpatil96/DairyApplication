package com.dairyapplication.dairyApplication.Exception;


public class FarmerServiceAsset {

    public static void notNullorEmpty(Object orgumentName, String message) throws FarmerServiceException {
        if (orgumentName == null) {
            throw new FarmerServiceException(message);
        }
    }

}
