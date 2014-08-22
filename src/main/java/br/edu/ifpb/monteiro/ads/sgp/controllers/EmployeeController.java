package br.edu.ifpb.monteiro.ads.sgp.controllers;

import br.edu.ifpb.monteiro.ads.sgp.model.Employee;
import br.edu.ifpb.monteiro.ads.sgp.services.EmployeeServicesIF;
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

@Named("employeeController")
@RequestScoped
public class EmployeeController extends GenericController<Employee> implements EmployeeControllerIF {

    @Inject 
    private EmployeeServicesIF services;

    @Inject
    @br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.Employee
    private Employee selected;

    @Override
    public Employee getSelected() {
        return selected;
    }

    @Override
    public void setSelected(Employee selected) {
        this.selected = selected;
    }


    @Override
    protected ServicesIF getServices() {
        return services;
    }

    @FacesConverter(forClass = Employee.class)
    public static class EmployeeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmployeeController controller = (EmployeeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "employeeController");
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
            if (object instanceof Employee) {
                Employee o = (Employee) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Employee.class.getName()});
                return null;
            }
        }

    }

}
