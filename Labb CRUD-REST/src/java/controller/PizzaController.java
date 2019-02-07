/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PizzaManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Pizza;

/**
 *
 * @author Ludde
 */
@Named(value = "pizzaController")
@RequestScoped
public class PizzaController {

    @Inject
    PizzaManager pm;
    
    private String name;
    private double price;
    private String description;
    private List<Pizza> allPizzas;
    
    public void submit() {
        Pizza p = new Pizza(name, price, description);
        pm.addPizza(p);
        allPizzas = pm.getAllPizzas();
    }
    
    @PostConstruct
    public void fillArray(){
        this.allPizzas = pm.getAllPizzas();
    }
    
    public PizzaController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pizza> getAllPizzas() {
        return allPizzas;
    }

    public void setAllPizzas(List<Pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }
    
}
