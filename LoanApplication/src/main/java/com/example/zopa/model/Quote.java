package com.example.zopa.model;

/**
 * Created by m.karandish on 6/8/2019.
 */
public class Quote {

    private int requestAmount;
    private double percentageRate;
    private double monthlyPayment;
    private double totalPayment;

    /**
     *
     * @return request Amount
     */
    public int getRequestAmount() {
        return requestAmount;
    }

    /**
     *
     * @param requestAmount
     */
    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }

    /**
     *
     * @return percentage Rate
     */
    public double getPercentageRate() {
        return percentageRate;
    }

    /**
     *
     * @param percentageRate
     */
    public void setPercentageRate(double percentageRate) {
        this.percentageRate=percentageRate;
    }

    /**
     *
     * @return monthly Repayment
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     *
     * @param monthlyPayment
     */
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    /**
     *
     * @return Total Repayment
     */
    public double getTotalPayment() {
        return totalPayment;
    }

    /**
     *
     * @param totalPayment
     */
    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
