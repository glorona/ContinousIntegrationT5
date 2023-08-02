package clases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inventory;
import clases.Meal;
import clases.Order;

import java.util.LinkedHashMap;
import java.util.Map;

class InventoryTest {
	private static Map<Meal,Integer> inventory = Inventory.getInventory();
	private static Meal pizzaMargarita = new Meal("Pizza Margarita",12.99);
	private static Meal pizzaNapolitana = new Meal("Pizza Napolitana",10.99);
	private static Meal pizzaVegetariana = new Meal("Pizza Vegetariana",8.99);
	

	
	private static Inventory inventario = new Inventory();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
			
	}

	@BeforeEach
	void setUp() throws Exception {
		inventory.put(pizzaMargarita, 10);
		inventory.put(pizzaNapolitana, 30);
		inventory.put(pizzaVegetariana, 8);
	}
	 
	@Test
	/**
	 * TC-01: 
	 */
	void testRevisarLowerLimit() throws Exception {
		
		Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
		meals.put(pizzaMargarita , 1);
		meals.put(pizzaNapolitana , 1);
		Order order = new Order(meals);
		
		boolean aprobado = inventario.revisar(order);
		assertTrue(aprobado);
		assertEquals( 9 , Inventory.getInventory().get(pizzaMargarita));
		assertEquals( 29 , Inventory.getInventory().get(pizzaNapolitana));

	}
	
	@Test
	/**
	 * TC-02: 
	 */
	void testRevisarUpperLimit() throws Exception {
		Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
		meals.put(pizzaMargarita , 10);
		meals.put(pizzaNapolitana , 30);
		Order order = new Order(meals);
		
		boolean aprobado = inventario.revisar(order);
		assertTrue(aprobado);
		assertEquals( 0 , Inventory.getInventory().get(pizzaMargarita));
		assertEquals( 0 , Inventory.getInventory().get(pizzaNapolitana));
	}
	
	@Test
	/**
	 * TC-03: 
	 */
	void testRevisarMediumValue() throws Exception {
		
		Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
		meals.put(pizzaMargarita , 5);
		meals.put(pizzaNapolitana , 10);
		Order order = new Order(meals);
		
		boolean aprobado = inventario.revisar(order);
		assertTrue(aprobado);
		assertEquals( 5 , Inventory.getInventory().get(pizzaMargarita));
		assertEquals( 20 , Inventory.getInventory().get(pizzaNapolitana));;
	}
	
	@Test
	/**
	 * TC-04: 
	 */
	void testAvailableMealLowerLimit() throws Exception {
		boolean aprobado = inventario.availableMeal(pizzaVegetariana , 1);
		assertTrue(aprobado);
	}
	
	@Test
	/**
	 * TC-05: 
	 */
	void testAvailableMealUpperLimit() throws Exception {
		boolean aprobado = inventario.availableMeal(pizzaVegetariana , 8);
		assertTrue(aprobado);
	}
	
	@Test
	/**
	 * TC-06: 
	 */
	void testAvailableMealMediumValue() throws Exception {
		boolean aprobado = inventario.availableMeal(pizzaVegetariana , 3);
		assertTrue(aprobado);
	}
	
	
	@Test
	/**
	 * TC-07: 
	 */
	void testAvailableMealOverLimit() throws Exception {
		boolean aprobado = inventario.availableMeal(pizzaVegetariana , 12);
		assertFalse(aprobado);
	}
	
	
	

}
