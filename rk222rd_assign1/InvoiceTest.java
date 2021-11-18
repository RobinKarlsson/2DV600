/*
* Date: 2021-09-09.
* File Name: InvoiceTest.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

/**
* Class to demonstrate capabilities of the Invoice system
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class InvoiceTest {
	public static void main(String args[]) {
		Invoice invoice = new Invoice("part42", 
				"description of part 42",
				21,
				2);
		System.out.println("Part number: " + invoice.getpart_number()); 
		System.out.println("Part description: " + invoice.getpart_description());
		System.out.println("Quantity: " + invoice.getquantity());
		System.out.println("Price: " + invoice.getprice());
		
		System.out.println("Invoice amount: " + invoice.getInvoiceAmount()); //-> 42
		invoice.setprice(-42);
		System.out.println("This should be 0: " + invoice.getInvoiceAmount()); //-> 0
		invoice.setprice(2);
		invoice.setquantity(-21); 
		System.out.println("This should be 0: " + invoice.getInvoiceAmount()); //-> 0
		invoice.setquantity(21); 
	}
}
