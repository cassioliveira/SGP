package br.edu.ifpb.monteiro.ads.sgp.controllers;

import br.edu.ifpb.monteiro.ads.sgp.model.Reservation;
import br.edu.ifpb.monteiro.ads.sgp.services.facade.ReservationServicesIF;
import br.edu.ifpb.monteiro.ads.sgp.services.facade.ServicesIF;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Named("reservationController")
@RequestScoped
public class ReservationController extends GenericController<Reservation> implements ReservationControllerIF {

   @Inject
    private ReservationServicesIF services;
    
 
   @Inject @br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.ReservationQlf
    private Reservation selected;
        
    @Override
    public Reservation getSelected() {
       return selected;
    }

    @Override
    public void setSelected(Reservation selected) {
        this.selected = selected;
    } 
   

    @Override
    protected ServicesIF getServices() {
        return services;
    }


    @FacesConverter(forClass = Reservation.class)
    public static class ReservationControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReservationController controller = (ReservationController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "reservationController");
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
            if (object instanceof Reservation) {
                Reservation o = (Reservation) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Reservation.class.getName()});
                return null;
            }
        }

    }

}
