package com.jdc.ls6.ep2;

public enum T2DataType {
	
	TYPE_ONE {
		@Override
		public String doSomething() {
			return "from type one";
		}
	}, TYPE_TWO {
		@Override
		public String doSomething() {
			return "from type two";
		}
	};
	
	public String doSomething() {
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}
