package com.hexawrae.shopsmart.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart 
{
	private List<Item> cartItems;
	
	public ShoppingCart()
	{
		cartItems = new ArrayList<>();
	}

	public void addItem(Item item)
	{
		cartItems.add(item);
	}
	
	public void removeItem(Item item)
	{
		cartItems.remove(item);
	}
	
	public List<Item> listCartITems()
	{
		return cartItems;
	}
	
	public void clearCart()
	{
		cartItems.clear();
	}
	
	

}
