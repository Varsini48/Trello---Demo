package com.hexaware.oops.practice;

import java.util.ArrayList;

public class Users {
	
	private ArrayList<Vehicle> rentedVehicles;

	 public Users() {
	     rentedVehicles = new ArrayList<>();
	 }

	 // Rent a vehicle
	 public void rentVehicle(Vehicle vehicle) {
	     if (!vehicle.isRented()) {
	         vehicle.rentVehicle();
	         rentedVehicles.add(vehicle);
	     } else {
	         System.out.println("Vehicle " + vehicle.getName() + " is already rented.");
	     }
	 }

	 // Return a vehicle
	 public void returnVehicle(Vehicle vehicle) {
	     if (rentedVehicles.contains(vehicle)) {
	         vehicle.returnVehicle();
	         rentedVehicles.remove(vehicle);
	     } else {
	         System.out.println("You haven't rented " + vehicle.getName() + ".");
	     }
	 }

	 // View all rented vehicles
	 public void viewRentedVehicles() {
	     if (rentedVehicles.isEmpty()) {
	         System.out.println("no rented vehicles.");
	     } else {
	         System.out.println("Your rented vehicles:");
	         for (Vehicle v : rentedVehicles) {
	             System.out.println(v.getName() + " (Price: $" + v.getRentalPrice() + ")");
	         }
	     }
	 }

}
