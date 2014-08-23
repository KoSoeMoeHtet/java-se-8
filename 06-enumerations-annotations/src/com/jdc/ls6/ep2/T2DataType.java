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
	
	public abstract String doSomething();
}
