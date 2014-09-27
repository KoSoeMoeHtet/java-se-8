package com.jdc.se.model;

public class ModelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private boolean fatal;
	
	public ModelException(String message, boolean fatal) {
		super(message);
		this.fatal = fatal;
	}
	
	public boolean isFatal() {
		return fatal;
	}

}
