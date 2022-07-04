package ir.ac.kntu;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Admin {

	
	static Scanner input = new Scanner(System.in);
	String source, dest;
	int time = 2;
	double [] weigh = new double [100];
	double [] cost = new double [100];
	String [] dests = new String [100];
	String [] senders = new String [100];
	double finalCost;
	Good [] glist = new Good[100];	//good list
	Customer [] clist = new Customer[100]; //customer list
	City [] citylist = new City[100];	//city list
	int i = 0;//customer
	int j = 0;//city
	int k = 0;//good
	int w = 0;//weigh
	int s = 0;//sender
	int p = 0;//cost
	int d = 0;//destination
	//add customer method
	void addCustomer() {
		
		Customer temp = new Customer();//new object of customer to access the fields of Customer class
		System.out.println("Enter the Customer's Firstname: ");
		temp.firstName = input.next();
		System.out.println("Enter the Customer's Lastname: ");
		temp.lastName = input.next();	
		System.out.println("Enter the Customer's ID: ");
		temp.id = input.nextInt();
		
		clist[i] = temp; //assign temp obj to clist[] array of Customer class
		i++;
		System.out.println("Thank you! Customer added successfully.");
		
	}
	
	
	
	//customers list method
	void showList() {
				
		for(int x = 0 ; x<i ; x++) {
			System.out.println(x+1 + ": ");
			System.out.print(clist[x].firstName + "\t");
			System.out.print(clist[x].lastName + "\t");
			System.out.print(clist[x].id + "\t");
			System.out.println("\n");
		}
		
	}
	
	//remove customer method
	void removeCustomer() {
				
		
		while(true) {
			
		
			try {

				System.out.println("Enter the customer's ID: ");
				int id = input.nextInt();
				int n = 1;
				for (int x = 0 ; x<i ; x++) {
					if(clist[x].id == id) { //check if username is in the list of userList array
						clist[x].id = clist[i-1].id;
						clist[x] = clist[i-1];
						i--; //clist array
						System.out.println("Thank you! Your customer deleted successfully. ");
						n=2;
						break;
					}
				}
						if(n==2)break;
						if(n==1)System.err.println("No customer found! Please try again: ");
						}
				catch (InputMismatchException ee) {
					input.next();
					System.err.println("Wrong number! Please try again: ");
				
				}
		}
	}
	
	
	
	
	//add city method
	void addCity() {
		City temp = new City();//new object of city to access the fields of City class
		System.out.println("Enter the City's name: ");
		temp.name = input.next();
		System.out.println("Enter the distance from Tehran: ");
		temp.coordination = input.nextInt();
		
		citylist[j] = temp; //assign temp obj to citylist[] array of City class
		j++;
		System.out.println("Thank you! City added successfully.");
		
	}
	
	
	//remove city method
	void removeCity() {
				
		
		while(true) {
			
		
			try {

				System.out.println("Enter the City's Name: ");
				String name = input.next();
				int n = 1;
				for (int x = 0 ; x<j ; x++) {
					if(citylist[x].name.equalsIgnoreCase(name)) { //check if coordination is in the list of coordinations array
						citylist[x].name = citylist[j-1].name;
						citylist[x] = citylist[j-1];
						j--; //citylist array
						System.out.println("Thank you! City deleted successfully. ");
						n=2;
						break;
					}
				}
						if(n==2)break;
						if(n==1)System.err.println("No City found! Please try again: ");
						}
				catch (InputMismatchException ee) {
					input.next();
					System.err.println("Wrong number! Please try again: ");
				
				}
		}
	}
	
	
	
	//cities list method
	void cityList() {
				
		for(int x = 0 ; x<j ; x++) {
			System.out.println(x+1 + ": ");
			System.out.print(citylist[x].name + "\t");
			System.out.print(citylist[x].coordination + "\t");
			System.out.println("\n");
		}
	}
	
	
	
	
	//add good method
	void addGood() {
		
		int x = 0; //number of source city
		int y = 0; //number of dest city
		int distance;	//calculate the distance of to cities   (dest-source)
		int sender, giver;
		Good temp = new Good();//new object of good to access the fields of Good class
		System.out.println("Enter the Good's Name: ");
		temp.name = input.next();
		
		
			
				
			
		while(true) {
			try {
				System.out.println("Enter the Sender's ID:(For exit, enter 0) ");
				sender = input.nextInt();
				if(sender==0) {
					break;
				}
				int n = 1;
				for (int xx = 0 ; xx<i ; xx++) {
					if(clist[xx].id == sender) { 
						clist[xx].numberOfOrder++;
						senders[s] = clist[xx].firstName;
						s++;
						n=2;
						break;
					}
				}
						if(n==2) {
							break;
						}
						if(n==1)System.err.println("No Customer found! Please try again: ");
						}
				catch (InputMismatchException ee) {
					input.next();
					System.err.println("Wrong number! Please try again: ");
				
				}
		}
			
		
		
		
		
	while(true) {
		try {
			System.out.println("Enter the Giver's ID:(For exit, enter 0) ");
			giver = input.nextInt();
			if(giver == 0) {
				break;
			}
			int n = 1;
			for (int xx = 0 ; xx<i ; xx++) {
				if(clist[xx].id == giver) { 
					n=2;
					break;
				}
			}
					if(n==2)break;
					if(n==1)System.err.println("No Customer found! Please try again: ");
					}
			catch (InputMismatchException ee) {
				input.next();
				System.err.println("Wrong number! Please try again: ");
			
			}
	}
		
		
		
		
		while(true) {
			try {
				System.out.println("Enter the source city name:(For exit, type exit) ");
				source = input.next();
				if(source.equals("exit")) {
					break;
				}
				int n = 1;
				for (x = 0 ; x<j ; x++) {
					if(citylist[x].name.equalsIgnoreCase(source)) { 
						n=2;
						break;
					}
				}
						if(n==2)break;
						if(n==1)System.err.println("No City found! Please try again: ");
						}
				catch (InputMismatchException ee) {
					input.next();
					System.err.println("Wrong number! Please try again: ");
				
				}
		}
		
		
		while(true) {
			try {
				System.out.println("Enter the destination city name:(For exit, type exit) ");
				dest = input.next();
				if(dest.equals("exit")) {
					break;
				}
				int n = 1;
				for (y = 0 ; y<j ; y++) {
					if(citylist[y].name.equalsIgnoreCase(dest)) { 
						n=2;
						dests[d] = dest;
						d++;
						break;
					}
				}
						if(n==2)break;
						if(n==1)System.err.println("No City found! Please try again: ");
						}
				catch (InputMismatchException ee) {
					input.next();
					System.err.println("Wrong number! Please try again: ");
				
				}
		}
		
		System.out.println("Enter the Good's Weight(Kg): ");
		weigh[w] = input.nextDouble();
		w++;
		
		
		distance = citylist[y].coordination - citylist[x].coordination;	//********
		distance = Math.abs(distance);
		
		
		
		double cost1 = distance * 100;	// 100 toman's per km
		double cost2 = weigh[w-1] * 1000;	// 1000 toman's per kg
		
		finalCost = cost1 + cost2;
		cost[p] = finalCost;
		p++;
		
		if(clist[x].numberOfOrder > 5) {		//for customers who have placed more than 5 orders
			finalCost *= 0.9;
		}
		
		while(true) {
			System.out.println("Enter the type of Shipping: ");
			System.out.println("1.Marine");
			System.out.println("2.Ground");
			System.out.println("3.Air");
			
			int a = input.nextInt();
			
			if(a==1) { //daryaii
				time*=2;
				temp.ship=1;
				finalCost*=1.5;
				break;
				 
			}else if(a==2) { //zamini
				time*=3;
				if(distance>500) {
					System.err.println("Sorry. You can't send this good within Ground Shippment. Choose another method.");
					continue;
				}else {
				temp.ship=2;
				finalCost*=1;
				break;
					}
				
			}else if(a==3) { //havaii
				time*=1;
				temp.ship=3;
				finalCost*=2;
				break;
			}
		}
	
		
			System.out.println("Enter the type of Post: ");
			System.out.println("1.Normal");
			System.out.println("2.Special");
			
			int b = input.nextInt();
			if(b==1) { //addi
				temp.post=1;
				finalCost*=1;
				time*=2;
				
			}else if(b==2) { //sefareshi
				temp.post=2;
				finalCost*=2;
				time*=1;
			
		}
		temp.status= "Ordered";	//ordered
		glist[k] = temp; //assign temp obj to glist[] array of Good class
		k++;
		System.out.println("Thank you! Good added successfully.");
		
		System.out.println("The estimate Cost of shipping is: " + finalCost + " tomans.");
		System.out.println("The estimate Time of shipping is: " + time + " days.");


	}
	
		//show status of an order method
		void showStatus() {
			System.out.println("Please enter the order's name: ");
			String name = input.next();
			for(int x = 0 ; x<k ; x++) {
				if(glist[x].name.equalsIgnoreCase(name)) {
					System.out.print("STATUS:" + glist[x].status + "\n");
					break;
				}
			}
		}
		
		//send an order method
		void sendOrder() {
			int n = 1;
			while(true) {
			
				System.out.print("To send your order, please enter the name of your order: ");
				String name = input.next();
				
				for(int x = 0 ; x<k ; x++) {
					if(glist[x].name.equalsIgnoreCase(name)) {
						n = 2;
						System.out.print("Are you sure? (Y/N)");
						String answer = input.next();
						if(answer.equalsIgnoreCase("y")) {
							glist[x].status = "Sent";
							System.out.print("Thanks. Your order sent successfully.");
							break;
						}
					} 
				}
				if(n==2) {
					break;
				}
				if(n==1) {
					System.err.print("No order found! Please try again.");
					continue;
				}
			}
			
			
			
			
			
		}
		
		
		//orders list filtered by customers
		void customerFilter () {
			
			for(int x = 0 ; x < k ; x++) {
				
				System.out.println(x+1 + ": ");
				System.out.print(glist[x].name + "\t");
				System.out.print(senders[x].toUpperCase() + "\t");
				System.out.println("\n");
			
			}
			
		}
		
		//orders list filtered by weights
		void weightFilter () {
			
			for(int x = 0 ; x < k ; x++) {
				
				System.out.println(x+1 + ": ");
				System.out.print(glist[x].name + "\t");
				System.out.print(weigh[x] + " kg" + "\t");
				System.out.println("\n");
			
			}
			
		}
		
		
		//orders list filtered by costs
		void costFilter () {
					
			for(int x = 0 ; x < k ; x++) {
						
				System.out.println(x+1 + ": ");
				System.out.print(glist[x].name + "\t");
				System.out.print(cost[x] + " tomans" + "\t");
				System.out.println("\n");
					
			}
					
		}
		
		
		//orders list filtered by destinations
		void destFilter () {
					
			for(int x = 0 ; x < k ; x++) {
						
				System.out.println(x+1 + ": ");
				System.out.print(glist[x].name + "\t");
				System.out.print(dests[x].toUpperCase() + "\t");
				System.out.println("\n");
					
			}
					
		}
		
		
		//orders list filtered by status
		void statusFilter () {
					
			for(int x = 0 ; x < k ; x++) {
						
				System.out.println(x+1 + ": ");
				System.out.print(glist[x].name + "\t");
				System.out.print(glist[x].status.toUpperCase() + "\t");
				System.out.println("\n");
					
			}
					
		}
	
	
}
