/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.dao;

import java.lang.reflect.ParameterizedType;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author WitaloCarlos
 */
public class DaoFactory {

    @Inject
    private EntityManager entityManager;
    
    @Produces
    @Dependent
    public GenericDAO create(InjectionPoint injectionPoint) {
        ParameterizedType type = (ParameterizedType) injectionPoint.getType();
        Class clazz = (Class) type.getActualTypeArguments()[0];
        return new GenericDAO(clazz);
    }

}
