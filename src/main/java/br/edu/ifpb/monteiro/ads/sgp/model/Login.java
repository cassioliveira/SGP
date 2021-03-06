/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import br.edu.ifpb.monteiro.ads.sgp.dao.LoginDAO;
import br.edu.ifpb.monteiro.ads.sgp.dao.facades.LoginDaoIF;
import br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.LoginDaoQlf;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Class to modelling the Login entity.
 * 
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.LoginQlf
@Entity 
public class Login implements Serializable, Identifiable {

    @Id
    @SequenceGenerator(name="login_id_seq",
                       sequenceName="login_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="login_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;

    @Column(name = "login_user", nullable = false, length = 16, unique = true)
    private String user;

    @Column(name = "login_password", nullable = false, length = 16)
    private String password;

    @Column(name = "login_level", nullable = false, length = 20)
    private String level;

    /* Annotations and attibutes to relationship of Entities */
    @ManyToOne
    @JoinColumn(name = "fk_employee", referencedColumnName = "id")
    private Employee fkEmployeeId;

    @LoginDaoQlf
    private LoginDAO conect;
    /**
     * 
     * @param login
     * @return
     */
    public boolean validation(Login login){
        if (Objects.equals(conect.find(login).getId(), login.getId())) {
            return true;
        }else{
          return false;   
        } 
    }
    
    
    
    
    
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
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
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Login[ id=" + getId() + " ]";
    }

}
