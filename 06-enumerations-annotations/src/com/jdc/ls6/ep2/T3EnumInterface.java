package com.jdc.ls6.ep2;

public class T3EnumInterface {

	public interface MyInterface {
		public void showMessage();
	}
	
	public enum MyEnum implements MyInterface {
		INSTANCE {
			@Override
			public void showMessage() {
				System.out.println("Message from Instance.");
			}
		}
	}
	
	public static void main(String[] args) {
		MyEnum.INSTANCE.showMessage();
	}
}
