/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.IndividualDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.IndividualDAO;
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
public class IndividualServices implements IndividualServicesIF {

    @Inject
    @IndividualDAO
    private IndividualDaoIF individualDao;

    @Override
    public int count() {
        return individualDao.count();
    }

    @Transactional
    @Override
    public void create(Identifiable entity) {

        try {
            this.individualDao.create(entity);
        } catch (Exception e) {
            System.err.println("Erro no Service: " + e.getMessage());
        }
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
