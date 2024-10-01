package com.hexaware.oops.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRentalSystem 

{
	public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	     Users user = new Users();

	     // List of available vehicles
	     
	     ArrayList<Vehicle> vehicles = new ArrayList<>();
	     vehicles.add(new Car("Audi", 10));
	     vehicles.add(new Bike("Pulsar", 20));
	     vehicles.add(new Truck("Eicher", 30));

	     boolean exit = false;

	     // Menu loop
	     while (!exit) {
	         System.out.println("\n--- Vehicle Rental System ---");
	         System.out.print("Enter choice: ");
	         System.out.println("1. View Available Vehicles");
	         System.out.println("2. Rent a Vehicle");
	         System.out.println("3. Return a Vehicle");
	         System.out.println("4. Rented Vehicles");
	         System.out.println("5. Exit");
	        
	         int choice = sc.nextInt();

	         switch (choice) {
	             case 1:
	                 System.out.println("Available Vehicles:");
	                 for (Vehicle v : vehicles) {
	                     if (!v.isRented()) {
	                         System.out.println(v.getName() + " (Price: $" + v.getRentalPrice() + ")");
	                     }
	                 }
	                 break;

	             case 2:
	                 System.out.println("Enter vehicle number to rent:");
	                 for (int i = 0; i < vehicles.size(); i++) {
	                     if (!vehicles.get(i).isRented()) {
	                         System.out.println(i + ". " + vehicles.get(i).getName() + " (Price: $" + vehicles.get(i).getRentalPrice() + ")");
	                     }
	                 }
	                 int rentChoice = sc.nextInt();
	                 if (rentChoice >= 0 && rentChoice < vehicles.size()) {
	                     user.rentVehicle(vehicles.get(rentChoice));
	                 } else {
	                     System.out.println("Invalid choice.");
	                 }
	                 break;

	             case 3:
	                 System.out.println("Enter vehicle number to return:");
	                 user.viewRentedVehicles();
	                 int returnChoice = sc.nextInt();
	                 if (returnChoice >= 0 && returnChoice < vehicles.size()) {
	                     user.returnVehicle(vehicles.get(returnChoice));
	                 } else {
	                     System.out.println("Invalid choice.");
	                 }
	                 break;

	             case 4:
	                 user.viewRentedVehicles();
	                 break;

	             case 5:
	                 exit = true;
	                 break;

	             default:
	                 System.out.println("Invalid choice.");
	         }
	     }

	
	  
	 }
}

