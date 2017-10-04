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
    public TelaPrincipal telaPrincipal;
    public ControladorCargo controladorCargo;
    public ControladorDataSistema controladorData;
    public ControladorFuncionario controladorFuncionario;
    public ControladorAcesso controladorAcesso;
    public ControladorRegistroAcessoNegado controladorRegistroAcessoNegado;

    
    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);

        this.controladorCargo = controladorCargo;
        this.controladorData = controladorData;
        this.controladorFuncionario = controladorFuncionario;
        this.controladorAcesso = controladorAcesso;
        this.controladorRegistroAcessoNegado = controladorRegistroAcessoNegado;
    }
    
    public void exibeMenuPrincipal() {
        
    }
    
    public void gerenciarFuncionarios(ControladorFuncionario controladorFuncionario){
        
    }
    
    public void gerenciarCargos(ControladorCargo controladorCargo){
        
    }
    
    public void gerenciarData(ControladorDataSistema controladorData){
        
    }
    
    public void emitirRelatorio(ControladorRegistroAcessoNegado controladorRegistroAcessoNegado){
        
    }
    
    public void acessarFinanceiro(ControladorAcesso controladorAcesso){
        
    }
    public void horarioDoSistema(){
        
    }
    
}
