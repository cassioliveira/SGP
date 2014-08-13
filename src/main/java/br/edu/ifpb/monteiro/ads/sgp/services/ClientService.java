/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.AbstractDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Client;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
public class ClientService implements ServiceIF<Client> {

    @Inject
    private AbstractDaoIF<Client> clientDAO;

    @Override
    public int count() {
        return clientDAO.count();
    }

    @Override
    public void create(Client entity) {
        clientDAO.create(entity);
    }

    @Override
    public void edit(Client entity) {
        clientDAO.edit(entity);
    }

    @Override
    public Client find(Object id) {
        return clientDAO.find(id);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public List<Client> findRange(int[] range) {
        return clientDAO.findRange(range);
    }

    @Override
    public void remove(Client entity) {
        clientDAO.remove(entity);
    }

}
