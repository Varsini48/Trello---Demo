package com.hexaware.oops.practice;

public class Bike extends Vehicle{
	
	public Bike(String name, double rentalPrice) {
	     super(name, rentalPrice);
	 }

	 @Override
	 public void rentVehicle() {
	     if (!isRented()) {
	         setRented(true);
	         System.out.println("Bike " + getName() + " has been rented.");
	     } else {
	         System.out.println("Bike " + getName() + " is already rented.");
	     }
	 }

	 @Override
	 public void returnVehicle() {
	     if (isRented()) {
	         setRented(false);
	         System.out.println("Bike " + getName() + " has been returned.");
	     } else {
	         System.out.println("Bike " + getName() + " is not rented.");
	     }
	 }

}
