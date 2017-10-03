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
public class ControladorPrincipal {
    private TelaPrincipal telaPrincipal;
    private ControladorCargo controladorCargo;
    private ControladorData controladorData;
    private ControladorFuncionario controladorFuncionario;
    private ControladorAcesso controladorAcesso;
    private ControladorRelatorioAcesso controladorRelatorioAcesso;

    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.controladorCargo = controladorCargo;
        this.controladorData = controladorData;
        this.controladorFuncionario = controladorFuncionario;
        this.controladorAcesso = controladorAcesso;
        this.controladorRelatorioAcesso = controladorRelatorioAcesso;
    }
    
    public void exibeMenuPrincipal() {
        
    }
    
    public void gerenciarFuncionarios(ControladorFuncionario controladorFuncionario){
        
    }
    
    public void gerenciarCargos(ControladorCargo controladorCargo){
        
    }
    
    public void gerenciarData(ControladorData controladorData){
        
    }
    
    public void emitirRelatorio(ControladorRelatorioAcesso controladorRelatorioAcesso){
        
    }
    
    public void acessarFinanceiro(ControladorAcesso controladorAcesso){
        
    }
    public void horarioDoSistema(){
        
    }
    
}
