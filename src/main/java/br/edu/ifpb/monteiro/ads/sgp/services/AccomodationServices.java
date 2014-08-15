/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.AccomodationDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@RequestScoped
public class AccomodationServices implements AccommodationServicesIF {

    @Inject
    private AccomodationDaoIF accommodationDao;
    
    @Override
    public int count() {
        return accommodationDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        accommodationDao.create(entity);
    }

    @Override
    public void edit(Identifiable entity) {
        accommodationDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return accommodationDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return accommodationDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return accommodationDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        accommodationDao.remove(entity);
    }

    
}
