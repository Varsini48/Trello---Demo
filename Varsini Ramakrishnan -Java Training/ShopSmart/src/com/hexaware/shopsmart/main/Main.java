package com.hexaware.shopsmart.main;

import java.util.Scanner;

import com.hexaware.shopsmart.dao.ItemManagementImpl;
import com.hexaware.shopsmart.dao.ItemManagement;
import com.hexaware.shopsmart.exception.InvalidPriceException;
import com.hexawrae.shopsmart.entity.Item;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ItemManagementImpl itemm = new ItemManagementImpl();
		
		while (true)
		{
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Get Item");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();
            
            
            switch(choice)
            {
            case 1:
            	System.out.println("Enter item details to add:");
                System.out.println("Item Name: ");
                String itemName = sc.next();
                System.out.println("Price: ");
                double price = sc.nextDouble();
                System.out.println("Category: ");
                String category = sc.next();

                Item newItem = new Item(itemName, price, category);

                try {
                	itemm.addItem(newItem);
                    System.out.println("Item added successfully!");
                } catch (InvalidPriceException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
                
            case 2:
            	System.out.println("Enter item details to update:");
                System.out.print("Item Name: ");
                String updateItemName = sc.nextLine();
                System.out.println("New Price: ");
                double newPrice = sc.nextDouble();
                System.out.print("New Category: ");
                String newCategory = sc.nextLine();

                Item updatedItem = new Item(updateItemName, newPrice, newCategory);

                try {
                	itemm.updateItem(updatedItem);
                    System.out.println("Item updated successfully!");
                } catch (InvalidPriceException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
                
            case 3:
            	System.out.println("Enter the item name to delete:");
                System.out.print("Item Name: ");
                String deleteItemName = sc.nextLine();

                itemm.deleteItem(deleteItemName);
                System.out.println("Item deleted successfully!");
                break;
                
            case 4:
            	System.out.println("Enter the item name to retrieve:");
                System.out.print("Item Name: ");
                String getItemName = sc.nextLine();

                Item fetchedItem = itemm.getItem(getItemName);
                if (fetchedItem != null) {
                    System.out.println("Item found: " + fetchedItem);
                } else { }
                break;
                
            case 5:
                System.out.println("Exiting the system...");
                sc.close();
                System.exit(0);
                break;
                
            default:
                System.out.println("Invalid option. Please try again.");

            }
		}
	}

}
