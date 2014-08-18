/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.dao.JpaUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author WitaloCarlos
 */
public class JpaUtil {
    
    /*
    private static EntityManagerFactory  factory = Persistence.createEntityManagerFactory("seu persistence unit");

	@Produces 
	@RequestScoped
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		em.close();
	}
    */
}
