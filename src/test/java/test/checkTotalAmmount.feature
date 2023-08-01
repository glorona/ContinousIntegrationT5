
Feature: Calculate final prise of the meal order with checkTotalAmmount()

	Scenario:  Order of food with final price with no discount or extra charges 
		Given an inventory
		|Meal							|Quantity 	|Price
		|pizzaMargarita		|10					|12.99
		|pizzaNapolitana	|10         |10.99
		When An order to be process contains 
		|Meal							|Quantity 	
		|pizzaMargarita		|2
		|pizzaNapolitana	|2
		Then The order is approved  
		And the final price is
	
	Scenario:  Order of food with final price with only a 5% extra charges 
		Given an inventory with a special
		|Meal							|Quantity 	|Price		|Special	
		|pizzaMargarita		|10					|12.99		|false
		|pizzaCarnica 		|10					|15.99		|true
		When An order to be process contains 
		|Meal							|Quantity
		|pizzaMargarita		|2
		|pizzaCarnica 		|1
		Then The order is approved
		And the final price is *1.05
	
	Scenario:  Order of food final price with with only a 10% discount and and -10$  
		Given an inventory
		|Meal							|Quantity		|Price
		|pizzaMargarita		|10					|12.99
		|pastaAlfredo  		|10					|8.99
		When An order to be process contains 
		|Meal							|Quantity
		|pizzaMargarita		|2
		|pastaAlfredo  		|4
		Then The order is approved  
		And the final price is *0.9 -10
	
	Scenario:  Order of food final price with with only a 10% discount and and -10$  
		Given an inventory
		|Meal									|Quantity		|Price
		|pizzaMargarita				|10					|12.99
		|pizzaNapolitana  		|10					|10.99
		When An order to be process contains 
		|Meal									|Quantity
		|pizzaMargarita				|5
		|pizzaNapolitana  		|7
		Then The order is approved  
		And the final price is  *0.8 -25