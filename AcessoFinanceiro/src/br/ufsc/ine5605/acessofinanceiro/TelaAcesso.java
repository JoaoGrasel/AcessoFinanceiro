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
    
	/**
	 * Exibe o menu para insercao da matricula para tentativa de acesso ao
	 * financeiro e trata se a matricula inserida eh realmente um inteiro.
	 * 
	 * @return int matricula usada para a tentativa de acesso
	 */
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
				teclado.next();
                System.out.println(Constantes.MATRICULA_INVALIDA);
            }
        }
        return matricula;
    }

	/**
	 * Imprime na tela que o acesso ao financeiro foi permitido.
	 */
	public void exibeAcessoPermitido() {
		System.out.println(Constantes.ACESSO_PERMITIDO);
	}

	/**
	 * Imprime na tela que o acesso ao financeiro foi negado pois a matricula
	 * nao existe.
	 */
	public void exibeAcessoNegadoMatriculaInexistente() {
		System.out.println(Constantes.ACESSO_MATRICULA_INEXISTENTE);
	}

	/**
	 * Imprime na tela que o acesso ao financeiro foi negado pois o cargo nao
	 * tem acesso.
	 */
	public void exibeAcessoNegadoCargoSemAcesso() {
		System.out.println(Constantes.ACESSO_NEGADO_CARGO_SEM_ACESSO);
	}

	/**
	 * Imprime na tela que o acesso ao financeiro foi negado pois o horario
	 * nao eh permitido para o cargo do funcionario tentando o acesso.
	 */
	public void exibeAcessoNegadoHorarioNaoPermitido() {
		System.out.println(Motivo.HORARIO_NAO_PERMITIDO);
	}

	/**
	 * Imprime na tela que o acesso ao financeiro foi negado pois o acesso do
	 * funcionario foi bloqueado.
	 */
	public void exibeAcessoNegadoAcessoBloqueado() {
		System.out.println(Constantes.ACESSO_NEGADO_ACESSO_BLOQUEADO);
	}
    
	/**
	 * Exibe um menu para o usuario escolher a opcao desejada, para tentar
	 * inserir a matricula novamente ou voltar ao menu principal.
	 * 
	 * @return int opcao escolhida pelo usuario
	 */
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
