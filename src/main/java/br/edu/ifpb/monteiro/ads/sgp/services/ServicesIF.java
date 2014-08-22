/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.services;

import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 */

public interface ServicesIF extends Serializable{

    int count();
    
    
    void create(Identifiable entity);

    void edit(Identifiable entity);

    Identifiable find(Object id);

    List<Identifiable> findAll();

    List<Identifiable> findRange(int[] range);

    void remove(Identifiable entity);

}
