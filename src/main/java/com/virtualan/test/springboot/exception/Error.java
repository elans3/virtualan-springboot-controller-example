package com.virtualan.test.springboot.exception;


/**
 * Spring boot rest controller with virtualan
 * 
 * @author Elan Thangamani
 *
 */
public class Error {

    private String errorMessage;

    public Error(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
