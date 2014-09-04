/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.services.facade.CorporateServicesIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.facades.CorporateDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.CorporateDaoQlf;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import br.edu.ifpb.monteiro.ads.sgp.util.jpa.Transactional;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@SessionScoped
public class CorporateServices implements CorporateServicesIF {

    @Inject @CorporateDaoQlf
    private CorporateDaoIF corporateDao;
    
    @Override
    public int count() {
        return corporateDao.count();
    }

    @Transactional
    @Override
    public void create(Identifiable entity) {
        
        try{
        this.corporateDao.create(entity);
        }catch (Exception e) {
            System.err.println("Erro no Service: "+e.getMessage());
        }
    }

    @Override
    public void edit(Identifiable entity) {
        corporateDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return corporateDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return corporateDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return corporateDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        corporateDao.remove(entity);
    }

    
}
