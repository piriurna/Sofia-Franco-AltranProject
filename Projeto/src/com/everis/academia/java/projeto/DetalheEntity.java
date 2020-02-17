package com.everis.academia.java.projeto;

import java.io.Serializable;

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
@NamedQueries(value = { @NamedQuery(name = "findAllDetails", query = " SELECT d FROM DetalheEntity d") })

@Table(name = "detalhe")
public class DetalheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Com esta linha, a geração de IDs é automática

	private Long id;
	private String beerName;
	private String details;
	private String brewery;

	public DetalheEntity() {
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}