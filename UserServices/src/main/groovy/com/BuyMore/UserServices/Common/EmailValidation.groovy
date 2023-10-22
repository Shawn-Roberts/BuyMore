package com.BuyMore.UserServices.Common

import java.util.regex.Pattern;

abstract class EmailValidation {

    private static final String emailRegexPattern ="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})\$"
    private static boolean patternMatches(String emailAddress)
    {
        return Pattern.compile(emailRegexPattern)
                .matcher(emailAddress)
                .matches();
    }
    static boolean validateEmail(String email) throws IllegalArgumentException, NullPointerException
    {
        if(!email){throw new NullPointerException("Error with argument name, cannot be null")}
        if(email.isEmpty() || email.isBlank()) {throw new IllegalArgumentException("Error name cannot be null")}
        if(!patternMatches(email)) {throw new IllegalArgumentException("Invalid email address")}
        return true
    }
}
