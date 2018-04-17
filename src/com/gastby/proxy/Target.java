package com.gastby.proxy;

public class Target implements MyProxy{

	@Override
	public void rentHouse() {
		System.out.println("i am renting a house...");
	}
	
}
