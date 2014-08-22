/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.ReservationDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.ReservationDAO;
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
public class ReservationServices implements ReservationServicesIF {

    @Inject @ReservationDAO
    private ReservationDaoIF reservationDao;
    
    @Override
    public int count() {
        return reservationDao.count();
    }

    @Transactional
    @Override
    public void create(Identifiable entity) {
        
        try{
        this.reservationDao.create(entity);
        }catch (Exception e) {
            System.err.println("Erro no Service: "+e.getMessage());
        }
    }

    @Override
    public void edit(Identifiable entity) {
        reservationDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return reservationDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return reservationDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return reservationDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        reservationDao.remove(entity);
    }

    
}
