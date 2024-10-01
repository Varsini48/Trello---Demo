package com.hexaware.oops.practice;

public class Car extends Vehicle 
{
	public Car(String name, double rentalPrice) {
	     super(name, rentalPrice);
	 }
	
	
	
	@Override
	 public void rentVehicle() {
	     if (!isRented()) {
	         setRented(true);
	         System.out.println("Car " + getName() + " has been rented.");
	     } else {
	         System.out.println("Car " + getName() + " is already rented.");
	     }
	 }

	 @Override
	 public void returnVehicle() {
	     if (isRented()) {
	         setRented(false);
	         System.out.println("Car " + getName() + " has been returned.");
	     } else {
	         System.out.println("Car " + getName() + " is not rented.");
	     }
	 }

}
