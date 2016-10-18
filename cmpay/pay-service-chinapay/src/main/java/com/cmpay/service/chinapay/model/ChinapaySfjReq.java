package com.cmpay.service.chinapay.model;

import java.util.Map;

/**
 * 银联 收付捷 请求报文 接口
 * @author shenxw
 *
 */
public interface ChinapaySfjReq {
	String getString4Chk ();
	void setChkValue(String chkValue);
	Map<String,String> convertToMap();
}
