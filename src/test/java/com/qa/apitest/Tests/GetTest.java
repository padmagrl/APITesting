package com.qa.apitest.Tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.apitest.Base.BaseTest;
import com.qa.apitest.Client.RestClient;
import com.qa.apitest.Utils.ConstUtil;

public class GetTest extends BaseTest {
	public String url;
	public String serviceUrl;
	public String uri;

	@Test
	public void getTest() throws ClientProtocolException, IOException {
		url = ip.prop.getProperty("URL");
		serviceUrl = ip.prop.getProperty("serviceURL");
		uri = url + serviceUrl;
		rc.get(uri);

	}

	@Test
	public void GetWithoutHeaders() throws ClientProtocolException, IOException {
		url = ip.prop.getProperty("URL");
		serviceUrl = ip.prop.getProperty("serviceURL");
		uri = url + serviceUrl;
		closeableHttpResponse = rc.getWithOutHeaders(uri);
		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("statuscode -> " + statuscode);
		Assert.assertEquals(statuscode, ConstUtil.RESPONSE_STATUS_CODE_200, "not found");

	}

}
