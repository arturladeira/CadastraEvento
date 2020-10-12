/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastraevento;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author arthur.andrade
 */
@Entity
@Table(name = "evento")
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String initials;
    private String area;
    private String institution;
    
    @OneToMany(mappedBy="edition")
    private List<EntradaEdition> entradaEditions;
    
    public Entrada() {
	};
    
    public Entrada(int id, String name, String initials, String area,
			String institution, List<EntradaEdition> entradaEditions) {
		super();
		this.id = id;
		this.name = name;
		this.initials = initials;
		this.area = area;
		this.institution = institution;
		this.entradaEditions = entradaEditions;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    public List getEntradaEdition() {
        return entradaEditions;
    }

    public void setEntradaEdition(List entradaEditions) {
        this.entradaEditions = entradaEditions;
    }
}
