/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.IndividualDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.Individual;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@SessionScoped
public class IndividualServices implements IndividualServicesIF {

    @Inject @Individual
    private IndividualDaoIF individualDao;
    
    @Override
    public int count() {
        return individualDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        individualDao.create(entity);
    }

    @Override
    public void edit(Identifiable entity) {
        individualDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return individualDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return individualDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return individualDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        individualDao.remove(entity);
    }

    
}
