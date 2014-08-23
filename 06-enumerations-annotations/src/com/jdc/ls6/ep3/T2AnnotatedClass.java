package com.jdc.ls6.ep3;

import java.lang.reflect.Method;

public class T2AnnotatedClass {
	
	@T1MethodParam(value="Hello Annotation")
	public void doSomething(String data) {
		System.out.println(data);
	}

	public static void main(String[] args) {
		T2AnnotatedClass a = new T2AnnotatedClass();
		
		Method ms [] = a.getClass().getMethods();
		for(Method m : ms) {
			if(m.isAnnotationPresent(T1MethodParam.class)) {
				try {
					T1MethodParam mp = 
						m.getAnnotation(T1MethodParam.class);
					m.invoke(a, new Object[]{mp.value()});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
