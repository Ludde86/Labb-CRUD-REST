/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Pizza;

/**
 *
 * @author Ludde
 */
@Stateless
public class PizzaManager {

    @PersistenceContext
    EntityManager em;
    
    public void addPizza(Pizza p) {
        em.persist(p);
    }
    
    public List<Pizza> getAllPizzas(){
        Query q = em.createQuery("select p from Pizza p");
        return q.getResultList();
    }
    
}
