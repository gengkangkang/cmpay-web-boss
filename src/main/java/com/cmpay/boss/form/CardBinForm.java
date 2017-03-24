package com.cmpay.boss.form;

import java.math.BigDecimal;
import java.util.Date;

public class CardBinForm extends BaseForm {
	private String cardBin;

    private BigDecimal cardLength;
    
	private String cardType;

    private String bankName;

    private String issuerId;

    private String cardStat;

	private String cardName;

    private String accountno;

    private String remark;

    private BigDecimal jpaVersion;

    private String cmpayCode;

    private String cmpayName;

    private String field;

    private String field1;

    private String field2;

    private String modifier;

    private Date modifyTime;
    
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId == null ? null : issuerId.trim();
    }

    public String getCardStat() {
        return cardStat;
    }

    public void setCardStat(String cardStat) {
        this.cardStat = cardStat == null ? null : cardStat.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno == null ? null : accountno.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getJpaVersion() {
        return jpaVersion;
    }

    public void setJpaVersion(BigDecimal jpaVersion) {
        this.jpaVersion = jpaVersion;
    }

    public String getCmpayCode() {
        return cmpayCode;
    }

    public void setCmpayCode(String cmpayCode) {
        this.cmpayCode = cmpayCode == null ? null : cmpayCode.trim();
    }

    public String getCmpayName() {
        return cmpayName;
    }

    public void setCmpayName(String cmpayName) {
        this.cmpayName = cmpayName == null ? null : cmpayName.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    

    @Override
	public String toString() {
		return "CardBinForm [cardBin=" + cardBin + ", cardLength=" + cardLength + ", cardType=" + cardType
				+ ", bankName=" + bankName + ", issuerId=" + issuerId + ", cardStat=" + cardStat + ", cardName="
				+ cardName + ", accountno=" + accountno + ", remark=" + remark + ", jpaVersion=" + jpaVersion
				+ ", cmpayCode=" + cmpayCode + ", cmpayName=" + cmpayName + ", field=" + field + ", field1=" + field1
				+ ", field2=" + field2 + ", modifier=" + modifier + ", modifyTime=" + modifyTime + "]";
	}

}
