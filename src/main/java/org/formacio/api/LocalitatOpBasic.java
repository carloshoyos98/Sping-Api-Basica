package org.formacio.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */

@Repository
public class LocalitatOpBasic {
	
	@PersistenceContext
	private EntityManager em;
	
	public Localitat carrega (long id) {
		Localitat localitat = em.find(Localitat.class, id);
		return localitat;
	}
	
	public void alta (String nom, Integer habitants) {
	}
	
	public void elimina (long id) {
	}
	
	public void modifica (Localitat localitat) {
	}

}
