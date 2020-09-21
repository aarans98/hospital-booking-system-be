package com.bahagya.miniproject.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AdviceController{

	@ExceptionHandler(Exception.class)
	public @ResponseBody DefaultResponse handleException(Exception e) {
		return DefaultResponse.error(e.getMessage());
	}
	
}
