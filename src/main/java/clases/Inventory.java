/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author jevel
 */
public class Inventory {
    static Map<Meal,Integer> inventory = new LinkedHashMap<>();

    public Inventory() {       
    }    
    
    public static Map<Meal, Integer> getInventory() {
        return inventory;
    }
    
    public static boolean revisar(Order order) throws Exception{        
        for(Meal o:order.meals.keySet()){
            if(inventory.containsKey(o)){
                try{
                    if((inventory.get(o)-order.meals.get(o)<0)){
                        throw new Exception("The value of meals in order exceeds the value of available on inventory.");
                    }else{
                        inventory.put(o,inventory.get(o)-order.meals.get(o));
                    }
                }catch(NullPointerException ex){
                    throw new NullPointerException("Order is empty.");
                    //System.out.println("Order is empty.");
                }
            }
        }
        return true;
    }
    
    public static boolean availableMeal(Meal meal, int amount) throws Exception {
        //throw new Exception(meal+" is out of inventory for this amount. We only have "+inventory.get(meal)+" left.");
        return (inventory.get(meal)-amount)>=0;
    }
    
}
