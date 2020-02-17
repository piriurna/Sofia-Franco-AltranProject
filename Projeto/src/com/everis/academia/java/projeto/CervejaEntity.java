package com.everis.academia.java.projeto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CervejaEntity
 *
 */
@Entity
@NamedQueries(
	value = {
	@NamedQuery(name = "findAllBeers",
	query = " SELECT c FROM CervejaEntity c" )}		
)

@Table(name="cerveja")

public class CervejaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Com esta linha, a geração de IDs é automática
	
	private Long id;
	private String beerName;
	private String category;
	private int unit;
	private int price;
	private String country;

	
	
	public CervejaEntity() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBeerName() {
		return beerName;
	}


	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getUnit() {
		return unit;
	}


	public void setUnit(int unit) {
		this.unit = unit;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}



	
}