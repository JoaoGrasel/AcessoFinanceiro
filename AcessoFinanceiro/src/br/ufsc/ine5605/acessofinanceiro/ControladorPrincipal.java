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
        this.controladorCargo = controladorCargo;
        this.controladorData = controladorData;
        this.controladorFuncionario = controladorFuncionario;
        this.controladorAcesso = controladorAcesso;
        this.controladorRegistroAcessoNegado = controladorRegistroAcessoNegado;
    }
    
	public static ControladorPrincipal getInstance() {
		if(controladorPrincipal == null) controladorPrincipal = new ControladorPrincipal();
		return controladorPrincipal;
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
        controladorRegistroAcessoNegado.exibeRelatorio();
    }
    
    public void acessarFinanceiro(ControladorAcesso controladorAcesso){
        this.controladorAcesso.acessaFinanceiro();
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
    
}
