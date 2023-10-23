package com.BuyMore.Utilities

class RatingValidation {

    static boolean validateRatingField(Double rating,String arcName)throws IllegalArgumentException, NullPointerException
    {
        if(!rating){ throw new NullPointerException("Error with argument price, cannot be null")}
        if(rating < (0.00) || rating > (5.00) ) {throw new IllegalArgumentException("Error with argument price, must be greater than 50 cents")}
        return true
    }
}
