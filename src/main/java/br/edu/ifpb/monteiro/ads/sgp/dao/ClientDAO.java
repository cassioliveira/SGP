/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.model.Client;

/**
 *
 * @author cassio
 */
@br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.Client
public class ClientDAO extends GenericDAO<Client> implements ClientDaoIF{
    
    

    public ClientDAO() {
        super(Client.class);
    }
    
}
