package com.epam.DesignPatterns;



abstract class Vehicle {
	public abstract int getWheel();

	public String toString() {
		return "Wheels : " + this.getWheel();
	}
}

class Car extends Vehicle {
	int wheel;
	
	public Car(int wheel) {
		super();
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

class Bike extends Vehicle {
	int wheel;
	
	public Bike(int wheel) {
		super();
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

class VehiclesFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if(type == "car") {
			return new Car(wheel);
		} 
		if(type == "bike") {
			return new Bike(wheel);
		}
		return null;
	}
}

public class FactoryDesign {
	public static void main(String[] args) {
		Vehicle car = VehiclesFactory.getInstance("car", 4);
		Vehicle bike = VehiclesFactory.getInstance("bike", 2);
		
		System.out.println(car);
		System.out.println(bike);
	}
}


