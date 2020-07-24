package com.epam.DesignPatterns;

class PatternVehicle {
	private String engine;
	private int wheel;
	private boolean ac;
	
	public PatternVehicle(Vehicle vehicle) {
		this.engine = vehicle.engine;
		this.wheel = vehicle.wheel;
		this.ac = vehicle.ac;
	}
	
	public String getEngine() {
		return this.engine;
	}

	public int getWheel() {
		return this.wheel;
	}

	public boolean getAc() {
		return this.ac;
	}

	public static class Vehicle {
		private String engine;
	    private int wheel;
	    private boolean ac;
	    
		public Vehicle(String engine, int wheel) {
			this.engine = engine;
			this.wheel = wheel;
		}
		
		public Vehicle setAc(boolean ac) {
			this.ac = ac;
			return this;
		}
		public PatternVehicle build() {
		      return new PatternVehicle(this);
		}
	    
	}
}

public class BuilderDesign {

	public static void main(String[] args) {
		PatternVehicle car1 = new PatternVehicle.Vehicle("1500cc", 4).setAc(true).build();
		PatternVehicle car2 = new PatternVehicle.Vehicle("1500cc", 4).setAc(false).build();
		PatternVehicle bike = new PatternVehicle.Vehicle("250cc", 2).build();
		
		System.out.println(car1.getEngine());
	    System.out.println(car1.getWheel());
	    System.out.println(car1.getAc());
	    
	    System.out.println(car2.getEngine());
	    System.out.println(car2.getWheel());
	    System.out.println(car2.getAc());
	    
	    System.out.println(bike.getEngine());
	    System.out.println(bike.getWheel());
	    System.out.println(bike.getAc());
	}

}
