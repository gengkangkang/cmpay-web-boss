package com.cmpay.service.llpay.model;

/**
 * 通知响应信息
 * 
 * @author guoyx
 * 
 */
public class RetBean{

    private String ret_code;

    private String ret_msg;
    
    private String uOrderNo;//联合代付代扣订单号
    
    private String channel;
    
    private String amt;
    
    private String resultPay;

    public String getRet_code()
    {
        return ret_code;
    }

    public void setRet_code(String ret_code)
    {
        this.ret_code = ret_code;
    }

    public String getRet_msg()
    {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg)
    {
        this.ret_msg = ret_msg;
    }

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getResultPay() {
		return resultPay;
	}

	public void setResultPay(String resultPay) {
		this.resultPay = resultPay;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getuOrderNo() {
		return uOrderNo;
	}

	public void setuOrderNo(String uOrderNo) {
		this.uOrderNo = uOrderNo;
	}

    
    

}
