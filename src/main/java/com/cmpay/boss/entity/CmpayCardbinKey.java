package com.cmpay.boss.entity;

import java.math.BigDecimal;

public class CmpayCardbinKey {
    private String cardBin;

    private BigDecimal cardLength;

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin == null ? null : cardBin.trim();
    }

    public BigDecimal getCardLength() {
        return cardLength;
    }

    public void setCardLength(BigDecimal cardLength) {
        this.cardLength = cardLength;
    }
}