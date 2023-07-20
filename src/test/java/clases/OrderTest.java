package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class OrderTest {
	
	private static Map<Meal,Integer> inventory = Inventory.getInventory();
	private static Meal pizzaMargarita = new Meal("Pizza Margarita",12.99);
	private static Meal pizzaNapolitana = new Meal("Pizza Napolitana",10.99);
	private static Meal pizzaVegetariana = new Meal("Pizza Vegetariana",8.99);
	Meal pastaAlfredo = new Meal("Pasta Alfredo",8.99);
	Meal pastaMarTierra = new Meal("Pasta Mar y Tierra",true,13.99);
	Meal pizzaCarnica = new Meal("Pizza Carnica", true, 15.99);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		inventory.put(pizzaMargarita, 10);
		inventory.put(pizzaNapolitana, 30);
		inventory.put(pizzaVegetariana, 8);
		inventory.put(pastaAlfredo, 8);
		inventory.put(pastaMarTierra, 3);
		inventory.put(pizzaCarnica, 2);
	}

	@Test
	/**
	 * TC-11
	 */
	void testcheckTotalAmmountDiscountLess5()  {
		
		Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
		meals.put(pizzaMargarita , 2);
		meals.put(pizzaNapolitana , 2);
		Order order = new Order(meals);

		double price = (double) (pizzaMargarita.getPrice() * 2 + pizzaNapolitana.getPrice()*2);
		double discount = 0;
		double reduced = 0;
		double added = 0;
		
		double finalPrice = price -(price*discount)-reduced+added;
		assertEquals( finalPrice  , order.checkTotalAmmount() );
	}
	@Test
	/**
	 * TC-12
	 * @throws Exception 
	 */
void testcheckTotalAmmountDiscountLess5Special() throws Exception {
		
		Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
		meals.put(pizzaMargarita , 2);
		meals.put(pizzaCarnica , 1);
		Order order = new Order(meals);

		double price = (double) (pizzaMargarita.getPrice() * 2 + pizzaCarnica.getPrice()*1);
		double discount = 0;
		double reduced = 0;
		double added = price * 0.05;
		
		double finalPrice = price -(price*discount)-reduced+added;
		assertEquals( finalPrice  , order.checkTotalAmmount() );
	}
	
	@Test
	/**
	 * TC-13
	 */
void testcheckTotalAmmountDiscount5to10() throws Exception {
	
	Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
	meals.put(pastaAlfredo , 4);
	meals.put(pizzaMargarita , 2);
	Order order = new Order(meals);

	double price = (double) (pastaAlfredo.getPrice() * 4 + pizzaMargarita.getPrice()*2);
	double discount = 0.1;
	double reduced = 10;
	double added = 0;
	
	double finalPrice = price -(price*discount)-reduced+added;
	assertEquals( finalPrice  , order.checkTotalAmmount() );
}
@Test
/**
 * TC-14
 */
void testcheckTotalAmmountDiscount5to10Special() {
	
	Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
	meals.put(pastaAlfredo , 4);
	meals.put(pizzaCarnica , 2);
	Order order = new Order(meals);

	double price = (double) (pastaAlfredo.getPrice() * 4 + pizzaCarnica.getPrice()*2);
	double discount = 0.1;
	double reduced = 10;
	double added = price * 0.05;
	
	double finalPrice = price -(price*discount)-reduced + added;
	assertEquals( finalPrice  , order.checkTotalAmmount() );
}

@Test
/**
 * TC-15
 */
void testcheckTotalAmmountDiscountLarger10()  {
	
	Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
	meals.put(pizzaMargarita , 5);
	meals.put(pizzaNapolitana , 7);
	Order order = new Order(meals);

	double price = (double) (pizzaMargarita.getPrice() * 5 + pizzaNapolitana.getPrice()*7);
	double discount = 0.2;
	double reduced = 25;
	double added = 0;
	
	double finalPrice = price -(price*discount)-reduced+added;
	assertEquals( finalPrice  , order.checkTotalAmmount() );
}

@Test
/**
 * TC-16
 */
void testcheckTotalAmmountDiscountLarger10Special()  {
	
	Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();
	meals.put(pizzaMargarita , 5);
	meals.put(pastaMarTierra , 7);
	Order order = new Order(meals);

	double price = (double) (pizzaMargarita.getPrice() * 5 + pastaMarTierra.getPrice()*7);
	double discount = 0.2;
	double reduced = 25;
	double added = price * 0.05;
	
	double finalPrice = price -(price*discount)-reduced+added;
	assertEquals( finalPrice  , order.checkTotalAmmount() );
}
	
	
	
}
