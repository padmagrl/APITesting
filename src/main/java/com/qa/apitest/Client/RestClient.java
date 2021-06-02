package com.qa.apitest.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	// 1.with out headers
	public void get(String uri) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("statusCode-> " + statusCode);
		Header[] headersList = closeableHttpResponse.getAllHeaders();
		Map<String, String> headerMap = new HashMap<String, String>();
		for (Header h : headersList) {
			headerMap.put(h.getName(), h.getValue());
		}
		headerMap.put("Header", "Value");
		headerMap.forEach((k,v)->System.out.println(k+"->"+v));

	}
	public CloseableHttpResponse getWithOutHeaders(String uri) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
		return closeableHttpResponse;
		
	}

}
