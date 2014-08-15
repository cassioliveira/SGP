/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.controllers;

import br.edu.ifpb.monteiro.ads.sgp.jsf.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import br.edu.ifpb.monteiro.ads.sgp.services.ServicesIF;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.inject.Inject;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public abstract class AbstractController<T extends Identifiable> implements AbstractControllerIF {

    /**
     *
     */
       
    private List<Identifiable> items = null;
    
    private Identifiable selected;

    public AbstractController() {
    }

    public Identifiable getSelected() {
        return selected;
    }

    
    
    public void setSelected(Identifiable selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    protected abstract ServicesIF getServices();

    public abstract Identifiable prepareCreate();
  

    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("resources/Bundle").getString("AccommodationCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("resources/Bundle").getString("AccommodationUpdated"));
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("resources/Bundle").getString("AccommodationDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Identifiable> getItems() {
        if (items == null) {
            items = getServices().findAll();
        }
        return items;
    }

    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getServices().edit(selected);
                } else {
                    getServices().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Identifiable getItem(Long id) {
        return getServices().find(id);
    }

    public List<Identifiable> getItemsAvailableSelectMany() {
        return getServices().findAll();
    }

    public List<Identifiable> getItemsAvailableSelectOne() {
        return getServices().findAll();
    }
}
