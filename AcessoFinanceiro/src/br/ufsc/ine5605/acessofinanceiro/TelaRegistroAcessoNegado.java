/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author thiagobrezinski
 */
class TelaRegistroAcessoNegado {
    
    private Scanner teclado;
    private ControladorRegistroAcessoNegado owner;
    
    public TelaRegistroAcessoNegado(ControladorRegistroAcessoNegado owner) {
        this.owner = owner;
        this.teclado = new Scanner(System.in);
    }
    
    public int exibeMenuRelatorio() {
        int opcao = 0;
        boolean opcaoInvalida = true;
        System.out.println(Constantes.RELATORIO_ACESSO);
        while(opcaoInvalida) {
            try {
                System.out.println(Constantes.RELATORIO_ESCOLHA_FILTRO);
                System.out.println(Constantes.RELATORIO_FILTRO_MOTIVO);
                System.out.println(Constantes.RELATORIO_FILTRO_MATRICULA);
                System.out.println(Constantes.VOLTAR_MENU_PRINCIPAL_3);
                opcao = teclado.nextInt();
                opcaoInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.OPCAO_INVALIDA);
            }
        }
        return opcao;
    }
    
    public int exibeFiltroPorMotivo() {
        int opcao = 0;
        boolean opcaoInvalida = true;
        while(opcaoInvalida) {
            try {
                System.out.println(Constantes.RELATORIO_FILTRO_ESCOLHA_MOTIVO);
                System.out.println(Constantes.RELATORIO_FILTRO_MOTIVO_MATRICULA_INEXISTENTE);
                System.out.println(Constantes.RELATORIO_FILTRO_MOTIVO_CARGO_SEM_ACESSO);
                System.out.println(Constantes.RELATORIO_FILTRO_MOTIVO_HORARIO_NAO_PERMITIDO);
                System.out.println(Constantes.RELATORIO_FILTRO_MOTIVO_ACESSO_BLOQUEADO);
                System.out.println(Constantes.VOLTAR_MENU_PRINCIPAL_5);
                opcao = teclado.nextInt();
                opcaoInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.OPCAO_INVALIDA);
            }
        }
        return opcao;
    }
    
    public int exibeFiltroPorMatricula() {
        int matricula = 0;
        boolean matriculaInvalida = true;
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

	public int exibeRelatorioPorMotivo(ArrayList<RegistroAcessoNegado> registrosEncontrados, boolean encontrouRegistro, Motivo motivo) {
		int opcao = 0;
		if(!encontrouRegistro) {
			System.out.println(Constantes.RELATORIO_REGISTRO_NENHUM_ENCONTRADO);
		} else {
			int numeroRegistro = 0;
			switch(motivo) {
				case ACESSO_BLOQUEADO:
					System.out.println(Constantes.RELATORIO_ACESSO_MOTIVO_ACESSO_BLOQUEADO);
					break;
				case MATRICULA_INEXISTENTE:
					System.out.println(Constantes.RELATORIO_ACESSO_MOTIVO_MATRICULA_INEXISTENTE);
				case CARGO_SEM_ACESSO:
					System.out.println(Constantes.RELATORIO_ACESSO_MOTIVO_CARGO_SEM_ACESSO);
				case HORARIO_NAO_PERMITIDO:
					System.out.println(Constantes.RELATORIO_ACESSO_MOTIVO_HORARIO_NAO_PERMITIDO);
			}
			for(RegistroAcessoNegado registro : registrosEncontrados) {
				numeroRegistro++;
				System.out.println(Constantes.RELATORIO_REGISTRO_CABECALHO + numeroRegistro);
				System.out.println(Constantes.RELATORIO_REGISTRO_DATA + registro.getData());
				System.out.println(Constantes.RELATORIO_REGISTRO_MATRICULA + registro.getMatricula());
			}
			System.out.println(Constantes.VOLTAR_MENU_PRINCIPAL_1);
			boolean opcaoInvalida = true;
			while(opcaoInvalida) {
				try {
					System.out.println(Constantes.INSIRA_OPCAO);
					opcao = teclado.nextInt();
					if(opcao == 1) {
						opcaoInvalida = false;
					} else {
						System.out.println(Constantes.OPCAO_INEXISTENTE);
					}
				} catch (InputMismatchException e) {
					System.out.println(Constantes.OPCAO_INVALIDA);
				}
			}
		}
		return opcao;
	}
	
	public int exibeRelatorioPorMatricula(ArrayList<RegistroAcessoNegado> registrosEncontrados, int matricula, boolean encontrouRegistro) {
		int opcao = 0;
		if(!encontrouRegistro) {
			System.out.println(Constantes.RELATORIO_REGISTRO_NENHUM_ENCONTRADO);
		} else {
			int numeroRegistro = 0;
			System.out.println(Constantes.RELATORIO_ACESSO_MATRICULA + matricula);
			for(RegistroAcessoNegado registro : registrosEncontrados) {
				numeroRegistro++;
				System.out.println(Constantes.RELATORIO_REGISTRO_CABECALHO + numeroRegistro);
				System.out.println(Constantes.RELATORIO_REGISTRO_DATA + registro.getData());
				System.out.println(Constantes.RELATORIO_REGISTRO_MOTIVO + registro.getMotivo());
			}
			System.out.println(Constantes.VOLTAR_MENU_PRINCIPAL_1);
			boolean opcaoInvalida = true;
			while(opcaoInvalida) {
				try {
					System.out.println(Constantes.INSIRA_OPCAO);
					opcao = teclado.nextInt();
					if(opcao == 1) {
						opcaoInvalida = false;
					} else {
						System.out.println(Constantes.OPCAO_INEXISTENTE);
					}
				} catch (InputMismatchException e) {
					System.out.println(Constantes.OPCAO_INVALIDA);
				}
			}
		}
		return opcao;
	}

	public void exibeOpcaoInexistente() {
		System.out.println(Constantes.OPCAO_INEXISTENTE);
	}
    
	public int exibeMatriculaInexistente() {
		int opcao = 0;
		boolean opcaoInvalida = true;
		System.out.println(Constantes.MATRICULA_INEXISTENTE);
		while(opcaoInvalida) {
			try {
				System.out.println(Constantes.INSIRA_OPCAO);
				System.out.println(Constantes.TENTAR_NOVAMENTE);
				System.out.println(Constantes.VOLTAR_MENU_PRINCIPAL_2);
				opcao = teclado.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(Constantes.OPCAO_INVALIDA);
			}
		}
		return opcao;
	}
	
}
