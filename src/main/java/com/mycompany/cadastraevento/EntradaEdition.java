/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastraevento;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author arthur.andrade
 */
@Entity
public class EntradaEdition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String year;
    private String date_start;
    private String date_end;
    private String city_host;
    private String country_host;
    @ManyToOne
    private Entrada edition;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }

    public String getDateStart() {
        return date_start;
    }
    
    public void setDateStart(String date_start) {
        this.date_start = date_start;
    }
    
    public String getDateEnd() {
        return date_end;
    }
    
    public void setDateEnd(String date_end) {
        this.date_end = date_end;
    }
    
    
    public String getCityHost() {
        return city_host;
    }

    public void setCityHost(String city_host) {
        this.city_host = city_host;
    }
    
    public String getCountryHost() {
        return country_host;
    }

    public void setCountryHost(String country_host) {
        this.country_host = country_host;
    }
    
    public Entrada getEdition() {
        return edition;
    }

    public void setEdition(Entrada edition) {
        this.edition = edition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaEdition)) {
            return false;
        }
        EntradaEdition other = (EntradaEdition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cadastraevento.EntradaEdition[ id=" + id + " ]";
    }
    
}
