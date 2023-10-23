package com.BuyMore.Utilities;

abstract class StringValidation {
    //TO DO
    // pass in class an an arg
    // does annotation make more sense
    static boolean validateStringField(String input, String argName) throws IllegalArgumentException, NullPointerException
    {
        if(!input){throw new NullPointerException("Error with argument name, cannot be null on class")}
        if(input.isEmpty() || input.isBlank()) {throw new IllegalArgumentException("Error name cannot be null")}
        return true
    }
}
