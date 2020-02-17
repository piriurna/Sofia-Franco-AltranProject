package com.everis.academia.java.projeto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@ManagedBean(name = "DetalheBean")
@RequestScoped

public class DetalheBean {
	private Long id;
	private String beerName;
	private String details;
	private String brewery;

	// criar lista detalhes para ler a tabela da base de dados
	List<SelectItem> detalhesSelectList;
	List<DetalheEntity> detalhesList;

	public DetalheBean() {

		this.detalhesSelectList = new ArrayList<SelectItem>();

		detalhesList = new DetalheService().getDetalhesList();

		Iterator<DetalheEntity> iterator = detalhesList.iterator();
		while (iterator.hasNext()) {
			DetalheEntity detalhe = (DetalheEntity) iterator.next();
			SelectItem item = new SelectItem(detalhe.getId(), detalhe.getBeerName(), detalhe.getDetails());
			detalhesSelectList.add(item);
		}
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

	public List<SelectItem> getDetalhesSelectList() {
		return detalhesSelectList;
	}

	public void setDetalhesSelectList(List<SelectItem> detalhesSelectList) {
		this.detalhesSelectList = detalhesSelectList;
	}

	public List<DetalheEntity> getDetalhesList() {
		return detalhesList;
	}

	public void setDetalhesList(List<DetalheEntity> detalhesList) {
		this.detalhesList = detalhesList;
	}

	public void detalheReport(ValueChangeEvent event) {
		String value = (String) event.getNewValue();

		if (value != null && !"".equals(value)) {
			long detalheId = Long.parseLong((String) event.getNewValue());
//caracteristica da dropdown
//cria instancia do DetalheService, chama o construtor que esta vazio inicialmente (getDetalhe) e obtem a linha da tabela do id pedido
//A função "this.details etc" faz com que os parametros fiquem associados à instancia da classe 

			DetalheEntity detalhe = new DetalheService().getDetalhe(detalheId);
			this.beerName = detalhe.getBeerName();
			this.details = detalhe.getDetails();
			this.brewery = detalhe.getBrewery();

		}
		// return beerName + "" + category;
		// this.category= cerveja.getCategory();
	}

}
