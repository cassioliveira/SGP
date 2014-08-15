/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.dao.RoomDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.Room;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 */
@SessionScoped
public class RoomServices implements RoomServicesIF {

    @Inject @Room
    private RoomDaoIF roomDao;
    
    @Override
    public int count() {
        return roomDao.count();
    }

    @Override
    public void create(Identifiable entity) {
        roomDao.create(entity);
    }

    @Override
    public void edit(Identifiable entity) {
        roomDao.edit(entity);
    }

    @Override
    public Identifiable find(Object id) {
        return roomDao.find(id);
    }

    @Override
    public List<Identifiable> findAll() {
        return roomDao.findAll();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        return roomDao.findRange(range);
    }

    @Override
    public void remove(Identifiable entity) {
        roomDao.remove(entity);
    }

    
}
