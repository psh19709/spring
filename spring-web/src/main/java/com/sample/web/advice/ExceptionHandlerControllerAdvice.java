package com.sample.web.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sample.exception.ApplicationException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(ApplicationException.class)
	public String handleApplicationException(ApplicationException ex) {
		ex.printStackTrace();
		return "error/500";
	}
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDataAccessException(DataAccessException ex) {
		ex.printStackTrace();
		return "error/500";
	}

	@ExceptionHandler(RuntimeException.class)
	public String handleApplicationException(RuntimeException ex) {
		ex.printStackTrace();
		return "error/500";
	}
}
