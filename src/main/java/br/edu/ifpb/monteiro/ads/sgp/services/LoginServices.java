/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.LoginDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.LoginDAO;
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
public class LoginServices implements LoginServicesIF {

    @Inject @LoginDAO
    private LoginDaoIF loginDao;
    
    @Override
    public int count() {
        return loginDao.count();
    }

    @Transactional
    @Override
    public void create(Identifiable entity) {
        
        try{
        this.loginDao.create(entity);
        }catch (Exception e) {
            System.err.println("Erro no Service: "+e.getMessage());
        }
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
