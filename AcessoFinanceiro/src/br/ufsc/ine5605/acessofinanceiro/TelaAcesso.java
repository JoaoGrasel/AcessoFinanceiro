/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author thiagobrezinski
 */
public class TelaAcesso {
    
    private Scanner teclado;
    private ControladorAcesso owner;
    
    public TelaAcesso(ControladorAcesso owner) {
        this.teclado = new Scanner(System.in);
        this.owner = owner;
    }
    
    public int exibeAcessoFinanceiro(){
        int matricula = 0;
        boolean matriculaInvalida = true;
        System.out.println(Constantes.ACESSO_FINANCEIRO);
        while(matriculaInvalida) {
            try {
                System.out.println(Constantes.INSIRA_MATRICULA);
                matricula = teclado.nextInt();
                matriculaInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.MATRICULA_INVALIDA);
            }
        }
        return matricula;
    }

	public void exibeAcessoPermitido() {
		System.out.println(Constantes.ACESSO_PERMITIDO);
	}

	public void exibeAcessoNegadoMatriculaInexistente() {
		System.out.println(Constantes.ACESSO_MATRICULA_INEXISTENTE);
	}

	public void exibeAcessoNegadoCargoSemAcesso() {
		System.out.println(Constantes.ACESSO_NEGADO_CARGO_SEM_ACESSO);
	}

	public void exibeAcessoNegadoHorarioNaoPermitido() {
		System.out.println(Motivo.HORARIO_NAO_PERMITIDO);
	}

	public void exibeAcessoNegadoAcessoBloqueado() {
		System.out.println(Constantes.ACESSO_NEGADO_ACESSO_BLOQUEADO);
	}
    
	public int exibeNovaTentativa() {
		int opcao = 0;
		boolean opcaoInvalida = true;
		while(opcaoInvalida) {
			try {
				System.out.println(Constantes.INSIRA_OPCAO);
				System.out.println(Constantes.TENTAR_NOVAMENTE);
				System.out.println(Constantes.VOLTAR_MENU_PRINCIPAL_2);
				opcao = teclado.nextInt();
				opcaoInvalida = false;
			} catch (InputMismatchException e) {
				System.out.println(Constantes.OPCAO_INVALIDA);
			}
		}
		return opcao;
	}
	
}
