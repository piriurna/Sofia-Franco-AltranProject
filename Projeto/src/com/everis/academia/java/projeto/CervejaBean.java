package com.everis.academia.java.projeto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@ManagedBean(name = "CervejaBean")
@RequestScoped

public class CervejaBean {
	// atributos
	private Long id;
	private String beerName;
	private String category;
	private int unit;
	private int price;
	private String country;

	// variável associada à inputText da página JSP
	// criar lista "cervejas" que vai "ler" a tabela do sql
	// xEntity pq
	// Bean chama o Service e o Service chama o Entity

	// cervejasSelectList lista de SelectedItems de passagem ao xhtml
	// lista que vai buscar à BD

	List<SelectItem> cervejasSelectList;
	List<CervejaEntity> cervejasList;

	// Iterar o CervejaEntity para cada elemento da tabela, enquanto houver
	// elementos adiciona-se Select item à lista

	public CervejaBean() {

		this.cervejasSelectList = new ArrayList<SelectItem>();

		cervejasList = new CervejaService().getCervejasList();

		Iterator<CervejaEntity> iterator = cervejasList.iterator();

		while (iterator.hasNext()) {

			CervejaEntity cerveja = (CervejaEntity) iterator.next();
			SelectItem item = new SelectItem(cerveja.getId(), cerveja.getBeerName());
			cervejasSelectList.add(item);
		}
	}

	// SelectItem item = new SelectItem(cerveja.getId(), cerveja.getBeerName() +
	// cerveja.getId());

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<SelectItem> getCervejasSelectList() {
		return cervejasSelectList;
	}

	public void setCervejasSelectList(List<SelectItem> cervejasSelectList) {
		this.cervejasSelectList = cervejasSelectList;
	}

	public List<CervejaEntity> getCervejasList() {
		return cervejasList;
	}

	public void setCervejasList(List<CervejaEntity> cervejasList) {
		this.cervejasList = cervejasList;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

//registo de uma nova cerveja na lista
	public void inserirBeer() { // Este método é chamado sempre que carregamos no botão
		
		if (getBeerName().isEmpty()) { // se estiver limpo
			
			System.out.println("Tens de Inserir o Nome!"); // nao é possivel inserir novo registo sem nome
			
			return; // devolve
		}
		new CervejaService().inserirCerveja(getBeerName(), getCategory(), getUnit(), getPrice(), getCountry()); 
		
																												
		return;

	}

//Eliminar cerveja da lista
	
	public void eliminarBeer(CervejaEntity cerveja) {
		System.out.println("Apagou");
		cervejasList.remove(cerveja); // remover cerveja da lista
		new CervejaService().eliminarBeer(cerveja); // bean chama o service para eliminar a cerveja
	}

}
