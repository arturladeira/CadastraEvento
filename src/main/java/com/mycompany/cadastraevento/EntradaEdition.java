/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastraevento;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author arthur.andrade
 */
@Entity
@Table(name = "entradaeditions")
public class EntradaEdition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipamento")
    private int id;
    private int number;
    private int year;
    private long  date_start;
    private long  date_end;
    private String city_host;
    private String country_host;
    
    @ManyToOne
    @JoinColumn(name="edition_id")
    private Entrada event;
    
    public EntradaEdition() {
	};

	public EntradaEdition(int id, int number, int year, long date_start, long date_end, String city_host,
			String paisSede, int eventoId, Entrada event) {
		super();
		this.id = id;
		this.number = number;
		this.year = year;
		this.date_start = date_start;
		this.date_end = date_end;
		this.city_host = city_host;
		this.country_host = country_host;

		this.event = event;
	}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.id = number;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    public long getDateStart() {
        return date_start;
    }
    
    public void setDateStart(long date_start) {
        this.date_start = date_start;
    }
    
    public long getDateEnd() {
        return date_end;
    }
    
    public void setDateEnd(long date_end) {
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
    
    public Entrada getEvent() {
        return event;
    }

    public void setEvent(Entrada event) {
        this.event = event;
    }

    
}
