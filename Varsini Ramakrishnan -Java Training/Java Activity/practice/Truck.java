package com.hexaware.oops.practice;

public class Truck extends Vehicle {
	
	public Truck(String name, double rentalPrice) {
	     super(name, rentalPrice);
	 }

	 @Override
	 public void rentVehicle() {
	     if (!isRented()) {
	         setRented(true);
	         System.out.println("Truck " + getName() + " has been rented.");
	     } else {
	         System.out.println("Truck " + getName() + " is already rented.");
	     }
	 }

	 @Override
	 public void returnVehicle() {
	     if (isRented()) {
	         setRented(false);
	         System.out.println("Truck " + getName() + " has been returned.");
	     } else {
	         System.out.println("Truck " + getName() + " is not rented.");
	     }
	 }

}
