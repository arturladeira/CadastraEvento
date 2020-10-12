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
    
    public Entrada recupera(int id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Entrada e = em.find(Entrada.class, id);
        et.commit();
        em.close();
        return e;
    }
    
    public String delete(int sid) {
        try {
                Entrada e = this.recupera(sid);
                em = JPAUtil.getEM();
                EntityTransaction et = em.getTransaction();
                et.begin();
                Entrada eventoRemove = em.merge(e);
                em.remove(eventoRemove);
                et.commit();
                em.close();
                return "Evento removido com sucesso.";
        } catch (Exception e) {
                return "O evento não pode ser removido: " + e.toString();
        }
       
    }
    
    public Entrada merge(Entrada e) {
		em = JPAUtil.getEM();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Entrada eventoMerge = em.merge(e);
		et.commit();
		em.close();
		return eventoMerge;
	}
    
    public List<Entrada> searchNameEvent(String sname) {
        String jpqlQuery = "SELECT e FROM Entrada e where e.name = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", sname);
        List<Entrada> e = query.getResultList();
        em.close();
        return e;
    }
    
    public Entrada searchId(String sid) {;
        String jpqlQuery = "SELECT e FROM Entrada e where e.id = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", sid);
        Entrada e = (Entrada) query.getResultList();
        em.close();
        return e;
    }

    
    
}
