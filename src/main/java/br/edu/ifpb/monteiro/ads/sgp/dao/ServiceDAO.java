/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.dao.facades.ServiceDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.model.Service;

/**
 *
 * @author cassio
 */
@br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.ServiceDaoQlf
public class ServiceDAO extends GenericDAO<Service> implements ServiceDaoIF {


    public ServiceDAO() {
        super(Service.class);
    }

}
