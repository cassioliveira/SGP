/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Class to modelling the Corporate entity, making heritage with Client class,
 * by JOINED strategy.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@br.edu.ifpb.monteiro.ads.sgp.model.qualifiers.CorporateQlf
@Entity 
@PrimaryKeyJoinColumn(name = "id")
public class Corporate extends Client implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "client_fantasy_name", nullable = false, length = 100)
    private String fantasyName;

    @Column(name = "client_cnpj", nullable = false, length = 14, updatable = false, unique = true)
    private char cnpj;

    @Column(name = "client_state_register", nullable = false, length = 15, unique = true)
    private String stateRegister;

    @Column(name = "client_municipal_register", nullable = false, length = 15, unique = true)
    private String municipalRegister;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the fantasyName
     */
    public String getFantasyName() {
        return fantasyName;
    }

    /**
     * @param fantasyName the fantasyName to set
     */
    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    /**
     * @return the cnpj
     */
    public char getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(char cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the stateRegister
     */
    public String getStateRegister() {
        return stateRegister;
    }

    /**
     * @param stateRegister the stateRegister to set
     */
    public void setStateRegister(String stateRegister) {
        this.stateRegister = stateRegister;
    }

    /**
     * @return the municipalRegister
     */
    public String getMunicipalRegister() {
        return municipalRegister;
    }

    /**
     * @param municipalRegister the municipalRegister to set
     */
    public void setMunicipalRegister(String municipalRegister) {
        this.municipalRegister = municipalRegister;
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
        if (!(object instanceof Corporate)) {
            return false;
        }
        Corporate other = (Corporate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.monteiro.ads.sgp.model.Corporate[ id=" + id + " ]";
    }

}
