/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to modelling the Accommodation entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
@Table(name = "Accommodation")
@PrimaryKeyJoinColumn(name = "id")
public class Accommodation implements Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "acc_status", nullable = false, length = 1)
    private boolean status;
    
    @Column(name = "acc_payed", nullable = false, length = 1)
    private boolean payed;

    @Column(name = "acc_checkout", nullable = false, length = 1)
    private boolean checkout;
    
    @Column(name = "acc_missing_item", length = 255)
    private String missingItem;

    @Column(name = "acc_increase", length = 10)
    private double increase;

    @Column(name = "acc_transport", length = 20)
    private String transport;

    @Column(name = "acc_food", length = 1)
    private boolean food;

    @Column(name = "acc_discount", length = 10)
    private double discount;

    @Column(name = "acc_price", nullable = false, length = 10)
    private double price;

    @Column(name = "acc_source", length = 50)
    private String source;

    @Column(name = "acc_observations", length = 255)
    private String observations;

    @Column(name = "acc_reason_travel", length = 40)
    private String reasonTravel;

    @Column(name = "acc_dependent", nullable = false, length = 5)
    private int dependent;

    @Column(name = "acc_quantity_child", nullable = false, length = 5)
    private int quantityChild;

    @Column(name = "acc_next_destination", length = 50)
    private String nextDestination;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "acc_date_input", updatable = false)
    private GregorianCalendar dateInput;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "acc_forecast_output")
    private GregorianCalendar forecastOutput;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "acc_date_output")
    private GregorianCalendar dateOutput;

    /* Annotations and attibutes to relationship of Entities */
    @ManyToOne
    @JoinColumn(name = "fkRoomId", referencedColumnName = "id")
    private Room fkRoomId;

    @ManyToOne
    @JoinColumn(name = "fk_employee", referencedColumnName = "id")
    private Employee fkEmployeeId;

//     @OneToMany(mappedBy = "fkClientId", targetEntity = Client.class)
    @OneToMany(mappedBy = "fkAccommodationId", targetEntity = Client.class)
    private List<Client> clients;

    @ManyToMany(mappedBy = "accommodations", targetEntity = Service.class)
    private List<Service> services;

    @OneToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the checkout
     */
    public boolean isCheckout() {
        return checkout;
    }

    /**
     * @param checkout the checkout to set
     */
    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    /**
     * @return the increase
     */
    public double getIncrease() {
        return increase;
    }

    /**
     * @param increase the increase to set
     */
    public void setIncrease(double increase) {
        this.increase = increase;
    }

    /**
     * @return the transport
     */
    public String getTransport() {
        return transport;
    }

    /**
     * @param transport the transport to set
     */
    public void setTransport(String transport) {
        this.transport = transport;
    }

    /**
     * @return the food
     */
    public boolean isFood() {
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(boolean food) {
        this.food = food;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
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
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the observations
     */
    public String getObservations() {
        return observations;
    }

    /**
     * @param observations the observations to set
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

    /**
     * @return the reasonTravel
     */
    public String getReasonTravel() {
        return reasonTravel;
    }

    /**
     * @param reasonTravel the reasonTravel to set
     */
    public void setReasonTravel(String reasonTravel) {
        this.reasonTravel = reasonTravel;
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
     * @return the nextDestination
     */
    public String getNextDestination() {
        return nextDestination;
    }

    /**
     * @param nextDestination the nextDestination to set
     */
    public void setNextDestination(String nextDestination) {
        this.nextDestination = nextDestination;
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
     * @return the dateOutput
     */
    public GregorianCalendar getDateOutput() {
        return dateOutput;
    }

    /**
     * @param dateOutput the dateOutput to set
     */
    public void setDateOutput(GregorianCalendar dateOutput) {
        this.dateOutput = dateOutput;
    }

    /**
     * @return the fkRoomId
     */
    public Room getFkRoomId() {
        return fkRoomId;
    }

    /**
     * @param fkRoomId the fkRoomId to set
     */
    public void setFkRoomId(Room fkRoomId) {
        this.fkRoomId = fkRoomId;
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
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(List<Service> services) {
        this.services = services;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof Accommodation)) {
            return false;
        }
        Accommodation other = (Accommodation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Accommodation[ id=" + id + " ]";
    }

}
