package com.everis.academia.java.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DetalheService {

	@SuppressWarnings("unchecked")
	public List<DetalheEntity> getDetalhesList() {

		List<DetalheEntity> detalhesList = new ArrayList<DetalheEntity>();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CraftBeerProject");
			em = emf.createEntityManager();

			// EntityTransaction et = em.getTransaction();
			// et.begin();

			Query query = em.createNamedQuery("findAllDetails");
			detalhesList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detalhesList;
	}

	public DetalheEntity getDetalhe(Long detalheId) {
		DetalheEntity detalhe = new DetalheEntity();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CraftBeerProject");
			em = emf.createEntityManager();

			detalhe = em.find(DetalheEntity.class, detalheId);
		} catch (Exception e) {

		} finally {
			if (em != null)
				em.clear();
		}

		return detalhe;
	}
}