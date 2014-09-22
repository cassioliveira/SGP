/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *Class to modelling the Room entity.
 * 
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.RoomQlf
@Entity
@Table(name = "Room")
@PrimaryKeyJoinColumn(name = "id")
public class Room implements Serializable, Identifiable {

    @Id
    @SequenceGenerator(name="room_id_seq",
                       sequenceName="room_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="room_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;

    @Column(name = "room_category", length = 50)
    private String category;

    @Column(name = "room_number", length = 4, unique = true)
    private int number;
    
    @Column(name = "room_description", length = 255)
    private String description;
    
    @Column(name = "room_extension_number", length = 6, unique = true)
    private int extensionNumber;

    /* Annotations and attibutes to relationship of Entities */
    
    @ManyToOne
    @JoinColumn(name = "fk_emp_id", referencedColumnName = "id")
    private Employee fkEmpId;

    @OneToMany(mappedBy = "fkRoomId", targetEntity = Accommodation.class)
    private List<Accommodation> accommodations;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
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
     * @return the extensionNumber
     */
    public int getExtensionNumber() {
        return extensionNumber;
    }

    /**
     * @param extensionNumber the extensionNumber to set
     */
    public void setExtensionNumber(int extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    /**
     * @return the fkEmpId
     */
    public Employee getFkEmpId() {
        return fkEmpId;
    }

    /**
     * @param fkEmpId the fkEmpId to set
     */
    public void setFkEmpId(Employee fkEmpId) {
        this.fkEmpId = fkEmpId;
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
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Room[ id=" + getId() + " ]";
    }

}
