/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.model.Individual;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cassio
 */
@Stateless
public class IndividualFacade extends AbstractFacade<Individual> {
    @PersistenceContext(unitName = "br.edu.ifpb.monteiro.ads.sgp_SGP_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndividualFacade() {
        super(Individual.class);
    }
    
}
