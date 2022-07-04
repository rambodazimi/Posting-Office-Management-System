package ir.ac.kntu;

import java.util.*;
import java.io.*;

/**
 * @author Rambod Azimi
 */


public class Main {
		
	static Scanner input = new Scanner(System.in);	//static scanner class that we can use it in all body of our Main class
	
    public static void main(String[] args) {
    	
    	
		Admin admin = new Admin(); 		//new Admin instance

    	System.out.println("Hi admin!");

    	
    	while(true) {				//admin's menu

	    	System.out.println("What do you want to do?");
	    	System.out.println("1.Add a customer");
	    	System.out.println("2.Remove a customer");
	    	System.out.println("3.Customers list");
	    	System.out.println("4.Add a city");
	    	System.out.println("5.Remove a city");
	    	System.out.println("6.Cities list");
	    	System.out.println("7.Add a good");
	    	System.out.println("8.Send a good");
	    	System.out.println("9.Status of an Order");
	    	System.out.println("10.Orders List");


	    	
	    	try {
				
				
				int a = input.nextInt();
		
				if(a==1) { //add customer
					
					admin.addCustomer();

					
				} 
				else if(a==2) { //remove customer
					
					admin.removeCustomer();
							
				}
				else if(a==3) { //customers list
					
					admin.showList();
				
				}
				else if (a==4) { //add city
					
					admin.addCity();
					
				}
				else if(a==5) { //remove city
					
					admin.removeCity();

				}
				else if (a==6) { //cities list
					
					admin.cityList();
					
				}
				else if (a==7) { //add good
					
					admin.addGood();
					
				}
				else if (a==8) { //send an order
					
					admin.sendOrder();
					
				}

				else if (a==9) { //status of an order
					
					admin.showStatus();
					
				}
				else if (a==10) {
					
			    	System.out.println("Show by which filter?");
			    	System.out.println("1. By Customers");
			    	System.out.println("2. By Weights");
			    	System.out.println("3. By Costs");
			    	System.out.println("4. By Destinations");
			    	System.out.println("5. By Status");

			    	int f = input.nextInt();

			    	if(f==1) { //filter by costomers
			    		
			    		admin.customerFilter();
			    		
			    	}
			    	else if (f==2) {//filter by weights
			    		
			    		admin.weightFilter();
			    		
			    	}
			    	else if (f==3) {//filter by costs
			    		
			    		admin.costFilter();

			    		
			    	}
			    	else if (f==4) {//filter by dests
	
			    		admin.destFilter();

			    		
			    	}
			    	else if (f==5) {//filter by status
	
			    		admin.statusFilter();

			    		
			    	}
					
				}
				else {
					System.err.println("\nCode is wrong. Please try again: ");
				}
				}
			
			catch(InputMismatchException e) {
				input.next();
				System.err.println("Code is wrong. Please try again: ");
			}
				
			}					

			
		}
	
	
    }

