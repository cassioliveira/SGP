/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.CorporateDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.Corporate;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@SessionScoped
public class CorporateServices implements CorporateServicesIF {

    @Inject @Corporate
    private CorporateDaoIF corporateDao;
    
    @Override
    public int count() {
        return corporateDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        corporateDao.create(entity);
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
