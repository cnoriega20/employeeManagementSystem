/**
 * 
 */
package com.springboot.rest.awslambda.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.management.RuntimeErrorException;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.springboot.rest.SpringbootRestApiApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cnoriega
 *
 */
@Slf4j
public class StreamLambdaHandler implements RequestStreamHandler {
	
	private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
	
	static {
		try {
			handler = SpringBootLambdaContainerHandler
					.getAwsProxyHandler(SpringbootRestApiApplication.class);
		} catch (ContainerInitializationException e) {
			 // if it fails. We  the exception is re-thrown to force another cold start
			String err = "Could not initialize the Spring Boot application";
			log.error(err);
			throw new RuntimeException(err, e);
			
		}
	}

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		handler.proxyStream(input, output, context);
		output.close();

	}

}
