package io.cucumber.skeleton;

import clases.Inventory;
import clases.Meal;
import clases.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class checkTotalAmmount {
	
	private static Map<Meal,Integer> inventory = Inventory.getInventory();
	private static Inventory inventario = new Inventory();
	private static Order order;

	@Given("an inventory with prices:")
	public void an_inventory(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		
		for (Map<String, String> columns : rows) {
			inventory.put(new Meal(columns.get("Meal"), 
					Double.parseDouble(columns.get("Price"))), 
					Integer.parseInt(columns.get("Quantity")));
	    }
	}

	@When("An order to be process contains:")
	public void an_order_to_be_process_contains(io.cucumber.datatable.DataTable dataTable) {
		Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();

		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows) {
			Meal meal = new Meal(columns.get("Meal"), Double.parseDouble(columns.get("Price")));
			meals.put(meal ,Integer.parseInt(columns.get("Quantity")));
	    }
		order = new Order(meals);
	}
	
	@When("An order to be process contains an special:")
	public void an_order_to_be_process_contains_an_special(io.cucumber.datatable.DataTable dataTable) {
		
		Map<Meal,Integer> meals = new LinkedHashMap<Meal,Integer>();

		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows) {
			Meal meal = new Meal(columns.get("Meal"), Boolean.parseBoolean(columns.get("Special")) 
					,Double.parseDouble(columns.get("Price")));
			meals.put(meal ,Integer.parseInt(columns.get("Quantity")));
	    }
		order = new Order(meals);
	}

	@Then("The order is approved")
	public void the_order_is_approved() throws Exception {
		assertTrue(inventario.revisar(order));

	}

	@Then("the final price is {double}")
	public void the_final_price_is(Double double1) {
	    
		double finalPrise = order.checkTotalAmmount();
		assertEquals(double1, finalPrise, 0.5);
	}

	@Given("an inventory with a special")
	public void an_inventory_with_a_special(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows) {
			inventory.put(new Meal(columns.get("Meal"), 
					Boolean.parseBoolean(columns.get("Special")) ,
					Double.parseDouble(columns.get("Price"))), 
					Integer.parseInt(columns.get("Quantity")));
	    }
	}
 
}
