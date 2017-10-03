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

    public ControladorCargo(ControladorPrincipal owner) {
        this.cargos = new ArrayList<>();
        this.telaCargo = new TelaCargo(this);
        this.controladorPrincipal = owner;
    }
    
    public void menuCargo(){
        
        int opcao = telaCargo.exibeMenuCargo();

        switch (opcao) {
            case 1:
                incluiCargo();
                break;
            case 2:
                editaCargo();
                break;
            case 3:
                listaCargo();
                break;
            case 4:
                menuDeletarCargo();
                break;
            case 5:
                this.controladorPrincipal.exibeMenuPrincipal();
                break;
            default:
                System.out.println(Constantes.OPCAO_INEXISTENTE);
                menuCargo();
                break;
        }
    }
    
    public void voltaMenuPrincipal() {
        controladorPrincipal.exibeMenuPrincipal();
    }
    public void encontraCargoPorCodigo(int codigo) {
    
    }

    private void incluiCargo() {
    }

    private void editaCargo() {
    }

    private void listaCargo() {
    }

    private void menuDeletarCargo() {
    }
    
    
}
