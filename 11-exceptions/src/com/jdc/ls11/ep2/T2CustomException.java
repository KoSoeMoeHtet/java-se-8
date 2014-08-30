package com.jdc.ls11.ep2;

public class T2CustomException {
	
	static class CommonException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public CommonException(String message) {
			super(message);
		}
		
	}
	
	static void showLength(String message) {
		if(null == message)
			throw new CommonException("Parameter should not be null");
		
		System.out.println(message.length());
	}
	
	public static void main(String[] args) {
		try {
			showLength(null);
		} catch (CommonException e) {
			System.out.println(e.getMessage());
		}
	}

}
