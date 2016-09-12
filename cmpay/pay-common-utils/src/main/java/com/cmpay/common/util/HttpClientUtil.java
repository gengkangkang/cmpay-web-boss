package com.cmpay.common.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
/**
 * http请求工具类
 * 
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年8月11日 下午3:03:08
 *
 */
public class HttpClientUtil {
	private static Logger logger=Logger.getLogger(HttpClientUtil.class.getName());
	
	
	public static String post(String url,Map<String,String> para,String inEncode,String outEncode) throws Exception{
				
		CloseableHttpClient httpclient = null;			
		HttpEntity httpEntity = null;
		String returnValue=null;
		try{
			
			 RequestConfig config = RequestConfig.custom().setConnectTimeout(90000).setSocketTimeout(90000).build();
			 httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		if(para !=null && !para.isEmpty()){
			for(String key:para.keySet()){
				params.add(new BasicNameValuePair(key,para.get(key)));
			}
		}
		
		    UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,inEncode);
			HttpPost httppost=new HttpPost(url);
			httppost.setEntity(entity);
			httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");

			System.out.println("执行的post："+httppost.getURI()+"post参数为："+params);
			CloseableHttpResponse response=httpclient.execute(httppost);
		    httpEntity=response.getEntity();
		    if(httpEntity !=null){
		    	  returnValue=EntityUtils.toString(httpEntity,outEncode);
		    }
		  EntityUtils.consume(httpEntity);
		  response.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			httpclient.close();
		}
		System.out.println("post返回值为："+returnValue);							
       return returnValue;				
	}
	
	

	public static String postString(String url,String data,String inEncode,String outEncode) throws Exception{
				
		CloseableHttpClient httpclient = null;			
		HttpEntity httpEntity = null;
		String returnValue=null;
		try{
			 RequestConfig config = RequestConfig.custom().setConnectTimeout(90000).setSocketTimeout(90000).build();
			 httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

	    	StringEntity strEntity = new StringEntity(data, inEncode);
			HttpPost httppost=new HttpPost(url);
			httppost.setEntity(strEntity);
			httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");

			
			logger.info("执行post地址："+httppost.getURI()+" post参数："+data.toString());
			CloseableHttpResponse response=httpclient.execute(httppost);
			System.out.println("返回code=="+response.getStatusLine().getStatusCode());
		    httpEntity=response.getEntity();
		    if(httpEntity !=null){
		    	  returnValue=EntityUtils.toString(httpEntity,outEncode);
		    }
		  EntityUtils.consume(httpEntity);
		  response.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
			httpclient.close();
		}
		logger.info("post返回值："+returnValue);							
       return returnValue;				
	}
	
	
	public static String postFlow(String url,String data,String inEncode,String outEncode) throws Exception{
		
		CloseableHttpClient httpclient = null;			
		HttpEntity httpEntity = null;
		String returnValue=null;
		try{
			 RequestConfig config = RequestConfig.custom().setConnectTimeout(90000).setSocketTimeout(90000).build();
			 httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

	    	StringEntity strEntity = new StringEntity(data, inEncode);
			HttpPost httppost=new HttpPost(url);
			httppost.setEntity(strEntity);
			httppost.setHeader("Content-Type", "application/json");
			httppost.setHeader("Authorization", "Basic MDAwMDppdG91MTIzNDU2");
			
			logger.info("执行post地址："+httppost.getURI()+" post参数："+data.toString());
			CloseableHttpResponse response=httpclient.execute(httppost);
			System.out.println("返回code=="+response.getStatusLine().getStatusCode());
		    httpEntity=response.getEntity();
		    if(httpEntity !=null){
		    	  returnValue=EntityUtils.toString(httpEntity,outEncode);
		    }
		  EntityUtils.consume(httpEntity);
		  response.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
			httpclient.close();
		}
		logger.info("-------------获取流量返回值："+returnValue);							
       return returnValue;				
	}
	
		

	public static String get(String url,Map<String,String> para,String inEncode,String outEncode) throws Exception{
				
		CloseableHttpClient httpclient = null;			
		HttpEntity httpEntity = null;
		String returnValue=null;
		try{		
			
			 RequestConfig config = RequestConfig.custom().setConnectTimeout(90000).setSocketTimeout(90000).build();
			 httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		if(para !=null && !para.isEmpty()){
			for(String key:para.keySet()){
				params.add(new BasicNameValuePair(key,para.get(key)));
			}
		}
		
		    url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(params, inEncode));
		    HttpGet httpget=new HttpGet(url);
		     RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(90000).setConnectTimeout(90000).build();		     
		     httpget.setConfig(requestConfig); 
			
			System.out.println("执行的get语句为："+url);
			CloseableHttpResponse response=httpclient.execute(httpget);
		    httpEntity=response.getEntity();
		    if(httpEntity !=null){
		    	  returnValue=EntityUtils.toString(httpEntity,outEncode);
		    }
		  EntityUtils.consume(httpEntity);
		  response.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			httpclient.close();
		}
		System.out.println("get返回值为："+returnValue);							
       return returnValue;				
	}
	
	
	public static String getUrl(String url,String inEncode,String outEncode) throws Exception{
				
		CloseableHttpClient httpclient = null;			
		HttpEntity httpEntity = null;
		String returnValue=null;
		try{		
			 RequestConfig config = RequestConfig.custom().setConnectTimeout(90000).setSocketTimeout(90000).build();
			 httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
				  
		    HttpGet httpget=new HttpGet(url);
		    
			//connection.setRequestProperty("Content-type", "application/json");
			//connection.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=");		    
//		    httpget.setHeader("Content-Type", "application/json");
		    httpget.setHeader("Authorization", "Basic YWRtaW46YWRtaW4=");
//		    httpget.setHeader("Content-Type", "text/html; charset=utf-8");
	
			logger.info("执行的get地址为： "+url);
			CloseableHttpResponse response=httpclient.execute(httpget);
		    httpEntity=response.getEntity();
		    if(httpEntity !=null){
		    	  returnValue=EntityUtils.toString(httpEntity,outEncode);
		    }
		  EntityUtils.consume(httpEntity);
		  response.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			httpclient.close();
		}
		logger.info("get返回值："+returnValue);							
       return returnValue;				
	}
	
	
	public static String postSSL(String url,String data,String inEncode,String outEncode) throws Exception{
		//创建默认的httpclient实例
				
		CloseableHttpClient httpclient = null;			
		HttpEntity httpEntity = null;
		String returnValue=null;
		
//	       KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
//	        FileInputStream instream = new FileInputStream(new File("D:/ORA/ora/cert/gzyl.cer"));
//	        try {
//	            trustStore.load(instream, "nopassword".toCharArray());
//	        } finally {
//	            instream.close();
//	        }
	        
//	        SSLContext sslcontext=SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
	    	SSLContext sslcontext=SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
	     
	        SSLConnectionSocketFactory sslsf=new SSLConnectionSocketFactory(sslcontext,new String[]{"SSLv3"},
	        		null,
	        		SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	        httpclient=HttpClients.custom().setSSLSocketFactory(sslsf).build();
	        	        
		try{			
	    	StringEntity strEntity = new StringEntity(data, inEncode);
			HttpPost httppost=new HttpPost(url);
			httppost.setEntity(strEntity);
			httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");

			//设置请求和传输超时时间  
		     RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
		     httppost.setConfig(requestConfig); 
			
			System.out.println("执行post请求为:"+httppost.getURI());
			CloseableHttpResponse response=httpclient.execute(httppost);
			System.out.println("返回code=="+response.getStatusLine().getStatusCode());
		    httpEntity=response.getEntity();
		    if(httpEntity !=null){
		    	  returnValue=EntityUtils.toString(httpEntity,outEncode);
		    }
		  EntityUtils.consume(httpEntity);
		  response.close();
//			System.out.println("返回内容==="+EntityUtils.toString(httpEntity,"UTF-8"));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
			httpclient.close();
		}
		System.out.println("post请求返回值："+returnValue);							
       return returnValue;				
	}

}
