Feature: Check if there in enougth product in inventory with availableMeal()

  Scenario: Order of food cannot be delivered because inventory is not available
    Given an inventory:
      | Meal           | Quantity |
      | pizzaMargarita |       10 |
     When A meal is order:
      | Meal           | Quantity |
      | pizzaMargarita |       11 |
     Then The meal is rejected

  Scenario: Order of food cannot be delivered because inventory is not available
    Given an inventory:
      | Meal           | Quantity |
      | pizzaMargarita |       10 |
     When A meal is order:
      | Meal           | Quantity |
      | pizzaMargarita |        5 |
     Then The meal is accepted
