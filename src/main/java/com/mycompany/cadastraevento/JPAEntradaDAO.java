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
public class JPAEntradaDAO {
    private EntityManager em;
    
    public JPAEntradaDAO() {
    }
        
    public void salva(Entrada e) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        em.close();
    }
    
    Entrada recupera(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Entrada e = em.find(Entrada.class, id);
        et.commit();
        em.close();
        return e;
    }
    String delete(String sid) {
        String jpqlQuery = "DELETE e FROM Entrada e where e.id = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", sid);
        em.close();
        String resposta = "Registro deletado com sucesso!";
        return resposta;
    }
    
    List<Entrada> searchNameEvent(String sname) {
        String jpqlQuery = "SELECT e FROM Entrada e where e.name = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", sname);
        List<Entrada> e = query.getResultList();
        em.close();
        return e;
    }
    
    Entrada searchId(String sid) {;
        String jpqlQuery = "SELECT e FROM Entrada e where e.id = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", sid);
        Entrada e = (Entrada) query.getResultList();
        em.close();
        return e;
    }

    
    
}
