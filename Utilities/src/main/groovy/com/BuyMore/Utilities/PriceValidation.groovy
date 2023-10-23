package com.BuyMore.Utilities

class PriceValidation {
    //TO DO
    // pass in class an an arg
    // does annotation make more sense
    static boolean validatePriceField(BigDecimal price, String argName) throws IllegalArgumentException, NullPointerException
    {
        if(!price){ throw new NullPointerException("Error with argument price, cannot be null")}
        if(!price.isAtLeast(0.50) ) {throw new IllegalArgumentException("Error with argument price, must be greater than 50 cents")}
        return true
    }

    static boolean validatePrice(Double price,String arcName)throws IllegalArgumentException, NullPointerException
    {
        if(!price){ throw new NullPointerException("Error with argument price, cannot be null")}
        if(price < (0.50) ) {throw new IllegalArgumentException("Error with argument price, must be greater than 50 cents")}
        return true
    }
}
