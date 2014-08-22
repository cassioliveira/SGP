/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author cassio
 * @param <T>
 */
@Default
@Dependent
public class GenericDAO<T extends Identifiable> implements GenericDaoIF {

    private Class<T> entityClass;

    
    @Inject
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public GenericDAO() {
    }

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(Identifiable entity) {
        System.out.println("Passei aqui D");
        try {
            getEntityManager().persist(entity);
        } catch (Exception e) {
            System.err.println("Erro no DAO: "+e.getMessage());
        }
        
    }

    @Override
    public void edit(Identifiable entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void remove(Identifiable entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public Identifiable find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<Identifiable> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List<Identifiable> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
