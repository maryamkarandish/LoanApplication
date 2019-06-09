package com.example.zopa.model;

import java.math.BigDecimal;

/**
 * Created by m.karandish on 6/8/2019.
 */
public class Lender {
    private String lenderName;
    private BigDecimal rate;
    private int availableAmount;


    /**
     *
     * @param lenderNameIn
     * @param rate
     * @param avaiableAmountIn
     */
    public Lender (final String lenderNameIn, final BigDecimal rate, final int avaiableAmountIn) {
        this.lenderName = lenderNameIn;
        this.rate = rate;
        this.availableAmount = avaiableAmountIn;
    }

    /**
     *
     * @return The Lender Name
     */
    public String getLenderName() {
        return lenderName;
    }

    /**
     *
     * @param lenderName
     */
    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }

    /**
     *
     * @return Rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     *
     * @param rate
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     *
     * @return Available Amount
     */
    public int getAvailableAmount() {
        return availableAmount;
    }

    /**
     *
     * @param availableAmount
     */
    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }
}
