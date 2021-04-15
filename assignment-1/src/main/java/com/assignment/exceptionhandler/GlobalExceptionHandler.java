package com.assignment.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.exception.NoValueFoundException;
import com.assignment.exception.NotPossibleException;
import com.assignment.exception.NullExceptionHand;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NoValueFoundException.class })
	public ResponseEntity<ApiError> handlingNoValueFoundException(NoValueFoundException e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ApiError error = new ApiError(e.getMessage(), status);
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = NullExceptionHand.class)
	public ResponseEntity<ApiError> handlingNullException(NullExceptionHand e) {
		HttpStatus status = HttpStatus.PARTIAL_CONTENT;
		ApiError error = new ApiError(e.getMessage(), status);
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = NotPossibleException.class)
	public ResponseEntity<ApiError> handlingNotPossibleException(NotPossibleException e) {
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		ApiError error = new ApiError(e.getMessage(), status);
		return new ResponseEntity<>(error, status);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException e) {
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		ApiError error = new ApiError(e.getLocalizedMessage(),status);
//		return new ResponseEntity<>(error, status);
//	}

}
