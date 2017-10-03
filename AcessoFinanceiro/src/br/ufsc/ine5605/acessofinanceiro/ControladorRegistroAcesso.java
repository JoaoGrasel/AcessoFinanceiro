/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorRegistroAcesso {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaRegistroAcesso telaRegistroAcesso;
	private ArrayList<RegistroAcesso> registros;
    
    public ControladorRegistroAcesso() {
        this.controladorPrincipal = new ControladorPrincipal();
        this.telaRegistroAcesso = new TelaRegistroAcesso(this);
		this.registros = new ArrayList<>();
    }
    
    public void exibeRelatorio() {
        int filtro = 0;
        filtro = telaRegistroAcesso.exibeMenuRelatorio();
        switch(filtro) {
            case 1:
                exibeFiltroPorMotivo();
                break;
            case 2:
                exibeFiltroPorMatricula();
                break;
            case 3:
                //volta para o menu principal
                break;
            default:
                System.out.println(Constantes.OPCAO_INEXISTENTE);
                exibeRelatorio();
        }
    }

    public void exibeFiltroPorMotivo() {
        int opcao = telaRegistroAcesso.exibeFiltroPorMotivo();
        switch(opcao) {
            case 1:
                exibeRelatorioMatriculaInexistente();
                break;
            case 2:
                telaRegistroAcesso.exibeRelatorioCargoSemAcesso();
                break;
            case 3:
                telaRegistroAcesso.exibeRelatorioHorarioNaoPermitido();
                break;
            case 4:
                telaRegistroAcesso.exibeRelatorioAcessoBloqueado();
                break;
            default:
				System.out.println(Constantes.OPCAO_INEXISTENTE);
                exibeFiltroPorMotivo();
                break;
        }
    }

    public void exibeFiltroPorMatricula() {
        int matricula = telaRegistroAcesso.exibeFiltroPorMatricula();
		boolean nenhumRegistroEncontrado = false;
		if(controladorPrincipal.validaMatricula(matricula)) {
			ArrayList<RegistroAcesso> registrosEncontrados = new ArrayList<>();
			registrosEncontrados = encontraRegistrosPorMatricula(matricula);
			if(registrosEncontrados.isEmpty()) nenhumRegistroEncontrado = true;
			exibeRelatorioPorMatricula(registrosEncontrados, matricula, nenhumRegistroEncontrado);
		} else {
			exibeMatriculaInexistente();
		}
    }

	public ArrayList<RegistroAcesso> encontraRegistrosPorMatricula(int matricula) {
		ArrayList<RegistroAcesso> registrosEncontrados = new ArrayList<>();
		for(RegistroAcesso registro : this.registros) {
			if(registro.getMatricula() == matricula) {
				registrosEncontrados.add(registro);
			}
		}
		return registrosEncontrados;
	}

	public void exibeRelatorioPorMatricula(ArrayList<RegistroAcesso> registrosEncontrados, int matricula, boolean nenhumRegistroEncontrado) {
		int opcao = 0;
		opcao = telaRegistroAcesso.exibeRelatorioPorMatricula(registrosEncontrados, matricula, nenhumRegistroEncontrado);
		if(opcao == 1) {
			controladorPrincipal.exibeMenuPrincipal();
		}
	}

	public void exibeMatriculaInexistente() {
		int opcao = 0;
		opcao = telaRegistroAcesso.exibeMatriculaInexistente();
		if(opcao == 1) {
			exibeFiltroPorMatricula();
		} else if(opcao == 2) {
			controladorPrincipal.exibeMenuPrincipal();
		}
	}

	public void exibeRelatorioMatriculaInexistente() {
		ArrayList<RegistroAcesso> registrosEncontrados = new ArrayList<>();
		boolean nenhumRegistroEncontrado = false;
		for(RegistroAcesso registro : this.registros) {
			if(registro.getMotivo() == Motivo.MATICULA_INEXISTENTE) {
				registrosEncontrados.add(registro);
			}
		}
		if(registrosEncontrados.isEmpty()) nenhumRegistroEncontrado = true;
		telaRegistroAcesso.exibeRelatorioMatriculaInexistente(registrosEncontrados, nenhumRegistroEncontrado);
	}
	
}
