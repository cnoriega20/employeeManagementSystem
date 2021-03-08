package com.springboot.rest.controllers;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.rest.SpringbootRestApiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringbootRestApiApplication.class})
@WebAppConfiguration
public class EmployeeControllerTest {
	
	private MockLambdaContext lambdaContext;
	
	private SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testGetOne() {
		fail("Not yet implemented");
	}

}
