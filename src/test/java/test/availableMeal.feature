# language: en

@availableMeal
Feature: Check if there in enougth product in inventory


	@tag1
	#SCENARIO:  Order of food cannot be delivered because inventory is not available 
	#GIVEN an inventori
	|Meal				|Quantity
	|pizzaMargarita		|10
	#WHEN An order is contains 
	|Meal				|Quantity
	|pizzaMargarita		|10
	#THEN The order is rejected
	
	@tag2
	#SCENARIO:  Order of food with final price with no discount or extra charges 
	#GIVEN an inventory
	|Meal				|Quantity
	|pizzaMargarita		|10
	|pizzaNapolitana		|10
	#WHEN An order is contains 
	|Meal				|Quantity
	|pizzaMargarita		|2
	|pizzaNapolitana		|2
	#THEN The order is approve  and the final prise is
	
	@tag3
	#SCENARIO:  Order of food with final price with  only a 5% extra charges 
	#GIVEN an inventory
	|Meal				|Quantity
	|pizzaMargarita		|10
	|pizzaCarnica 		|10
	#WHEN An order is contains 
	|Meal				|Quantity
	|pizzaMargarita		|2
	|pizzaCarnica 		|1
	#THEN The order is approve  and the final prise is *1.05
	
	@tag4
	#SCENARIO:  Order of food final price with with only a 10% discount and and –10$  
	#GIVEN an inventory
	|Meal				|Quantity
	|pizzaMargarita		|10
	|pastaAlfredo  		|10
	#WHEN An order is contains 
	|Meal				|Quantity
	|pizzaMargarita		|2
	|pastaAlfredo  		|4
	#THEN The order is approve  and the final prise is *0.9 -10