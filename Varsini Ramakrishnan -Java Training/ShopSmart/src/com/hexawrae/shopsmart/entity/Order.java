package com.hexawrae.shopsmart.entity;

import java.util.List;
import java.util.stream.Stream;

public class Order {
	
	private String orderId;
	private List<Item> itemList;
	private double totalPrice;
	
	//constructor
	
	public Order(String orderId, List<Item> itemList, double totalPrice)
	{
		this.orderId=orderId;
		this.itemList=itemList;
		this.totalPrice=totalPrice;
	}
	
	//getters and setters

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double calculateTotalPrice()
	{
		totalPrice=0.0;
		for(Item item : itemList)
		{
			totalPrice= totalPrice+item.getPrice();
	}
		return totalPrice;

	}
	
	
	
	

}
