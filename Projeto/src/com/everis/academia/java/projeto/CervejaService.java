package com.everis.academia.java.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CervejaService {

	@SuppressWarnings("unchecked")

	// lista dos dados que vai buscar ao entity (que retira a tabela)
	public List<CervejaEntity> getCervejasList() {

		List<CervejaEntity> cervejasList = new ArrayList<CervejaEntity>();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CraftBeerProject");
			em = emf.createEntityManager();

			EntityTransaction et = em.getTransaction();
			et.begin();

			Query query = em.createNamedQuery("findAllBeers");
			cervejasList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cervejasList;
	}

	public CervejaEntity getCerveja(Long cervejaId) {
		CervejaEntity cerveja = new CervejaEntity();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CraftBeerProject");
			em = emf.createEntityManager();

			cerveja = em.find(CervejaEntity.class, cervejaId);
		} catch (Exception e) {

		} finally {
			if (em != null)
				em.clear();
		}

		return cerveja;
	}

	// ALTERAÇÕES

	public void inserirCerveja(String beerName, String Category, int Unit, int Price, String Country) { // adicionar
																										// todos os
																										// campos (só o
																										// beerName é
																										// obrigatorio)

		CervejaEntity cerveja = new CervejaEntity(); // Service chama o Entity

		cerveja.setBeerName(beerName); // adicionar novos atributos na cerveja
		cerveja.setCategory(Category);
		cerveja.setUnit(Unit);
		cerveja.setPrice(Price);
		cerveja.setCountry(Country);

		// Só preciso de preencher o nome, a chave é gerada automaticamente (ver a nova
		// anotação na classe CervejaEntity)

		EntityManager em = null;

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CraftBeerProject"); // link que esta
																									// definido
			em = emf.createEntityManager();
			em.getTransaction().begin(); // INICIAR O CONTEXTO DA TRANSAÇÃO
			em.persist(cerveja); // CRIAR O OBJECTO
			em.flush();
			em.getTransaction().commit();// PERSISTIR AS ALTERAÇÕES NA BD
			System.out.println("Inseri a cerveja " + cerveja.getBeerName() + " com o id " + cerveja.getId());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close(); // FECHAR A LIGAÇÃO À BD
		}
	}

	public void eliminarBeer(CervejaEntity cerveja) { // remove todos os atributos, remove a linha
		EntityManager em = null;

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CraftBeerProject");
			em = emf.createEntityManager();
			em.getTransaction().begin(); // INICIAR O CONTEXTO DA TRANSAÇÃO
			CervejaEntity eliminarBeer = em.find(CervejaEntity.class, cerveja.getId()); // encontrar a cerveja com o id
																						// que estamos à procura
			em.remove(eliminarBeer); // eliminar
			em.getTransaction().commit(); // PERSISTIR AS ALTERAÇÕES NA BD

		} catch (Exception e) { // para as excepções
			e.printStackTrace();

		} finally {
			if (em != null)
				em.close();

		}

	}

}
