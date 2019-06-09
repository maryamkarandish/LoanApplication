package com.example.zopa.service;

import com.example.zopa.model.Lender;
import com.example.zopa.model.Quote;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by m.karandish on 6/8/2019.
 */
public class LoanService {

    private final BigDecimal LOANLENGHT = new BigDecimal("36");
    private BigDecimal totalRepayment = BigDecimal.ZERO;
    private BigDecimal percentageRate = BigDecimal.ZERO;
    private BigDecimal monthlyRepayment = BigDecimal.ZERO;
    private int count = 0;

    /**
     * Calculate payments and rate and Populate the Quote Object
     * This method also sorted the Lender list in lower rate order then lower available balance
     * @param lendersList
     * @param result
     * @return
     */
    public Quote getRateAndRepayments(final List<Lender> lendersList, Quote result) {

        List<Lender> sortedList = lendersList.stream().sorted(Comparator.comparing(Lender::getRate).thenComparing(Lender::getAvailableAmount)).collect(Collectors.toList());

        result.setTotalPayment(round(calculateTotalRepayment(sortedList, result.getRequestAmount()), 2));

        DecimalFormat df = new DecimalFormat("#.0");
        String rateFormated = df.format(percentageRate.doubleValue() / count * 100);
        result.setPercentageRate(Double.valueOf(rateFormated));

        result.setMonthlyPayment(round(BigDecimal.valueOf(result.getTotalPayment()).divide(LOANLENGHT, MathContext.DECIMAL64), 2));

        return result;
    }

    /**
     * @param lendersList
     * @param loanAmount
     * @return
     */
    private BigDecimal calculateTotalRepayment(final List<Lender> lendersList, final int loanAmount) {

        int amountBorrowed = 0;
        int amountToBorrow = 0;

        for (Lender lender : lendersList) {

            if (amountBorrowed + lender.getAvailableAmount() > loanAmount) {
                amountToBorrow = loanAmount - amountBorrowed;
            } else {
                amountToBorrow = lender.getAvailableAmount();
            }

            BigDecimal mAmount = calculateMonthlyRepayment(amountToBorrow, lender.getRate(), LOANLENGHT.intValue(), 12);
            monthlyRepayment = monthlyRepayment.add(mAmount);
            totalRepayment = totalRepayment.add(repaymentTotalAmount(mAmount, LOANLENGHT.intValue()));
            percentageRate = percentageRate.add(lender.getRate());
            count++;

            amountBorrowed += amountToBorrow;

            if (amountBorrowed >= loanAmount) {
                break;
            }

        }

        return totalRepayment;
    }

    /**
     *
     * @param amount
     * @param rate
     * @param period
     * @param frequency
     * @return
     */
    private BigDecimal calculateMonthlyRepayment(int amount, BigDecimal rate, int period, int frequency) {

        double freqRate = Math.pow((1.0 + rate.doubleValue()), (1.0 / frequency)) - 1.0;
        double payment = (amount * freqRate) / (1 - Math.pow((1 + freqRate), -period));
        return BigDecimal.valueOf(payment).setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    public BigDecimal repaymentTotalAmount(BigDecimal repaymentMonthlyAmount, int period) {

        BigDecimal repaymentTotalAmount = repaymentMonthlyAmount.multiply(BigDecimal.valueOf(period));
        return repaymentTotalAmount.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    public double round(BigDecimal value, int places) {

        if (places < 0) throw new IllegalArgumentException();
        BigDecimal decimalValue = value;
        decimalValue = decimalValue.setScale(places, RoundingMode.HALF_UP);
        return decimalValue.doubleValue();
    }
}
