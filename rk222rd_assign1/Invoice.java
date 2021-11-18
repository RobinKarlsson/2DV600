/*
* Date: 2021-09-09.
* File Name: Invoice.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

/**
* Invoice system that a hardware store might use to represent 
* an invoice for an item sold at the store
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Invoice {
	private String part_number;
	private String part_description;
	private int quantity;
	private double price;
	
	public Invoice(String part_number,
			String part_description,
			int quantity,
			double price) {
		this.part_number = part_number;
		this.part_description = part_description;
		this.quantity = quantity;
		this.price = price;
	}
	
	/*
	* Get total price (ie quantity * price)
	* min possible value: 0
	*/
	public double getInvoiceAmount() {
		double amount = quantity * price;
		
		if(amount > 0)
			return amount;
		return 0;
	}
	
	public String getpart_number() {
		//get part_number
		return part_number;
	}
	
	public void setpart_number(String part_number) {
		//set part_number
		this.part_number = part_number;
	}
	
	public String getpart_description() {
		//get part_description
		return part_description;
	}
	
	public void setpart_description(String part_description) {
		//set part_description
		this.part_description = part_description;
	}
	
	public int getquantity() {
		//get quantity
		return quantity;
	}
	
	public void setquantity(int quantity) {
		//set quantity
		this.quantity = quantity;
	}
	
	public double getprice() {
		//get price
		return price;
	}
	
	public void setprice(double price) {
		//set price
		if(price > 0)
			this.price = price;
		else
			this.price = 0;
	}
}
