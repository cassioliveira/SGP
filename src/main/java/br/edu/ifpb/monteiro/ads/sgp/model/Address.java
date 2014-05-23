/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Class to represents compound attribute Address.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Embeddable
public class Address {

    @Column(name = "address_street", length = 100, nullable = false)
    private String street;

    @Column(name = "address_uf", length = 2)
    private char uf;

    @Column(name = "address_neighborhood", length = 30)
    private String neighborhood;

    @Column(name = "address_number", length = 5)
    private int number;

    @Column(name = "address_city", length = 50, nullable = false)
    private String city;

    @Column(name = "address_country", length = 50, nullable = false)
    private String country;

    @Column(name = "address_postal_code", length = 10, nullable = false)
    private String postalCode;

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the uf
     */
    public char getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(char uf) {
        this.uf = uf;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
