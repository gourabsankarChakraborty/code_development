package com.abc.service;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ErrorDetail> handleConstraintViolationException(HttpServletRequest request,
//			ConstraintViolationException base) {
//
//
//		ErrorDetail error = new ErrorDetail<ConstraintViolationException>().setErrorDetails(CONSTRAINT_VIOLATION, base,
//				"CONSTRAINT VIOLATION USERNAME ALREADY EXIST.");
//
//		return new ResponseEntity<ErrorDetail>(error, HttpStatus.UNPROCESSABLE_ENTITY);
//
//	}
//	
//	class ErrorDetail extends  ConstraintViolationException{
//
//		public ErrorDetail(Set<? extends ConstraintViolation<?>> constraintViolations) {
//			super(constraintViolations);
//			// TODO Auto-generated constructor stub
//		}
//		
//	}
}
