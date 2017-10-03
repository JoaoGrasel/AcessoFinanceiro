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
    private ControladorRelatorioAcesso controladorRelatorioAcesso;

<<<<<<< HEAD
    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
=======
    public ControladorPrincipal(TelaPrincipal telaPrincipal, ControladorCargo controladorCargo, ControladorDataSistema controladorData, 
            ControladorFuncionario controladorFuncionario, ControladorAcesso controladorAcesso, ControladorRelatorio controladorRelatorio) {
        this.telaPrincipal = telaPrincipal;
>>>>>>> 221324d38e91fd72ff38f10450eed1cc441d2311
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
    
    public void gerenciarData(ControladorDataSistema controladorData){
        
    }
    
    public void emitirRelatorio(ControladorRelatorioAcesso controladorRelatorioAcesso){
        
    }
    
    public void acessarFinanceiro(ControladorAcesso controladorAcesso){
        
    }
    public void horarioDoSistema(){
        
    }
    
}
