package com.demo.spring.service;

import javax.annotation.PostConstruct;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SignalClient {

	public static final Integer maxConnPerRoute = 10;
	public static final Integer maxConnTotal = 10;

	@Autowired
	RestTemplate restTemplate;

	// https://stackoverflow.com/questions/28024942/how-to-autowire-resttemplate-using-annotations
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@PostConstruct
	public void init() {
		acceptEveryCertificate();
		System.out.println("<<<<< POST CONSTRUCT >>>>>");
	}

	protected void acceptEveryCertificate() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().setMaxConnPerRoute(maxConnPerRoute)
					.setMaxConnTotal(maxConnTotal).build();

			boolean isProxyEnabled = false;

			if (isProxyEnabled) {
				String proxyHost = "web-proxy.cup.hp.com";
				int proxyPort = 8080;

				httpClient = HttpClientBuilder.create().disableCookieManagement()
						.setProxy(new HttpHost(proxyHost, proxyPort)).setMaxConnPerRoute(maxConnPerRoute)
						.setMaxConnTotal(maxConnTotal).build();
			}

			ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
			restTemplate.setRequestFactory(requestFactory);

		} catch (Exception e) {
			System.out.println("Signal Client error!!!");
		}
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
}
