/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.beans;

import br.edu.ifpb.monteiro.ads.sgp.model.Client;
import br.edu.ifpb.monteiro.ads.sgp.services.ServiceIF;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author WitaloCarlos
 */
@Named("clientWizard")
@ViewScoped
public class ClientWizard {
    
    
    private Client client;
    private ServiceIF<Client> service;
            

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
   
    public void save(ActionEvent actionEvent){
        service.create(client);
        FacesMessage facesMessage = new FacesMessage("Salvo com Sucesso!", "Bem Vindo: "+client.getName());
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        
    }
    
}
