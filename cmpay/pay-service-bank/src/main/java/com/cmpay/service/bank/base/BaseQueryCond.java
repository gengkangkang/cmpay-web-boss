package com.cmpay.service.bank.base;

public class BaseQueryCond {

	private Boolean countTotal = true;

	private Boolean isFuzzy = true;

	private Integer startRow=1;
	
	private Integer endRow=20;
	
	public Boolean getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(Boolean countTotal) {
		this.countTotal = countTotal;
	}

	public Boolean getIsFuzzy() {
		return isFuzzy;
	}

	public void setIsFuzzy(Boolean isFuzzy) {
		this.isFuzzy = isFuzzy;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	
}
