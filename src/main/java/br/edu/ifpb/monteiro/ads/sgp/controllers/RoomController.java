package br.edu.ifpb.monteiro.ads.sgp.controllers;

import br.edu.ifpb.monteiro.ads.sgp.model.Room;
import br.edu.ifpb.monteiro.ads.sgp.model.Identifiable;
import br.edu.ifpb.monteiro.ads.sgp.services.RoomServicesIF;
import br.edu.ifpb.monteiro.ads.sgp.services.ServicesIF;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Named("roomController")
@SessionScoped
public class RoomController extends AbstractController<Room> implements RoomControllerIF {

    @Inject
    private RoomServicesIF services;
    
 
    
    @Override
    public Identifiable prepareCreate() {
        setSelected(new Room());
        initializeEmbeddableKey();
        return getSelected();
    }

    @Override
    protected ServicesIF getServices() {
        return services;
    }

    
    @FacesConverter(forClass = Room.class)
    public static class RoomControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RoomController controller = (RoomController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "roomController");
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
            if (object instanceof Room) {
                Room o = (Room) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Room.class.getName()});
                return null;
            }
        }

    }

}
