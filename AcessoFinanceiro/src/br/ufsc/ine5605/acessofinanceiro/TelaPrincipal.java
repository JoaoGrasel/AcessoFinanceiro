/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
class TelaPrincipal {
    private Scanner teclado;
    private ControladorPrincipal controlador;

    public TelaPrincipal(ControladorPrincipal owner) {
        this.teclado = new Scanner(System.in);
        this.controlador = owner;
    }
    
    
    
    
}
