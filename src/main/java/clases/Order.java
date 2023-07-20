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
public class Order {
    public static int  ID = 0;
    Map<Meal,Integer> meals = new LinkedHashMap<>();
    
    public Order(Map<Meal,Integer> meals){
        Order.ID++;
        this.meals = meals;
    }
    
    public double checkTotalAmmount() throws Exception{
        int cont=0;
        double totalPrice=0;
        boolean Special=false;
        double discount =0;
        int reduced=0;
        double added=0;
        
        for(Meal o:meals.keySet()){
            cont+=meals.get(o);
            totalPrice+=meals.get(o)*o.getPrice();
            if(o.getSpecial()){
                Special=true;
            }
        }
        if(cont>100){
            throw new Exception("Ammount out of limit.");
        } 
        if(10>cont && cont>5){
            discount=0.10;
        }else if(cont>10){
            discount=0.2;
        }
        if(Special){
            added=totalPrice*0.05;
        }
        if(totalPrice>50){
            reduced=10;
        }else if (totalPrice>100){
            reduced=25;
        }
        totalPrice= totalPrice + (totalPrice*discount)-reduced+added;
        return totalPrice;
    }
}
