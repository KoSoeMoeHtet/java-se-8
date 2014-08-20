package com.jdc.shop.data;

public class NeedToAlertException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NeedToAlertException(String message) {
		super(message);
	}

}
