package com.springboot.rest.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@ResponseBody
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request){
		CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.build();
		return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<CustomErrorResponse> handleEmployeeNotFoundException(
			EmployeeNotFoundException ex, WebRequest request) {
		CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
								.timestamp(LocalDateTime.now())
								.status(HttpStatus.NOT_FOUND.value())
								.build();
		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
															   HttpHeaders headers, HttpStatus status,
															   WebRequest request) {
		CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.build();
		return new ResponseEntity(customErrorResponse, HttpStatus.BAD_REQUEST);
	}




}
