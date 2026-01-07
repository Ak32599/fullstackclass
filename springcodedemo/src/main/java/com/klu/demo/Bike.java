package com.klu.demo;

public class Bike {
	private Engine eng;
	public void setEngine(Engine eng)
	{
		this.eng=eng;
	}
	public void ride()
	{
		eng.start();
		System.out.println("Bike is running,,,,");
	}
}
