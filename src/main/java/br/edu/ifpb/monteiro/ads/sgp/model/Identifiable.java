/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.model;

import java.io.Serializable;
import javax.enterprise.inject.Default;

/**
 *
 * @author WitaloCarlos
 */
@Default
public interface Identifiable extends Serializable{
 
    public Long getId();
}
