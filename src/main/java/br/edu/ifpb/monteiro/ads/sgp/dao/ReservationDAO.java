/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.dao;

import br.edu.ifpb.monteiro.ads.sgp.model.Reservation;

/**
 *
 * @author cassio
 */
@br.edu.ifpb.monteiro.ads.sgp.dao.qualifiers.Reservation
public class ReservationDAO extends GenericDAO<Reservation> implements ReservationDaoIF{
   

    public ReservationDAO() {
        super(Reservation.class);
    }
    
}
