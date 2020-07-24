package com.epam.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

class Vehicles implements Cloneable {
	private List<String> vehicleList;

	public Vehicles() {
		this.vehicleList = new ArrayList<String>();
	}

	public Vehicles(List<String> list) {
		this.vehicleList = list;
	}

	public void insertData() {
		vehicleList.add("Audi A4");
		vehicleList.add("Hyundai Creta");
		vehicleList.add("Maruti Baleno");
		vehicleList.add("Duster");
		vehicleList.add("Honda amaze");
		
	}

	public List<String> getVehicleList() {
		return this.vehicleList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList<String>();

		for(String s : this.getVehicleList()) {
			tempList.add(s);
		}

		return new Vehicles(tempList);
	}
}

public class PrototypeDesign {

	public static void main(String[] args) throws CloneNotSupportedException {
		Vehicles a = new Vehicles();
		a.insertData();
		Vehicles b = (Vehicles) a.clone();
		List<String> list = b.getVehicleList();
		list.add("Honda new Amaze");

		System.out.println(a.getVehicleList());
		System.out.println(list);
		b.getVehicleList().remove("Audi A4");
		System.out.println(list);
		System.out.println(a.getVehicleList());
	}

}