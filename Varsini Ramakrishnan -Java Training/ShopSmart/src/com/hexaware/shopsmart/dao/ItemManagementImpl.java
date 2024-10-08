package com.hexaware.shopsmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.shopsmart.util.DBConnection;
import com.hexaware.shopsmart.exception.InvalidPriceException;
import com.hexawrae.shopsmart.entity.Item;

public class ItemManagementImpl 
{

	public void addItem(Item item) throws InvalidPriceException
	{
		
		try (Connection conn = DBConnection.getConnection())
		{
			String sql = "INSERT INTO Item (item_name, price, category) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setDouble(2, item.getPrice());
            ps.setString(3, item.getCategory());
            ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateItem(Item item) throws InvalidPriceException {
        
        try (Connection conn = DBConnection.getConnection())
        {
        	String sql = "UPDATE item SET price = ?, category = ? WHERE item_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setDouble(2, item.getPrice());
            ps.setString(3, item.getCategory());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void deleteItem(String itemName)
	{
		try(Connection conn =DBConnection.getConnection())
		{
			String sql = "DELETE FROM item WHERE item_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public Item getItem(String itemName)
	{
		Item item = null;
		try(Connection conn = DBConnection.getConnection())
		{
			String sql = "SELECT * FROM item WHERE item_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, itemName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				item = new Item(rs.getString("item_name"), rs.getDouble("price"), rs.getString("category"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return item;
	}
	
}
