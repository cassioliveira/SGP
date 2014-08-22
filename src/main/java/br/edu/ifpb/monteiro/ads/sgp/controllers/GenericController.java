/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.controllers;

import br.edu.ifpb.monteiro.ads.sgp.exceptions.SGPException;
import br.edu.ifpb.monteiro.ads.sgp.util.jsf.JsfUtil;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import br.edu.ifpb.monteiro.ads.sgp.services.ServicesIF;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public abstract class GenericController<T extends Identifiable> implements GenericControllerIF {

    /**
     *
     */
    private List<Identifiable> items = null;

    public GenericController() {
    }

    public abstract T getSelected();

    public abstract void setSelected(T selected);

    protected abstract ServicesIF getServices();

    public void create() {
        try {

            this.getServices().create(getSelected());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("ItemCreated"));
            throw new SGPException(); //Verificar se isso realemente é assim ^^

        } catch (SGPException e) {

            JsfUtil.addErrorMessage(e.getLocalizedMessage());
        }

    }

    public void update() {
        try {

            this.getServices().edit(getSelected());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("ItemUpdated"));
            throw new SGPException(); //Verificar se isso realemente é assim ^^

        } catch (SGPException e) {

            JsfUtil.addErrorMessage(e.getLocalizedMessage());
        }
    }

    public void destroy() {
        try {

            this.getServices().remove(getSelected());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("ItemDeleted"));
            if (!JsfUtil.isValidationFailed()) {
                setSelected(null); // Remove selection
                items = null;    // Invalidate list of items to trigger re-query.
            }
            throw new SGPException(); //Verificar se isso realemente é assim ^^

        } catch (SGPException e) {

            JsfUtil.addErrorMessage(e.getLocalizedMessage());
        }

    }

    public List<Identifiable> getItems() {
        if (items == null) {
            items = getServices().findAll();
        }
        return items;
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
