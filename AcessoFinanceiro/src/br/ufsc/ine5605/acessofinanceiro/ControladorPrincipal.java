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
    private ControladorDataSistema controladorData;
    private ControladorFuncionario controladorFuncionario;
    private ControladorAcesso controladorAcesso;
    private ControladorRelatorio controladorRelatorio;

    public ControladorPrincipal(TelaPrincipal telaPrincipal, ControladorCargo controladorCargo, ControladorDataSistema controladorData, 
            ControladorFuncionario controladorFuncionario, ControladorAcesso controladorAcesso, ControladorRelatorio controladorRelatorio) {
        this.telaPrincipal = telaPrincipal;
        this.controladorCargo = controladorCargo;
        this.controladorData = controladorData;
        this.controladorFuncionario = controladorFuncionario;
        this.controladorAcesso = controladorAcesso;
        this.controladorRelatorio = controladorRelatorio;
    }
    
    public void exibeMenuPrincipal() {
        
    }
    
    public void gerenciarFuncionarios(ControladorFuncionario controladorFuncionario){
        
    }
    
    public void gerenciarCargos(ControladorCargo controladorCargo){
        
    }
    
    public void gerenciarData(ControladorDataSistema controladorData){
        
    }
    
    public void emitirRelatorio(ControladorRelatorio controladorRelatorio){
        
    }
    
    public void acessarFinanceiro(ControladorAcesso controladorAcesso){
        
    }
    
}
