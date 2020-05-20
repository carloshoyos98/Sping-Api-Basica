package org.formacio.api;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
		/*
		 * Optional<Localitat> localitat = Optional.of(em.find(Localitat.class, id));
		 * Probado, pero da errores si no se encuentra valor de Localitat
		 */
		Optional<Localitat> localitat = Optional.ofNullable(em.find(Localitat.class, id));
		//Con localitat.orElse() indicamos que devuelva ese valor por defecto si Localitat no existe.
		return localitat.orElse(new Localitat(0L, "", 0));
	}
	@Transactional
	public void alta (String nom, Integer habitants) {
		Localitat novaLocalitat = new Localitat();
		novaLocalitat.setNom(nom);
		novaLocalitat.setHabitants(habitants);
		em.persist(novaLocalitat);
	}
	
	@Transactional
	public void elimina (long id) {
		Localitat localitat = em.find(Localitat.class, id);
		em.remove(localitat);
	}
	
	public void modifica (Localitat localitat) {
	}

}
