/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorRelatorioAcesso {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaRelatorioAcesso telaRelatorioAcesso;
    
    public ControladorRelatorioAcesso() {
        this.controladorPrincipal = new ControladorPrincipal();
        this.telaRelatorioAcesso = new TelaRelatorioAcesso(this);
    }
    
    public void exibeRelatorio() {
        int filtro = 0;
        filtro = telaRelatorioAcesso.exibeRelatorio();
        switch(filtro) {
            case 0:
//                telaRelatorioAcesso.
        }
    }
    
}
