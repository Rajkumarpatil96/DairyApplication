package com.dairyapplication.dairyApplication.Exception;

public class FarmerServiceException extends  Exception {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new RA service exception.
     *
     * @param message
     *            the message
     */
    public FarmerServiceException(String message) {
        super(message);
    }
}
