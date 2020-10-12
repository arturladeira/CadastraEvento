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
    
    public EntradaEdition merge(EntradaEdition edition) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        EntradaEdition edicaoMerge = em.merge(edition);
        et.commit();
        em.close();
        return edicaoMerge;
    }
    
    public EntradaEdition recupera(int id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        EntradaEdition e = em.find(EntradaEdition.class, id);
        et.commit();
        em.close();
        return e;
    }
    
    public List<EntradaEdition> searchYear(String syear) {
        String jpqlQuery = "SELECT e FROM EntradaEdition e where e.year = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", syear);
        List<EntradaEdition> e = query.getResultList();
        em.close();
        return e;
    }
    
    public String delete(int id) {
	try {
            EntradaEdition edition = this.recupera(id);
            em = JPAUtil.getEM();
            EntityTransaction et = em.getTransaction();
            et.begin();
            EntradaEdition removeRdition = em.merge(edition);
            em.remove(removeRdition);
            et.commit();
            em.close();
            return "Edição removida com sucesso.";
        } catch (Exception e) {
            return "A edição não pode ser removida: " + e.toString();
        }

    }
    
    
    
    public EntradaEdition searchId(int id) {
        em = JPAUtil.getEM();
	EntityTransaction et = em.getTransaction();
	et.begin();
	EntradaEdition edition = em.find(EntradaEdition.class, id);
	et.commit();
	em.close();
	return edition;
    }
    
}
