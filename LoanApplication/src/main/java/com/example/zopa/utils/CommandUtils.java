package com.example.zopa.utils;

import com.example.zopa.QuoteException.QuoteException;
import com.example.zopa.QuoteException.QuoteExceptionMessages;
import com.example.zopa.model.Quote;

/**
 * Created by m.karandish on 6/8/2019.
 */
public class CommandUtils {

    /**
     * Calculates and prints The Final results
     *
     * @param quote input data
     */
    public static void printExitStatus(final Quote quote) {

        System.out.println("The Requested Amount is: " + quote.getRequestAmount());
        System.out.println("Rate: " + String.format("%.1f", quote.getPercentageRate()) + "%");
        System.out.println("Monthly repayment: £" + String.format("%.2f", quote.getMonthlyPayment()));
        System.out.println("Total repayment: £" + String.format("%.2f", quote.getTotalPayment()));
    }

    public static int getLoanAmountInput(String loanAmount) throws QuoteException {

        int convertedLoanAmount = Integer.parseInt(loanAmount);

        if (convertedLoanAmount % 100 != 0) {
            throw new QuoteException(QuoteExceptionMessages.INCORRECT_AMOUNT_RATIO);
        } else if (convertedLoanAmount < 1000 || convertedLoanAmount > 15000) {
            throw new QuoteException(QuoteExceptionMessages.INCORRECT_AMOUNT_VALUE_RANGE);
        } else {
            return convertedLoanAmount;
        }
    }
}
