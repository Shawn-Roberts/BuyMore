package com.BuyMore.Utilities

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

abstract class StringValidation {
    //TO DO
    // pass in class an an arg
    // does annotation make more sense

    private static final Logger log = LogManager.getLogger(StringValidation.class)
    static boolean validateStringField(String input, String argName) throws IllegalArgumentException, NullPointerException
    {
        log.debug("String Validation - validating string with argurments ${input} of ${input.getClass()} for arg: ${argName}")
        Objects.requireNonNull(input, "Error with argument ${argName}, provided null value")
        if(input.isEmpty() || input.isBlank()) {throw new IllegalArgumentException("Error name cannot be null")}
        log.debug("String Validation - Sucessfully validated string with argurments ${input} of ${input.getClass()} for arg: ${argName}")
        return true
    }
}
