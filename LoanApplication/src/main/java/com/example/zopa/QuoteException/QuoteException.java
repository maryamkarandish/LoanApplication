package com.example.zopa.QuoteException;

/**
 * Created by m.karandish on 6/8/2019.
 */
public class QuoteException extends Exception {
    /**
     * Related Exceptions to the LoanService
     * @param message
     */
    public QuoteException(String message){
        super(message);
    }
}
