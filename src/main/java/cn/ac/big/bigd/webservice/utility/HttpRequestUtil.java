package cn.ac.big.bigd.webservice.utility;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

/*******************************************************************
 * this class used to generate a http request 
 * 
 * @author sweeter
 *
 */
public class HttpRequestUtil {
	  public static final String CHARSET_UTF_8 = "utf-8";
	
	public static void doHttpPost(String url,List nvps) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try{
			
			HttpPost httpPost = new HttpPost(url);
		    httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
            response2.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			httpclient.close();
		}
		
	}
	
	/*************************************
	 * post a requence and get json response
	 * @param url
	 * @param nvps
	 * @throws Exception
	 */
	public static String doHttpPostResponseJson(String url,List nvps) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		try{
			
			HttpPost httpPost = new HttpPost(url);
			if(nvps != null ){
				httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			}else{
				StringEntity se = new StringEntity("", CHARSET_UTF_8);
		       // se.setContentType("application/json; charset=UTF-8");
		        httpPost.setEntity(se);
			}
		    
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
            System.out.println(response2.getStatusLine().getStatusCode());
            if (response2.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response2.getEntity(), CHARSET_UTF_8);
            }else{
            	String tmpstr = EntityUtils.toString(response2.getEntity(), CHARSET_UTF_8);
            	System.out.println(tmpstr);
            }
            
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			httpclient.close();
		}
		
		return resultString;
		
	}
	
	
	
	/*************************************
	 * use get method  and get json response
	 * @param url
	 * @param nvps
	 * @throws Exception
	 */
	public static String doHttpGetResponseJson(String url,List nvps) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		try{
			 HttpGet httpGet = new HttpGet(url);
			
			if(nvps != null ){
				url +="?"+ EntityUtils.toString(new UrlEncodedFormEntity(nvps), CHARSET_UTF_8);
			}
		    
            CloseableHttpResponse response2 = httpclient.execute(httpGet);
      //      System.out.println(response2.getStatusLine().getStatusCode());
            if (response2.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response2.getEntity(), CHARSET_UTF_8);
            }
            
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			httpclient.close();
		}
		
		return resultString;
		
	}

	public static String doHttpPostResponseJsonForDac(String url,String body) throws Exception{
		String resultString = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.setEntity(new StringEntity(body));
		CloseableHttpResponse response = httpClient.execute(httpPost);
		if (response.getStatusLine().getStatusCode() == 200) {
			resultString = EntityUtils.toString(response.getEntity(), CHARSET_UTF_8);
		}else{
			String tmpstr = EntityUtils.toString(response.getEntity(), CHARSET_UTF_8);
			System.out.println(tmpstr);
		}
		return resultString;

	}
	
}
