package main;
import java.util.Map;

import clases.*;

public class Main {

	public static void main(String args[]) {
		Map<Meal,Integer> inventory = Inventory.getInventory();
		
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
		
		System.out.println("Hola mundo!");
	}
}
