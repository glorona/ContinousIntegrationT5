package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import clases.Inventory;
import clases.Meal;
import clases.Order;


public class Main {
	
	Map<Meal,Integer> inventory = Inventory.getInventory();
	
	public Main() {
		
		Meal pizzaMargarita = new Meal("Pizza Margarita",12.99);
		Meal pizzaNapolitana = new Meal("Pizza Napolitana",10.99);
		Meal pizzaVegetariana = new Meal("Pizza Vegetariana",8.99);
		Meal pizzaSiciliana = new Meal("Pizza Siciliana",12.99);
		Meal pastaCarbonara = new Meal("Pasta Carbonara",8.99);
		Meal pastaAlPesto = new Meal("Pasta Al Pesto",9.99);
		Meal pastaAlfredo = new Meal("Pasta Alfredo",8.99);
		Meal pastaMarTierra = new Meal("Pasta Mar y Tierra",true,13.99);
		Meal pizzaCarnica = new Meal("Pizza Carnica", true, 15.99);
		Meal lasagnaFruttiDiMare = new Meal("Lasagna Frutti Di Mare",true, 13.99);
		
		inventory.put(pizzaMargarita, 10);
		inventory.put(pizzaNapolitana, 30);
		inventory.put(pizzaVegetariana, 8);
		inventory.put(pizzaSiciliana, 12);
		inventory.put(pastaCarbonara, 10);
		inventory.put(pastaAlPesto, 8);
		inventory.put(pastaAlfredo, 8);
		inventory.put(pastaMarTierra, 3);
		inventory.put(pizzaCarnica, 2);
		inventory.put(lasagnaFruttiDiMare, 5);
		
	}
	
	public static void main(String args[]) {
		Main menuDine = new Main();
		menuDine.menuPrincipal();
	}

	private void menuPrincipal() {
		try {
			System.out.println("Welcome to Delicias de la Italia! We have these items available: ");
			int ingreso;
			ArrayList<Meal> mealsAv = new ArrayList<Meal>();
			Map<Meal,Integer> mealsUsr = new LinkedHashMap<Meal, Integer>();
			String confirmacion = "";
	        Scanner sc = new Scanner(System.in);
	        addItems(mealsUsr,mealsAv,sc);
	        
	        //Create Order
	        Order o1 = new Order(mealsUsr);
	        if(Inventory.revisar(o1)) {
	        	String conf = "";
	        	do {
	        	checkOrderDetails(mealsUsr,o1);
	        	do {
		        System.out.println("Are these items correct?");
		        conf = sc.nextLine();
	        	}while(!(conf.equals("Yes") || conf.equals("No")));
		        if(conf.equals("Yes") || conf.equals("yes")) {
		        	System.out.println("Order confirmed.");
		        }
		        else {
		        	addItems(mealsUsr,mealsAv,sc);
		        }
	        	}while (!(conf.equals("Yes")));
	        }
	        
		}catch(InputMismatchException ex) {
			System.out.println("Wrong input! Please insert the correct data.");
			menuPrincipal();
			
		}catch(Exception ex) {
			System.out.println(ex.toString());
			menuPrincipal();
			
		}
	}
	
	private void checkOrderDetails(Map<Meal,Integer> mealsUsr, Order o1) {
		try {
		double total = o1.checkTotalAmmount();
		 System.out.println("Your order details: ");
	        for(Meal ml: mealsUsr.keySet()) {
	        	System.out.println(mealsUsr.get(ml) +  " orders of "  + ml.getName() + " that are " + ml.getPrice().toString() + " each "  );
	        }
	        System.out.println("For a total of $" + total);
		}catch(Exception ex) {
			System.out.println(ex.toString());
			menuPrincipal();
		}
	}
	
	private void addItems(Map<Meal,Integer> mealsUsr, ArrayList<Meal> mealsAv, Scanner sc) {
		try {
		String confirmacion = "";
		int ingreso;
		do {
        	Integer id = 1;
	        for(Meal ml: inventory.keySet()) {
	        	
	        	System.out.println(id.toString() + ". " + ml.getName());
	        	id++;
	        	mealsAv.add(ml);
	        }
	        do {
	        System.out.println("What would you like to order?");
	        ingreso = sc.nextInt();
	        sc.nextLine();
	        }while(ingreso>mealsAv.size());
	        Meal mealSelect = mealsAv.get(ingreso-1);
	        System.out.println("You have selected " + mealSelect.getName() );
	        int cantidad;
	        do {
	        System.out.println("How many would you like to get? ");
	        cantidad = sc.nextInt();
	        sc.nextLine();
	        }while(cantidad<=0);
	        if(Inventory.availableMeal(mealSelect,cantidad)) {
	        	System.out.println("Added to your order.");
	        	mealsUsr.put(mealSelect, cantidad);
	        }
	        
            System.out.println("Would you like to add another item? Yes/No");
            confirmacion = sc.nextLine();
        
        }while (!(confirmacion.equals("No")));
		
	}catch(InputMismatchException ex) {
		System.out.println("Wrong input! Please insert the correct data.");
		menuPrincipal();
		
	}catch(Exception ex) {
		System.out.println(ex.toString());
		menuPrincipal();
		
	}
}
	
}

