package com.hexaware.oops.practice;

import java.util.*;
import java.util.ArrayList;
public abstract class Vehicle 
{
	
	
	
		
				private String name;
				private double rentalPrice;
				private boolean isRented;
				
				
				public String getName() {
					return name;
				}


				public void setName(String name) {
					this.name = name;
				}


				public double getRentalPrice() {
					return rentalPrice;
				}


				public void setRentalPrice(double rentalPrice) {
					this.rentalPrice = rentalPrice;
				}


				public boolean isRented() {
					return isRented;
				}


				public void setRented(boolean isRented) {
					this.isRented = isRented;
				}


				public Vehicle(String name, double rentalPrice) 
				{
				     this.name = name;
				     this.rentalPrice = rentalPrice;
				     this.isRented = false;
				}
				
				
				public abstract void rentVehicle();
				public abstract void returnVehicle();
			}




