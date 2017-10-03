/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.InputMismatchException;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorAcesso {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaAcesso telaAcesso;
    
    public ControladorAcesso() {
        this.controladorPrincipal = new ControladorPrincipal();
        this.telaAcesso = new TelaAcesso(this);
    }
    
    public void acessaFinanceiro() {
        int matricula = 0;
        matricula = telaAcesso.exibeAcessoFinanceiro();
        // Motivo?
        if(validaAcessoFinanceiro(matricula)) {
            System.out.println(Constantes.ACESSO_PERMITIDO);
        } else {
//            controladorPrincipal.retornaMotivoP
        }
    }
    
    public boolean validaAcessoFinanceiro(int matricula) {
        try {
            if(controladorPrincipal.encontraFuncionarioPelaMatricula(matricula)) {
                //se nao encontrar a matricula mostrar motivo
            }
            Funcionario funcionario = controladorPrincipal.encontraFuncionarioPelaMatricula(matricula);
            Cargo cargo = funcionario.getCargo();
            
            if(cargo.ehGerente()) return true;
            if(cargo.temAcessoAoFinanceiro()) {
                return validaHorarioAcesso(cargo);
            } else {
                System.out.println(Motivo.CARGO_SEM_ACESSO);
            }
        } catch (NullPointerException e) {
            System.out.println(Constantes.ACESSO_MATRICULA_INEXISTENTE);
        }
        return false;
    }
    
	//REVER
    public boolean validaHorarioAcesso(Cargo cargo) {
        Date horario = controladorPrincipal.horarioDoSistema();
        if(!horario.after(cargo.getHorarioInicio()) && horario.before(cargo.getHorarioFim())) {
            System.out.println(Motivo.HORARIO_NAO_PERMITIDO);
            return false;
        }
        return true;
    }
    
}
