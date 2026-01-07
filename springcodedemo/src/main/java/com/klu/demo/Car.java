package com.klu.demo;

public class Car {
	private Engine eng;
	public Car(Engine eng)
	{
		this.eng=eng;
	}
	public void drive()
	{
		eng.start();
		System.out.println("Car is moving");
	}
}
