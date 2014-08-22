/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.monteiro.ads.sgp.exceptions;

/**
 *
 * @author WitaloCarlos
 */
public class SGPException extends Exception {

    private String msg;
    
    /**
     * Creates a new instance of <code>SGPException</code> without detail
     * message.
     */
    public SGPException() {
    }

    /**
     * Constructs an instance of <code>SGPException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SGPException(String msg) {
        super(msg);
        this.msg = msg;
    }
    
    
}
