package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import com.example.demo.model.ErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.example.demo.common.enums.*;



public class InvalidRequestParameterException extends Exception{
	@Getter
	@Setter
	protected ErrorResponse response;


	public InvalidRequestParameterException(String param,InvalidRequestParameter type) {
		setResponse(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), param+" is "+type.name()));
	}
	
}
