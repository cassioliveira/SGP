package br.edu.ifpb.monteiro.ads.sgp.controllers;

import br.edu.ifpb.monteiro.ads.sgp.model.Client;
import br.edu.ifpb.monteiro.ads.sgp.services.ClientServicesIF;
import br.edu.ifpb.monteiro.ads.sgp.services.ServicesIF;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Named("clientController")
@RequestScoped
public class ClientController extends GenericController<Client> implements ClientControllerIF{

    
    @Inject
    protected ClientServicesIF service;
   
    @Inject @br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.Client
    private Client selected;
        
    @Override
    public Client getSelected() {
       return selected;
    }

    @Override
    public void setSelected(Client selected) {
           this.selected = selected;
    }

   
    
    @Override
    protected ServicesIF getServices() {
         return service;
    }



    
    @FacesConverter(forClass = Client.class)
    public static class ClientControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClientController controller = (ClientController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clientController");
            return controller.getItem(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Client) {
                Client o = (Client) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Client.class.getName()});
                return null;
            }
        }

    }

}
