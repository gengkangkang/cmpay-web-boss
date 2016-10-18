//package com.minshengwealth.jinyuntongpay.business.impl;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//
//import chinapay.Base64;
//import chinapay.SecureLink;
//
//import com.minshengwealth.chinapay.business.bean.CpSinPayQueryRespDef;
//import com.minshengwealth.chinapay.business.bean.CpSinPayReq;
//
//public class TestSinPay {
//	
//	/**
//	 * 金额以分为单位
//	 */
//	private static final DecimalFormat AMT_FORMAT = new DecimalFormat("000000000000");
//	
//	public static void main(String[] args) throws Exception {
//		//单笔代付若采用POST传输方式且HTTPCLIENT为4.X版本，中文传Unicode值         httpclient  4.25
//		//封装代付请求
////		CpSinPayReq req = new CpSinPayReq();
////		req.setMerId("808080211389035");
////		req.setMerDate("20151019");//标志该笔交易发生的日期,格式为YYYYMMDD，请填写当天的日期。
////		req.setMerSeqId("0000000000111113");//商户号+商户流水号+商户日期唯一标示一笔交易订单
////		req.setCardNo("6226620607792207");
//////		req.setUsrName("刘敏");
////		req.setUsrName(toUnicode("刘敏"));
//////		req.setOpenBank("光大银行");
////		req.setOpenBank(toUnicode("光大银行"));
//////		req.setProv("湖北");
////		req.setProv(toUnicode("湖北"));
//////		req.setCity("上海市");
////		req.setCity(toUnicode("上海市"));
////		String amt = "0.01";
////		BigDecimal transAmt = new BigDecimal(amt);
////		req.setTransAmt(AMT_FORMAT.format(transAmt.multiply(BigDecimal.valueOf(100))));
//////		req.setPurpose("测试代付");
////		req.setPurpose(toUnicode("测试代付"));
//////		req.setSubBank("光大银行宜昌支行");
////		req.setSubBank(toUnicode("光大银行宜昌支行"));
////		req.setFlag("00");
////		req.setVersion("20090501");
////		req.setSignFlag("1");
////		
////		//签名
////		String Data = req.getString4Chk();
////		System.out.println("字符串数据拼装结果：" + Data);
////		String plainData = new String(Base64.encode(Data.getBytes()));
////		System.out.println("转换成Base64后数据：" + plainData);
////		
////		String chkValue = null;
////		// 初始化key文件：
////		chinapay.PrivateKey key = new chinapay.PrivateKey();
////		boolean flag = false;
////		try {
////			flag = key.buildKey("808080211389035", 0, "G:/kelanwork5/1.0.0/upay/upay-service/src/main/resources/china-pay-key/MerPrK_808080211389035_20150228173140.key");
////		} catch (Exception e) {
////			e.printStackTrace();
////			System.out.println("build key 异常");
////		}
////		if(flag == false){
////			System.out.println("build key 失败");
////		}else{
////			System.out.println("build key 成功");
////		}
////		SecureLink sl = new SecureLink(key);
////		chkValue = sl.Sign(plainData);
////		System.out.println("签名内容:"+ chkValue);
////		req.setChkValue(chkValue);
////		System.out.println("请求报文:"+req.toString());
////		
////		//连接Chinapay控台
////		HttpClient httpClient = new HttpClient();
////		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
////		PostMethod postMethod = new PostMethod("http://sfj-test.chinapay.com/dac/SinPayServletGBK");
////		
////		//填入各个表单域的值
////		NameValuePair[] data = { 
////				new NameValuePair("merId", req.getMerId()),
////				new NameValuePair("merDate", req.getMerDate()),
////				new NameValuePair("merSeqId", req.getMerSeqId()),
////				new NameValuePair("cardNo", req.getCardNo()),
////				new NameValuePair("usrName", req.getUsrName()),
////				new NameValuePair("openBank", req.getOpenBank()),
////				new NameValuePair("prov", req.getProv()),
////				new NameValuePair("city", req.getCity()),
////				new NameValuePair("transAmt", req.getTransAmt()),
////				new NameValuePair("purpose", req.getPurpose()),
////				new NameValuePair("subBank", req.getSubBank()),
////				new NameValuePair("flag", req.getFlag()),
////		 		new NameValuePair("version", req.getVersion()),
////				new NameValuePair("chkValue",req.getChkValue()),
////				new NameValuePair("signFlag", req.getSignFlag())
////		};
////		
////		// 将表单的值放入postMethod中
////		postMethod.setRequestBody(data);
////		// 执行postMethod
////		try {
////			httpClient.executeMethod(postMethod);
////		} catch (HttpException e) {
////			e.printStackTrace();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		// 读取内容
////		InputStream resInputStream = null;
////		try {
////			resInputStream = postMethod.getResponseBodyAsStream();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		// 处理内容
////		BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
////		String tempBf = null;
////		StringBuffer html=new StringBuffer(); 
////		while((tempBf = reader.readLine()) != null){ 
////					
////			html.append(tempBf); 
////		}
////		String resMes = html.toString();
////		System.out.println("交易返回报文：" + resMes);
////		int dex = resMes.lastIndexOf("&");
////		
////		//拆分页面应答数据
////		String str[] = resMes.split("&");
////		System.out.println(str.length);	
////				
////		//提取返回数据
////		if(str.length == 10){
////			int Res_Code = str[0].indexOf("=");
////			int Res_merId = str[1].indexOf("=");
////			int Res_merDate = str[2].indexOf("=");
////			int Res_merSeqId = str[3].indexOf("=");
////			int Res_cpDate = str[4].indexOf("=");
////			int Res_cpSeqId = str[5].indexOf("=");
////			int Res_transAmt = str[6].indexOf("=");
////			int Res_stat = str[7].indexOf("=");
////			int Res_cardNo = str[8].indexOf("=");
////			int Res_chkValue = str[9].indexOf("=");
////						
////			String responseCode = str[0].substring(Res_Code+1);
////			String MerId = str[1].substring(Res_merId+1);
////			String MerDate = str[2].substring(Res_merDate+1);
////			String MerSeqId = str[3].substring(Res_merSeqId+1);
////			String CpDate = str[4].substring(Res_cpDate+1);
////			String CpSeqId = str[5].substring(Res_cpSeqId+1);
////			String TransAmt = str[6].substring(Res_transAmt+1);
////			String Stat = str[7].substring(Res_stat+1);
////			String CardNo = str[8].substring(Res_cardNo+1);
////			String ChkValue = str[9].substring(Res_chkValue+1);
////				
////				
////			System.out.println("responseCode=" + responseCode);
////			System.out.println("merId=" + MerId);
////			System.out.println("merDate=" + MerDate);
////			System.out.println("merSeqId=" + MerSeqId);
////			System.out.println("transAmt=" + TransAmt);
////			System.out.println("cpDate=" + CpDate);
////			System.out.println("cpSeqId=" + CpSeqId);
////			System.out.println("Stat=" + Stat);
////			System.out.println("cardNo=" + CardNo);
////			System.out.println("chkValue=" + ChkValue);
////		
////			String msg = resMes.substring(0,dex);
////			String plainData1 = new String(Base64.encode(msg.getBytes()));
////			System.out.println("需要验签的字段：" + msg);
////			
////			//对收到的ChinaPay应答传回的域段进行验签
////			boolean buildOK = false;
////			boolean res = false;
////			int KeyUsage = 0;
////			chinapay.PrivateKey key1 = new chinapay.PrivateKey();
////			try {
////				buildOK = key1.buildKey("999999999999999", KeyUsage, "G:/kelanwork5/1.0.0/upay/upay-service/src/main/resources/china-pay-key/PgPubk.key");
////			} catch (Exception e) {
////				System.out.println("build 异常");
////				e.printStackTrace();
////			}
////			if (!buildOK) {
////				System.out.println("build 失败");
////				return;
////			}else{
////				System.out.println("build 成功");
////			}
////			SecureLink sl1 = new SecureLink(key1);
////			res=sl1.verifyAuthToken(plainData1,ChkValue);
////			if (res){
////				System.out.println("验签数据正确!");
////			}else {
////				System.out.println("签名数据不匹配！");
////			}
////		}
////		
////		//交易失败应答
////		if(str.length == 2){
////			int Res_Code = str[0].indexOf("=");
////			int Res_chkValue = str[1].indexOf("=");
////			
////			String responseCode = str[0].substring(Res_Code+1);
////			String ChkValue = str[1].substring(Res_chkValue+1);
////			System.out.println("responseCode=" + responseCode);
////			System.out.println("chkValue=" + ChkValue);
////			
////			String plainData2 = str[0];
////			String plainData3 = new String(Base64.encode(plainData2.getBytes()));
////			System.out.println("需要验签的字段：" + plainData2);
////			
////			//对收到的ChinaPay应答传回的域段进行验签
////			boolean buildOK = false;
////			boolean res = false;
////			int KeyUsage = 0;
////			chinapay.PrivateKey key2 = new chinapay.PrivateKey();
////			try {
////				buildOK = key2.buildKey("999999999999999", KeyUsage, "G:/kelanwork5/1.0.0/upay/upay-service/src/main/resources/china-pay-key/PgPubk.key");
////			} catch (Exception e) {
////				System.out.println("build2 异常");
////				e.printStackTrace();
////			}
////			if (!buildOK) {
////				System.out.println("build2 失败");
////				return;
////			}else{
////				System.out.println("build2 成功");
////			}
////			SecureLink sl2 = new SecureLink(key2);
////			res=sl2.verifyAuthToken(plainData3,ChkValue);
////			if (res){
////				System.out.println("验签数据正确!");
////			}else {
////				System.out.println("签名数据不匹配！");
////			}
////		}
//		
//		// 查询订单数据准备
////		String merId = "808080211389035";
////		String merDate = "20151019";
////		String merSeqId = "0000000000111113";
////		String version = "20090501";
//		String merId = "808080211389035";
//		String merDate = "20151103";
//		String merSeqId = "0000000000007740";
//		String version = "20090501";
//		String Data = merId + merDate + merSeqId + version;
//		String plainData = new String(Base64.encode(Data.getBytes()));
//		System.out.println("转换成Base64后数据：" + plainData);
//		//签名
//		String chkValue = null;
//		int KeyUsage = 0;
//		chinapay.PrivateKey key = new chinapay.PrivateKey();
//		boolean flag = false;
//		try {
//			flag = key.buildKey("808080211389035", 0, "E:\\mywork\\kelanwork1\\1.0.0\\core\\core-cashier\\src\\main\\resources\\china-pay-key\\MerPrK_808080211389035_20150228173140.key");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("build key 异常");
//		}
//		if(flag == false){
//			System.out.println("build key 失败");
//		}else{
//			System.out.println("build key 成功");
//		}
//		SecureLink sl = new SecureLink(key);
//		chkValue = sl.Sign(plainData);
//		System.out.println("签名内容:"+ chkValue);
//		HttpClient httpClient = new HttpClient();
//		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
//		PostMethod postMethod = new PostMethod("http://sfj-test.chinapay.com/dac/SinPayQueryServletGBK");
//		//填入各个表单域的值
//		NameValuePair[] data = { 
//				new NameValuePair("merId", merId),
//				new NameValuePair("merDate", merDate),
//				new NameValuePair("merSeqId", merSeqId),
//		 		new NameValuePair("version", version),
//				new NameValuePair("chkValue",chkValue),
//				new NameValuePair("signFlag", "1")
//		};
//		
//		// 将表单的值放入postMethod中
//		postMethod.setRequestBody(data);
//		// 执行postMethod
//		try {
//			httpClient.executeMethod(postMethod);
//		} catch (HttpException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 读取内容
//		InputStream resInputStream = null;
//		try {
//			resInputStream = postMethod.getResponseBodyAsStream();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 处理内容
//		BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
//		String tempBf = null;
//		StringBuffer html=new StringBuffer(); 
//		while((tempBf = reader.readLine()) != null){ 
//					
//			html.append(tempBf); 
//		}
//		String resMes = html.toString();
//		System.out.println("单笔查询返回报文：" + resMes);
//		//验签
//		CpSinPayQueryRespDef cpSinPayQueryRespDef = new CpSinPayQueryRespDef();
//		int dex = resMes.lastIndexOf("|");
//		String Res_Code = resMes.substring(0,3);
//		cpSinPayQueryRespDef.setCode(Res_Code);
//		//提取返回数据
//		if(Res_Code.equals("000")){
//			String Res_stat = resMes.substring(dex-2,dex-1);
//			String Res_chkValue = resMes.substring(dex+1);
//			cpSinPayQueryRespDef.setStat(Res_stat);
//			cpSinPayQueryRespDef.setChkValue(Res_chkValue);
//			String plainData1 = resMes.substring(0,dex+1);
//			String Data1 = new String(Base64.encode(plainData1.getBytes()));
//			//对收到的ChinaPay应答传回的域段进行验签
//			boolean buildOK = false;
//			boolean res = false;
//			int KeyUsage1 = 0;
//			chinapay.PrivateKey key1 = new chinapay.PrivateKey();
//			try {
//				buildOK = key1.buildKey("999999999999999", KeyUsage1, "E:\\mywork\\kelanwork1\\1.0.0\\core\\core-cashier\\src\\main\\resources\\china-pay-key\\PgPubk.key");
//			} catch (Exception e) {
//				System.out.println("build key error,{}"+ e);
//			}
//			if (!buildOK) {
//				System.out.println("build key error!");
//			}else{
//				System.out.println("build key success!");
//			}
//			SecureLink sl1 = new SecureLink(key1);
//			res=sl1.verifyAuthToken(Data1,Res_chkValue);
//			if (res){
//				System.out.println("验签数据正确!");
//			}else {
//				System.out.println("签名数据不匹配,签名数据:{}"+Data1);
//				System.out.println(cpSinPayQueryRespDef.toString());
//			}
//		}
//	}
//	
//	/**
//	 * 将字符串转换为Unicode码
//	 * 
//	 * @param zhStr
//	 * @return
//	 */
//	public static String toUnicode(String zhStr) {
//		StringBuffer unicode = new StringBuffer();
//		for (int i = 0; i < zhStr.length(); i++) {
//			char c = zhStr.charAt(i);
//			unicode.append("\\u" + Integer.toHexString(c));
//		}
//		return unicode.toString();
//	}
//	
//
//}
