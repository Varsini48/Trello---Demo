package com.hexaware.shopsmart.dao;

import com.hexaware.shopsmart.exception.InvalidPriceException;
import com.hexawrae.shopsmart.entity.Item;

public interface ItemManagement {
	
	void addItem(Item item) throws InvalidPriceException;
	void updateItem(Item item) throws InvalidPriceException;
	void deleteItem(String itemName);
	Item getItem(String itemName);

}
