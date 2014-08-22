/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Class to modelling the Client entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.Client
@Entity
@Table(name = "Client")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id")
public class Client implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "client_name", nullable = false, length = 100)
    private String name;

    @Column(name = "client_email", nullable = false, length = 100)
    private String email;

    @Inject
    @Embedded
    private Address address;

    @Column(name = "client_phone1", nullable = false, length = 13)
    private String phone1;

    @Column(name = "client_phone2", length = 13)
    private String phone2;

    @Column(name = "client_nationality", length = 40)
    private String nationality;

    /* Annotations and attibutes to relationship of Entities */
    @ManyToOne
    @JoinColumn(name = "fk_employee", referencedColumnName = "id")
    private Employee fkEmployeeId;

    @ManyToOne
    @JoinColumn(name = "fk_accommodation", referencedColumnName = "id")
    private Accommodation fkAccommodationId;

    @OneToOne(mappedBy = "client")
    private Accommodation accomodation;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the phone1
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * @param phone1 the phone1 to set
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     * @return the phone2
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * @param phone2 the phone2 to set
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
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
     * @return the fkAccommodationId
     */
    public Accommodation getFkAccommodationId() {
        return fkAccommodationId;
    }

    /**
     * @param fkAccommodationId the fkAccommodationId to set
     */
    public void setFkAccommodationId(Accommodation fkAccommodationId) {
        this.fkAccommodationId = fkAccommodationId;
    }

    /**
     * @return the accomodation
     */
    public Accommodation getAccomodation() {
        return accomodation;
    }

    /**
     * @param accomodation the accomodation to set
     */
    public void setAccomodation(Accommodation accomodation) {
        this.accomodation = accomodation;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Hotel_Guest[ id=" + id + " ]";
    }
}
