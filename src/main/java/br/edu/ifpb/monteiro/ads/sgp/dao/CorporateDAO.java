/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.model.Corporate;

/**
 *
 * @author cassio
 */
@br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.CorporateDAO
public class CorporateDAO extends GenericDAO<Corporate> implements CorporateDaoIF{
   
    
    public CorporateDAO() {
        super(Corporate.class);
    }
    
}
