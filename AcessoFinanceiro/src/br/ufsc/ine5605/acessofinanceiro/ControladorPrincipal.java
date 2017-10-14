/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorPrincipal {
	
    private static ControladorPrincipal controladorPrincipal;
	
    public TelaPrincipal telaPrincipal;
    public ControladorCargo controladorCargo;
    public ControladorDataSistema controladorData;
    public ControladorFuncionario controladorFuncionario;
    public ControladorAcesso controladorAcesso;
    public ControladorRegistroAcessoNegado controladorRegistroAcessoNegado;

    
    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.controladorCargo = new ControladorCargo();
        this.controladorData = new ControladorDataSistema();
        this.controladorFuncionario = new ControladorFuncionario();
        this.controladorAcesso = new ControladorAcesso();
        this.controladorRegistroAcessoNegado = new ControladorRegistroAcessoNegado();
    }
    
    public static ControladorPrincipal getInstance() {
        if(controladorPrincipal == null) controladorPrincipal = new ControladorPrincipal();
        return controladorPrincipal;
    }
	
    public void exibeMenuPrincipal() {
        telaPrincipal.exibeMenuPrincipal();
        controlaMenuPrincipal();
    }   
        
    public void controlaMenuPrincipal() {
        int opcao = telaPrincipal.pedeOpcao();
        
        switch(opcao) {
            case 1:
                acessarFinanceiro();
                break;
            case 2: 
                gerenciarFuncionarios();
                break;
            case 3: 
                gerenciarCargos();
                break;
            case 4:
                gerenciarData();
                break;
            case 5:
                emitirRelatorio();
                break;
            default:
                this.telaPrincipal.exibeOpcaoInexistente();
                exibeMenuPrincipal();
        }
    }
    
    public void acessarFinanceiro(){
        this.controladorAcesso.acessaFinanceiro();
    }
    
    public void gerenciarFuncionarios(){
        this.controladorFuncionario.exibeMenuFuncionario();
    }
    
    public void gerenciarCargos(){
        this.controladorCargo.exibeMenuCargo();
    }
    
    public void gerenciarData(){
        this.controladorData.menuDataHoraSistema();
    }
    
    public void emitirRelatorio(){
        controladorRegistroAcessoNegado.exibeRelatorio();
    }
	
    public Date getDataSistema(){
	return controladorData.getDataSistema();
    }

    public Funcionario encontraFuncionarioPelaMatricula(int matricula) {
	return controladorFuncionario.encontraFuncionarioPelaMatricula(matricula);
    }

    public ArrayList<RegistroAcessoNegado> encontraRegistrosHorarioNaoPermitidoPelaMatricula(int matricula) {
	return controladorRegistroAcessoNegado.encontraRegistrosHorarioNaoPermitidoPelaMatricula(matricula);
    }

    public void novoRegistroAcessoNegado(Date data, int matricula, Motivo motivo) {
	controladorRegistroAcessoNegado.novoRegistroAcessoNegado(data, matricula, motivo);
    }

    public boolean matriculaExiste(int matricula) {
    	return controladorFuncionario.matriculaExiste(matricula);
    }

    public void inicia() {
        controladorCargo.criaCargoPadrao();
        exibeMenuPrincipal();
    }

    public void deletaCargosFuncionarios(Cargo cargoDeletado, Cargo cargoIndefinido) {
        controladorFuncionario.deixaFuncionariosSemCargo(cargoDeletado, cargoIndefinido);
    }
    
}
