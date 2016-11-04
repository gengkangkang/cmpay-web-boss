package com.cmpay.service.chinapay.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpClient {
	private URL url;
	private int connectionTimeout;
	private int readTimeOut;
	private String result;

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public HttpClient(String url, int connectionTimeout, int readTimeOut) {
		try {
			this.url = new URL(url);
			this.connectionTimeout = connectionTimeout;
			this.readTimeOut = readTimeOut;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public int send(Map<String, String> data, String encoding) throws Exception {
		try {
			HttpURLConnection httpURLConnection = createConnection(encoding);
			if (null == httpURLConnection) {
				throw new Exception("创建联接失败");
			}
			requestServer(httpURLConnection, getRequestParamString(data, encoding), encoding);

			this.result = response(httpURLConnection, encoding);
//			LogUtil.writeLog("返回报文:[" + this.result + "]");
			return httpURLConnection.getResponseCode();
		} catch (Exception e) {
			throw e;
		}
	}

	private void requestServer(URLConnection connection, String message, String encoder) throws Exception {
		PrintStream out = null;
		try {
			connection.connect();
			out = new PrintStream(connection.getOutputStream(), false, encoder);
			out.print(message);
			out.flush();
			if (null != out) {
				out.close();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != out) {
				out.close();
			}
		}
	}

	private String response(HttpURLConnection connection, String encoding) throws URISyntaxException, IOException, Exception {
		InputStream in = null;
		StringBuilder sb = new StringBuilder(1024);
		BufferedReader br = null;
		try {
			if (200 == connection.getResponseCode()) {
				in = connection.getInputStream();
				sb.append(new String(read(in), encoding));
			} else {
				in = connection.getErrorStream();
				sb.append(new String(read(in), encoding));
			}
//			LogUtil.writeLog("HTTP Return Status-Code:[" + connection.getResponseCode() + "]");

			return sb.toString();
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != br) {
				br.close();
			}
			if (null != in) {
				in.close();
			}
			if (null != connection) {
				connection.disconnect();
			}
		}
	}

	public static byte[] read(InputStream in) throws IOException {
		byte[] buf = new byte[1024];
		int length = 0;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		while ((length = in.read(buf, 0, buf.length)) > 0) {
			bout.write(buf, 0, length);
		}
		bout.flush();
		return bout.toByteArray();
	}

	private HttpURLConnection createConnection(String encoding) throws ProtocolException {
		HttpURLConnection httpURLConnection = null;
		try {
			if ("https".equalsIgnoreCase(this.url.getProtocol())) {
				System.out.println("--------------https请求------------------");
	            // Create a trust manager that does not validate certificate chains
	            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
	                public X509Certificate[] getAcceptedIssuers(){return null;}
	                public void checkClientTrusted(X509Certificate[] certs, String authType){}
	                public void checkServerTrusted(X509Certificate[] certs, String authType){}
	            }};

	            // Install the all-trusting trust manager

	            SSLContext sc = SSLContext.getInstance("TLS");
	            sc.init(null, trustAllCerts, new SecureRandom());
	            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			}
			
			httpURLConnection = (HttpURLConnection) this.url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		httpURLConnection.setConnectTimeout(this.connectionTimeout);
		httpURLConnection.setReadTimeout(this.readTimeOut);
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=" + encoding);

		httpURLConnection.setRequestMethod("POST");
//		if ("https".equalsIgnoreCase(this.url.getProtocol())) {
//			HttpsURLConnection husn = (HttpsURLConnection) httpURLConnection;
//			husn.setSSLSocketFactory(new BaseHttpSSLSocketFactory());
//			husn.setHostnameVerifier(new BaseHttpSSLSocketFactory.TrustAnyHostnameVerifier());
//			return husn;
//		}
		return httpURLConnection;
	}

	private String getRequestParamString(Map<String, String> requestParam, String coder) {
		if ((null == coder) || ("".equals(coder))) {
			coder = "UTF-8";
		}
		StringBuffer sf = new StringBuffer("");
		String reqstr = "";
		if ((null != requestParam) && (0 != requestParam.size())) {
			for (Map.Entry<String, String> en : requestParam.entrySet()) {
				try {
					sf.append((String) en.getKey() + "=" + ((null == en.getValue()) || ("".equals(en.getValue())) ? "" : URLEncoder.encode((String) en.getValue(), coder)) + "&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return "";
				}
			}
			reqstr = sf.substring(0, sf.length() - 1);
		}
//		LogUtil.writeLog("请求报文:[" + reqstr + "]");
		return reqstr;
	}
}
