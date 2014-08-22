/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to modelling the Employee entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.Employee
@Entity()
@Table(name = "Employee")
@PrimaryKeyJoinColumn(name = "id")
public class Employee implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "emp_code", nullable = false, length = 20)
    private String code;

    @Column(name = "emp_name", nullable = false, length = 100)
    private String name;

    @Column(name = "emp_email", nullable = false, length = 100)
    private String email;

    @Inject
    @Embedded
    private Address address;

    @Column(name = "emp_gender", length = 1)
    private char gender;

    @Column(name = "emp_cpf", nullable = false, length = 11, unique = true)
    private char cpf;

    @Column(name = "emp_doc_number", nullable = false, length = 15)
    private String docNumber;

    @Column(name = "emp_doc_type", nullable = false, length = 10)
    private String docType;

    @Column(name = "emp_issuing_body", nullable = false, length = 15)
    private String issuingBoddy;

    @Column(name = "emp_phone1", nullable = false, length = 13)
    private String phone1;

    @Column(name = "emp_phone2", length = 13)
    private String phone2;

    @Column(name = "emp_category", nullable = false, length = 20)
    private String category;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_birthdate")
    private Date birthDate;

    /* Annotations and attibutes to relationship of Entities */
    @OneToMany(mappedBy = "fkEmpId", targetEntity = Room.class)
    private List<Room> rooms;

    @OneToMany(mappedBy = "fkEmployeeId", targetEntity = Accommodation.class)
    private List<Accommodation> accommodations;

    @OneToMany(mappedBy = "fkEmployeeId", targetEntity = Reservation.class)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "fkEmployeeId", targetEntity = Service.class)
    private List<Service> services;

    @OneToMany(mappedBy = "fkEmployeeId", targetEntity = Client.class)
    private List<Client> clients;

    @OneToMany(mappedBy = "fkEmployeeId", targetEntity = Login.class)
    private List<Login> logins;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * @return the cpf
     */
    public char getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(char cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the docNumber
     */
    public String getDocNumber() {
        return docNumber;
    }

    /**
     * @param docNumber the docNumber to set
     */
    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    /**
     * @return the docType
     */
    public String getDocType() {
        return docType;
    }

    /**
     * @param docType the docType to set
     */
    public void setDocType(String docType) {
        this.docType = docType;
    }

    /**
     * @return the issuingBoddy
     */
    public String getIssuingBoddy() {
        return issuingBoddy;
    }

    /**
     * @param issuingBoddy the issuingBoddy to set
     */
    public void setIssuingBoddy(String issuingBoddy) {
        this.issuingBoddy = issuingBoddy;
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
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Employee[ id=" + id + " ]";
    }

}
