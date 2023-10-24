package com.BuyMore.Utilities

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

abstract class RatingValidation {

    private static final Logger log = LogManager.getLogger(RatingValidation.class)
    static boolean validateRatingField(Double rating,String argName)throws IllegalArgumentException, NullPointerException
    {
        log.debug("Rating Validation - validating rating with argurments ${rating} of ${rating.getClass()} for arg: ${argName}")
        Objects.requireNonNull(rating, "Error with argument ${argName}, provided null value")
        if(rating < (0.00) || rating > (5.00) ) {throw new IllegalArgumentException("Error with argument rating, must be between 0 and 5")}
        log.debug("Rating Validation - Sucessfully validated rating with argurments ${rating} of ${rating.getClass()} for arg: ${argName}")
        return true
    }
}
