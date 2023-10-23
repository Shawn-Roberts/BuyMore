package com.BuyMore.ProductServices.Response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

abstract class ProductResponseHandler {
    static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,status);
    }
}
