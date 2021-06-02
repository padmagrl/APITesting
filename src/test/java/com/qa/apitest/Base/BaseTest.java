package com.qa.apitest.Base;

import java.util.Properties;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;

import com.qa.apitest.Client.RestClient;
import com.qa.apitest.Factory.InitProperties;

public class BaseTest {
	public InitProperties ip;
	public RestClient rc;

	public CloseableHttpResponse closeableHttpResponse;

	//public Properties prop;

	@BeforeMethod
	public void setUp() {
		ip = new InitProperties();
		 //prop=new Properties();
		rc = new RestClient();

	}

}
