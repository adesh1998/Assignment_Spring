package com.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullExceptionHand extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NullExceptionHand(String message) {
		super(message);
	}
}
