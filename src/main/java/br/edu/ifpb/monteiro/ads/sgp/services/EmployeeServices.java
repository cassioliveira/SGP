/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.EmployeeDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@RequestScoped
public class EmployeeServices implements EmployeeServicesIF {

    @Inject
    private EmployeeDaoIF employeeDao;
    
    @Override
    public int count() {
        return employeeDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        employeeDao.create(entity);
    }

    @Override
    public void edit(Identifiable entity) {
        employeeDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return employeeDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return employeeDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        employeeDao.remove(entity);
    }

    
}
