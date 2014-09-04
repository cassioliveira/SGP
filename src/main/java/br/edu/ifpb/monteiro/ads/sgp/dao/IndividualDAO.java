/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.dao.facades.IndividualDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Individual;

/**
 *
 * @author cassio
 */
@br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.IndividualDaoQlf
public class IndividualDAO extends GenericDAO<Individual> implements IndividualDaoIF{
   
    

    public IndividualDAO() {
        super(Individual.class);
    }
    
}
