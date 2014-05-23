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
import javax.persistence.Table;

/**
 *Class to modelling the Room entity.
 * 
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */

@Entity
@Table(name = "Room")
@PrimaryKeyJoinColumn(name = "id")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_category", length = 50)
    private String category;

    @Column(name = "room_number", length = 4)
    private int number;
    
    @Column(name = "room_description", length = 255)
    private String description;
    
    @Column(name = "room_extension_number", length = 6)
    private int extensionNumber;

    /* Annotations and attibutes to relationship of Entities */
    
    @ManyToOne
    @JoinColumn(name = "fk_emp_id", referencedColumnName = "id")
    private Employee fkEmpId;

    @OneToMany(mappedBy = "fkRoomId", targetEntity = Accommodation.class)
    private List<Accommodation> accommodations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Room[ id=" + id + " ]";
    }

}
