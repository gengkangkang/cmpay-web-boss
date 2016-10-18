package org.pay.service.jytpay.model;

import java.io.Serializable;

public class CpJYTRespDef implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2616732465858470687L;
	private String tran_flowid;   //交易流水号	
	private String tran_code;	    //交易代码		
	private String tran_date;	    //交易日期		
	private String tran_time;	    //交易时间		
	private String trans_id;      //核心流水号 	
	private String cust_id;       //客户代码    
	private String bank_name;	    //银行名称		
	private String account_no;	  //银行账号		
	private String account_name;	//银行账户名称
	private String account_type;	//账户类型		
	private String tran_amt;	    //交易金额		
	private String currency;	    //币种				
	private String bsn_code;	    //业务类型代码
	private String cert_type;	    //开户证件类型
	private String cert_no;	      //开户证件号 	
	private String tran_state;	    //交易状态
	private String resp_code;	    //响应代码
	private String create_date;   //创建时间 		
	private String description;   //描述 
	private String IsBcnAndIdnConform;   //身份验证结果 
	private String tran_resp_code;//交易响应密码
	
	public String getTran_flowid() {
		return tran_flowid;
	}
	public void setTran_flowid(String tran_flowid) {
		this.tran_flowid = tran_flowid;
	}
	public String getTran_code() {
		return tran_code;
	}
	public void setTran_code(String tran_code) {
		this.tran_code = tran_code;
	}
	public String getTran_date() {
		return tran_date;
	}
	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}
	public String getTran_time() {
		return tran_time;
	}
	public void setTran_time(String tran_time) {
		this.tran_time = tran_time;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getTran_amt() {
		return tran_amt;
	}
	public void setTran_amt(String tran_amt) {
		this.tran_amt = tran_amt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBsn_code() {
		return bsn_code;
	}
	public void setBsn_code(String bsn_code) {
		this.bsn_code = bsn_code;
	}
	public String getCert_type() {
		return cert_type;
	}
	public void setCert_type(String cert_type) {
		this.cert_type = cert_type;
	}
	public String getCert_no() {
		return cert_no;
	}
	public void setCert_no(String cert_no) {
		this.cert_no = cert_no;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTran_state() {
		return tran_state;
	}
	public void setTran_state(String tran_state) {
		this.tran_state = tran_state;
	}
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	public String getIsBcnAndIdnConform() {
		return IsBcnAndIdnConform;
	}
	public void setIsBcnAndIdnConform(String isBcnAndIdnConform) {
		IsBcnAndIdnConform = isBcnAndIdnConform;
	}
	public String getTran_resp_code() {
		return tran_resp_code;
	}
	public void setTran_resp_code(String tran_resp_code) {
		this.tran_resp_code = tran_resp_code;
	}
	
}
