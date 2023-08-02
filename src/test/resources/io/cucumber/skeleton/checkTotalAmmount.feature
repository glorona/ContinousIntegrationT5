
Feature: Calculate final price of the meal order with checkTotalAmmount()

	Scenario:  Order of food with final price with no discount or extra charges 
		Given an inventory with prices:
		|Meal							|Quantity 	|Price	|
		|pizzaMargarita		|10					|12.99	|
		|pizzaNapolitana	|10         |10.99	|
		When An order to be process contains:
		|Meal							|Quantity 	| Price	|
		|pizzaMargarita		|2					| 12.99	|
		|pizzaNapolitana	|2					| 10.99	|
		Then The order is approved  
		And the final price is 47.96
	
	Scenario:  Order of food with final price with only a 5% extra charges 
		Given an inventory with a special
		|Meal							|Quantity 	|Price		|Special	|	
		|pizzaMargarita		|10					|12.99		|false		|
		|pizzaCarnica 		|10					|15.99		|true			|
		When An order to be process contains an special:
		|Meal							|Quantity	|Price		|Special	|
		|pizzaMargarita		|2				|12.99		|false		|
		|pizzaCarnica 		|1				|15.99		|true			|
		Then The order is approved
		And the final price is 44.0685
	
	Scenario:  Order of food final price with with only a 10% discount and and -10$  
		Given an inventory with prices:
		|Meal							|Quantity		|Price	|
		|pizzaMargarita		|10					|12.99	|
		|pastaAlfredo  		|10					|8.99		|
		When An order to be process contains:
		|Meal							|Quantity	|Price	|
		|pizzaMargarita		|2				|12.99	|
		|pastaAlfredo  		|4				|8.99		|
		Then The order is approved  
		And the final price is 45.746
	
	Scenario:  Order of food final price with with only a 20% discount and and -25$  
		Given an inventory with prices:
		|Meal									|Quantity		|Price	|
		|pizzaMargarita				|10					|12.99	|
		|pizzaNapolitana  		|10					|10.99	|
		When An order to be process contains:
		|Meal									|Quantity	|Price	|
		|pizzaMargarita				|5				|12.99	|
		|pizzaNapolitana  		|7				|10.99	|
		Then The order is approved  
		And the final price is 88.504