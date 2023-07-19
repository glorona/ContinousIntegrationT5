/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
/**
 *
 * @author jevel
 */
public class Meal {
    public String name;
    public Boolean Special;
    public Double price;

    public Meal(String name, Boolean Special, Double price) {
        this.name = name;
        this.Special = Special;
        this.price = price;
    }
    
    public Meal(String name, Double price){
        this.name = name;
        this.Special = false;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSpecial() {
        return Special;
    }

    public void setSpecial(Boolean Special) {
        this.Special = Special;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
}
