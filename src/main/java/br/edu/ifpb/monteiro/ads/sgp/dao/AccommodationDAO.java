/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.AccomodationDAO;
import br.edu.ifpb.monteiro.ads.sgp.model.Accommodation;

/**
 *
 * @author cassio
 */
@AccomodationDAO
public class AccommodationDAO extends GenericDAO<Accommodation> implements AccomodationDaoIF{
    
    
    public AccommodationDAO() {
        super(Accommodation.class);
    }
    
}
