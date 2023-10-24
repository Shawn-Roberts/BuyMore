package com.BuyMore.Utilities

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


abstract class PriceValidation {

    private static final Logger log = LogManager.getLogger(PriceValidation.class)

    static boolean validatePriceField(BigDecimal price, String argName) throws IllegalArgumentException, NullPointerException
    {
            log.debug("Price Validation - validating price with argurments ${price} of ${price.getClass()} for arg: ${argName}")
            Objects.requireNonNull(price, "Error with argument ${argName}, provided null value")
            if(!price.isAtLeast(0.50) ) {throw new IllegalArgumentException("Error with argument price, must be greater than 50 cents")}
            log.debug("Price Validation - Sucessfully validated price with argurments ${price} of ${price.getClass()} for arg: ${argName}")
            return true
    }

    static boolean validatePrice(Double price,String argName)throws IllegalArgumentException, NullPointerException
    {
        log.debug("Price Validation - validating price with argurments ${price} of ${price.getClass()} for arg: ${argName}")
        Objects.requireNonNull(price, "Error with argument ${argName}, provided null value")
        if(price < (0.50) ) {throw new IllegalArgumentException("Error with argument price, must be greater than 50 cents")}
        log.debug("Price Validation - Sucessfully validated price with argurments ${price} of ${price.getClass()} for arg: ${argName}")
        return true
    }
}
