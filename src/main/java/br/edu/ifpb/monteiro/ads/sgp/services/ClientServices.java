/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.ClientDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@RequestScoped
public class ClientServices implements ClientServicesIF {

    @Inject
    private ClientDaoIF clientDao;
    
    @Override
    public int count() {
        return clientDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        clientDao.create(entity);
    }

    @Override
    public void edit(Identifiable entity) {
        clientDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return clientDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return clientDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return clientDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        clientDao.remove(entity);
    }

    
}
