/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.ServiceDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.ServiceDAO;
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
public class ServiceServices implements ServiceServicesIF {

    @Inject @ServiceDAO
    private ServiceDaoIF serviceDao;
    
    @Override
    public int count() {
        return serviceDao.count();
    }

    @Transactional
    @Override
    public void create(Identifiable entity) {
        
        try{
        this.serviceDao.create(entity);
        }catch (Exception e) {
            System.err.println("Erro no Service: "+e.getMessage());
        }
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
