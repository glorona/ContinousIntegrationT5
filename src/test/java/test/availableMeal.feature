Feature: Check if there in enougth product in inventory with availableMeal()

	Scenario:  Order of food cannot be delivered because inventory is not available 
	Given an inventory
	|Meal							|Quantity
	|pizzaMargarita		|10
	When An meal to be process contains "pizzaMargarita" for "11" 
	|Meal							|Quantity
	|pizzaMargarita		|11
	Then The order is rejected
	
	Scenario:  Order of food cannot be delivered because inventory is not available 
	Given an inventory
	|Meal							|Quantity
	|pizzaMargarita		|10
	When An meal to be process contains 
	|Meal							|Quantity
	|pizzaMargarita		|5
	Then The order is accepted
	
	