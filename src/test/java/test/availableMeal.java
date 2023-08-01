package test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

import clases.Meal;
import clases.Inventory;


public class availableMeal {

	private static Map<Meal,Integer> inventory = Inventory.getInventory();
	private static Inventory inventario = new Inventory();
	private static Meal meal;
	private static int total;

	
	@Given("an inventory")
	public void an_inventory(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows) {
			
			inventory.put(new Meal(columns.get("Meal"), 12.99), Integer.parseInt(columns.get("Quantity")));
	    }
	}
	}

	@When("An order to be process contains")
	public void an_order_to_be_process_contains(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		
		meal = new Meal(rows.get(0).get("Meal"), 12.99);
		
		total = Integer.parseInt(rows.get(0).get("Quantity"));
	}

	@Then("The order is rejected")
	public void the_order_is_rejected() {
	    
		assertFalse(inventario.availableMeal(meal, total));
	}
	
	@Then("The order is accepted")
	public void the_order_is_accepted() {
		assertTrue(inventario.availableMeal(meal, total));

	}

}


