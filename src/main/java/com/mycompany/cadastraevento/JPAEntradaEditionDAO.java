/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastraevento;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
/**
 *
 * @author arthur.andrade
 */
public class JPAEntradaEditionDAO {
    private EntityManager em;
    
    public JPAEntradaEditionDAO() {
    }
        
    public void salva(EntradaEdition e) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        em.close();
    }
    
    EntradaEdition recupera(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        EntradaEdition e = em.find(EntradaEdition.class, id);
        et.commit();
        em.close();
        return e;
    }
    
    List<EntradaEdition> searchYear(String syear) {
        String jpqlQuery = "SELECT e FROM EntradaEdition e where e.year = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", syear);
        List<EntradaEdition> e = query.getResultList();
        em.close();
        return e;
    }
    
    String delete(String sid) {
        String jpqlQuery = "DELETE e FROM EntradaEdition e where e.id = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", sid);
        em.close();
        String resposta = "Registro deletado com sucesso!";
        return resposta;
    }
    
    EntradaEdition searchId(String sid) {
        String jpqlQuery = "SELECT e FROM EntradaEdition e where e.id = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", sid);
        EntradaEdition e = (EntradaEdition) query.getResultList();
        em.close();
        return e;
    }

    
    
}
