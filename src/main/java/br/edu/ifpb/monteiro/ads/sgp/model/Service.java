/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to modelling the Service entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.ServiceQlf
@Entity 
@Table(name = "Service")
@PrimaryKeyJoinColumn(name = "id")
public class Service implements Serializable, Identifiable {

    @Id
    @SequenceGenerator(name="service_id_seq",
                       sequenceName="service_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="service_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;

    @Column(name = "service_description", nullable = false, length = 255)
    private String description;

    @Column(name = "service_price", nullable = false, length = 10)
    private double price;

    @Column(name = "service_type", length = 50)
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "service_date_time")
    private GregorianCalendar dateTime;

    /* Annotations and attibutes to relationship of Entities */
    @ManyToOne
    @JoinColumn(name = "fk_employee", referencedColumnName = "id")
    private Employee fkEmployeeId;

    @ManyToOne
    @JoinColumn(name = "fk_client", referencedColumnName = "id")
    private Client fkClientId;

    @ManyToMany
    @JoinTable(name = "accomodation_service",
            joinColumns
            = @JoinColumn(name = "acc_id", referencedColumnName = "id"),
            inverseJoinColumns
            = @JoinColumn(name = "service_id", referencedColumnName = "id")
    )
    private List<Accommodation> accommodations;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the dateTime
     */
    public GregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(GregorianCalendar dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the fkEmployeeId
     */
    public Employee getFkEmployeeId() {
        return fkEmployeeId;
    }

    /**
     * @param fkEmployeeId the fkEmployeeId to set
     */
    public void setFkEmployeeId(Employee fkEmployeeId) {
        this.fkEmployeeId = fkEmployeeId;
    }

    /**
     * @return the fkClientId
     */
    public Client getFkClientId() {
        return fkClientId;
    }

    /**
     * @param fkClientId the fkClientId to set
     */
    public void setFkClientId(Client fkClientId) {
        this.fkClientId = fkClientId;
    }

    /**
     * @return the accommodations
     */
    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    /**
     * @param accommodations the accommodations to set
     */
    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Service[ id=" + id + " ]";
    }

}
