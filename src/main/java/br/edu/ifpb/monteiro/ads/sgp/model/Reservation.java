/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to modelling the Reservation entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.ReservationQlf
@Entity 
@Table(name = "Reservation")
@PrimaryKeyJoinColumn(name = "id")
public class Reservation implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="reservation_id_seq",
                       sequenceName="reservation_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="reservation_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;

    @Column(name = "res_forecast_input", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar dateInput;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "res_forecast_output", nullable = false)
    private GregorianCalendar forecastOutput;

    @Column(name = "res_room_type", length = 50)
    private String roomType;

    @Column(name = "res_dependent", nullable = false, length = 5)
    private int dependent;

    @Column(name = "res_quantity_child", nullable = false, length = 5)
    private int quantityChild;

    /* Annotations and attibutes to relationship of Entities */
    @ManyToOne
    @JoinColumn(name = "fk_employee", referencedColumnName = "id")
    private Employee fkEmployeeId;

    @ManyToOne
    @JoinColumn(name = "fk_client", referencedColumnName = "id")
    private Client fkClientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the dateInput
     */
    public GregorianCalendar getDateInput() {
        return dateInput;
    }

    /**
     * @param dateInput the dateInput to set
     */
    public void setDateInput(GregorianCalendar dateInput) {
        this.dateInput = dateInput;
    }

    /**
     * @return the forecastOutput
     */
    public GregorianCalendar getForecastOutput() {
        return forecastOutput;
    }

    /**
     * @param forecastOutput the forecastOutput to set
     */
    public void setForecastOutput(GregorianCalendar forecastOutput) {
        this.forecastOutput = forecastOutput;
    }

    /**
     * @return the roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * @return the dependent
     */
    public int getDependent() {
        return dependent;
    }

    /**
     * @param dependent the dependent to set
     */
    public void setDependent(int dependent) {
        this.dependent = dependent;
    }

    /**
     * @return the quantityChild
     */
    public int getQuantityChild() {
        return quantityChild;
    }

    /**
     * @param quantityChild the quantityChild to set
     */
    public void setQuantityChild(int quantityChild) {
        this.quantityChild = quantityChild;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Reservation[ id=" + id + " ]";
    }

}
