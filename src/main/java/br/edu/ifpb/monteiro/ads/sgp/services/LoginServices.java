/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.LoginDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@RequestScoped
public class LoginServices implements LoginServicesIF {

    @Inject
    private LoginDaoIF loginDao;
    
    @Override
    public int count() {
        return loginDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        loginDao.create(entity);
    }

    @Override
    public void edit(Identifiable entity) {
        loginDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return loginDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return loginDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return loginDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        loginDao.remove(entity);
    }

    
}
