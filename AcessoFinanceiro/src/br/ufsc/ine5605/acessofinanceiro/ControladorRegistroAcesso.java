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
                telaRegistroAcesso.exibeRelatorioMatriculaInexistente();
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
		if(controladorPrincipal.validaMatricula(matricula)) {
			ArrayList<RegistroAcesso> registrosEncontrados = new ArrayList<>();
			registrosEncontrados = encontraRegistrosPorMatricula(matricula);
			exibeRelatorioPorMatricula(registrosEncontrados, matricula);
		} else {
			trataRegistroNaoEncontrado();
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

	public void exibeRelatorioPorMatricula(ArrayList<RegistroAcesso> registrosEncontrados, int matricula) {
		int opcao = 0;
		opcao = telaRegistroAcesso.exibeRelatorioPorMatricula(registrosEncontrados, matricula);
		if(opcao == 1) {
			controladorPrincipal.exibeMenuPrincipal();
		}
		//REVER AQUI
	}
    
}
