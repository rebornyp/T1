package com.gastby.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		Target t = new Target();
		MyProxy m = (MyProxy) Proxy.newProxyInstance(t.getClass().getClassLoader(),
				t.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						method.invoke(t, args);
						return null;
					}
				}
			);
		m.rentHouse();
		
		int i = 10;
		new Runnable() {
			@Override
			public void run() {
				System.out.println(i);
			}
		}.run();
	}
}
