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
public class ControladorAcesso {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaAcesso telaAcesso;
    
    public ControladorAcesso() {
        this.controladorPrincipal = new ControladorPrincipal();
        this.telaAcesso = new TelaAcesso();
    }
    
    public void exibeAcessoFinanceiro() {
        telaAcesso.exibeAcessoFinanceiro();
    }
    
    public Funcionario encontraFuncionarioPelaMatricula(int matricula) {
        return controladorPrincipal.encontraFuncionarioPelaMatricula();
    }
    
    public boolean validaAcessoFinanceiro(Funcionario funcionario) {
//        return 
    }
    
}
