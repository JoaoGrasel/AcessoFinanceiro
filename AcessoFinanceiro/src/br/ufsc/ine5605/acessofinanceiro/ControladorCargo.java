/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class ControladorCargo {
    private ArrayList<Cargo> cargos;
    private ControladorPrincipal controladorPrincipal;
    private TelaCargo telaCargo;

    public ControladorCargo() {
        this.cargos = new ArrayList<>();
    }
    
    public void exibeMenuCargo(){
        
    }
    
    public void voltaMenuPrincipal() {
        controladorPrincipal.exibeMenuPrincipal();
    }
    
    
}
