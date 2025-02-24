package com.kh.spring11.error;

public class TargetNotFoundException extends RuntimeException {

	public TargetNotFoundException() {
		super();
	}

	public TargetNotFoundException(String message) {
		super(message);
	}
	
}
