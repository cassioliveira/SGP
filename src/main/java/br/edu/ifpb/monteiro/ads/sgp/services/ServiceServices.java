/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.ServiceDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@RequestScoped
public class ServiceServices implements ServiceServicesIF {

    @Inject
    private ServiceDaoIF serviceDao;
    
    @Override
    public int count() {
        return serviceDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        serviceDao.create(entity);
    }

    @Override
    public void edit(Identifiable entity) {
        serviceDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return serviceDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return serviceDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return serviceDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        serviceDao.remove(entity);
    }

    
}
