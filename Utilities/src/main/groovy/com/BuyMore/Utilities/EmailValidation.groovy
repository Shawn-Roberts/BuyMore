package com.BuyMore.Utilities

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

import java.util.regex.Pattern

abstract class EmailValidation {

    private static final String emailRegexPattern ="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})\$"
    private static final Logger log = LogManager.getLogger(EmailValidation.class)

    private static boolean patternMatches(String emailAddress)
    {
        return Pattern.compile(emailRegexPattern)
                .matcher(emailAddress)
                .matches();
    }
    static boolean validateEmailField(String email, String argName) throws IllegalArgumentException, NullPointerException
    {
        log.debug("Email Validation - validating email with argurments ${email} of ${email.getClass()} for arg: ${argName}")
        StringValidation.validateStringField(email,"email")
        if(!patternMatches(email)) {throw new IllegalArgumentException("Invalid email address")}
        log.debug("Email Validation - Sucessfully validated email with argurments ${email} of ${email.getClass()} for arg: ${argName}")
        return true
    }
}
