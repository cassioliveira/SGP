/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.services.facade.ClientServicesIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.facades.ClientDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.ClientDaoQlf;
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
public class ClientServices implements ClientServicesIF {

    @Inject
    @ClientDaoQlf
    private ClientDaoIF clientDao;

    @Override
    public int count() {
        return clientDao.count();
    }

    @Transactional
    @Override
    public void create(Identifiable entity) {

        try {
            this.clientDao.create(entity);
        } catch (Exception e) {
            System.err.println("Erro no Service: " + e.getMessage());
        }
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
