/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorAcesso {
	
    private TelaAcesso telaAcesso;
    
    public ControladorAcesso() {
        this.telaAcesso = new TelaAcesso(this);
    }
    
    public void acessaFinanceiro() {
        int matricula = 0;
        matricula = telaAcesso.exibeAcessoFinanceiro();
        if(validaAcessoFinanceiro(matricula)) {
			telaAcesso.exibeAcessoPermitido();
		} else {
			trataNovaTentativa();
		}
    }
    
    public boolean validaAcessoFinanceiro(int matricula) {
		Date dataAtual = ControladorPrincipal.getInstance().getDataSistema();
        try {
            Funcionario funcionario = ControladorPrincipal.getInstance().encontraFuncionarioPelaMatricula(matricula);
			ArrayList<RegistroAcessoNegado> registrosHorarioNaoPermitido;
			registrosHorarioNaoPermitido = ControladorPrincipal.getInstance().encontraRegistrosHorarioNaoPermitidoPelaMatricula(matricula);
			if(registrosHorarioNaoPermitido.size() > 3) {
				ControladorPrincipal.getInstance().novoRegistroAcessoNegado(dataAtual, matricula, Motivo.ACESSO_BLOQUEADO);
				telaAcesso.exibeAcessoNegadoAcessoBloqueado();
				return false;
			}
			Acesso acesso = new Acesso(dataAtual, matricula);
			return acesso.validaAcesso(acesso, funcionario, dataAtual);
        } catch (NullPointerException e) {
			ControladorPrincipal.getInstance().novoRegistroAcessoNegado(dataAtual, matricula, Motivo.MATRICULA_INEXISTENTE);
			telaAcesso.exibeAcessoNegadoMatriculaInexistente();
        }
        return false;
    }

	public void trataNovaTentativa() {
		int opcao = 0;
		opcao = telaAcesso.exibeNovaTentativa();
		if(opcao == 1) {
			acessaFinanceiro();
		} else {
			ControladorPrincipal.getInstance().exibeMenuPrincipal();
		}
	}

	public void exibeAcessoNegadoCargoSemAcesso() {
		telaAcesso.exibeAcessoNegadoCargoSemAcesso();
	}

	public void exibeAcessoNegadoHorarioNaoPermitido() {
		telaAcesso.exibeAcessoNegadoHorarioNaoPermitido();
	}

	public void novoRegistroAcessoNegado(Date data, int matricula, Motivo motivo) {
		ControladorPrincipal.getInstance().novoRegistroAcessoNegado(data, matricula, motivo);
	}
    
}
