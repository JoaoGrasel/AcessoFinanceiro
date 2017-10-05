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
public class ControladorRegistroAcessoNegado {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaRegistroAcessoNegado telaRegistroAcessoNegado;
	private ArrayList<RegistroAcessoNegado> registros;
    
    public ControladorRegistroAcessoNegado() {
        this.controladorPrincipal = new ControladorPrincipal();
        this.telaRegistroAcessoNegado = new TelaRegistroAcessoNegado(this);
		this.registros = new ArrayList<>();
    }
    
    public void exibeRelatorio() {
        int filtro = 0;
        filtro = telaRegistroAcessoNegado.exibeMenuRelatorio();
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
        int opcao = telaRegistroAcessoNegado.exibeFiltroPorMotivo();
        switch(opcao) {
            case 1:
                exibeRelatorioMatriculaInexistente();
                break;
            case 2:
                telaRegistroAcessoNegado.exibeRelatorioCargoSemAcesso();
                break;
            case 3:
                telaRegistroAcessoNegado.exibeRelatorioHorarioNaoPermitido();
                break;
            case 4:
                telaRegistroAcessoNegado.exibeRelatorioAcessoBloqueado();
                break;
            default:
				System.out.println(Constantes.OPCAO_INEXISTENTE);
                exibeFiltroPorMotivo();
                break;
        }
    }

    public void exibeFiltroPorMatricula() {
        int matricula = telaRegistroAcessoNegado.exibeFiltroPorMatricula();
		boolean nenhumRegistroEncontrado = false;
		if(controladorPrincipal.matriculaExiste(matricula)) {
			ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
			registrosEncontrados = encontraRegistrosPorMatricula(matricula);
			if(registrosEncontrados.isEmpty()) nenhumRegistroEncontrado = true;
			exibeRelatorioPorMatricula(registrosEncontrados, matricula, nenhumRegistroEncontrado);
		} else {
			exibeMatriculaInexistente();
		}
    }

	public ArrayList<RegistroAcessoNegado> encontraRegistrosPorMatricula(int matricula) {
		ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMatricula() == matricula) {
				registrosEncontrados.add(registro);
			}
		}
		return registrosEncontrados;
	}

	public void exibeRelatorioPorMatricula(ArrayList<RegistroAcessoNegado> registrosEncontrados, int matricula, boolean nenhumRegistroEncontrado) {
		int opcao = 0;
		opcao = telaRegistroAcessoNegado.exibeRelatorioPorMatricula(registrosEncontrados, matricula, nenhumRegistroEncontrado);
		if(opcao == 1) {
			controladorPrincipal.exibeMenuPrincipal();
		}
	}

	public void exibeMatriculaInexistente() {
		int opcao = 0;
		opcao = telaRegistroAcessoNegado.exibeMatriculaInexistente();
		if(opcao == 1) {
			exibeFiltroPorMatricula();
		} else if(opcao == 2) {
			controladorPrincipal.exibeMenuPrincipal();
		}
	}

	public void exibeRelatorioMatriculaInexistente() {
		ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
		boolean nenhumRegistroEncontrado = false;
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMotivo() == Motivo.MATRICULA_INEXISTENTE) {
				registrosEncontrados.add(registro);
			}
		}
		if(registrosEncontrados.isEmpty()) nenhumRegistroEncontrado = true;
		telaRegistroAcessoNegado.exibeRelatorioMatriculaInexistente(registrosEncontrados, nenhumRegistroEncontrado);
	}

	public void novoRegistroAcessoNegado(Date data, int matricula, Motivo motivo) {
		RegistroAcessoNegado registro = new RegistroAcessoNegado(data, matricula, motivo);
		this.registros.add(registro);
	}

	ArrayList<RegistroAcessoNegado> encontraRegistrosHorarioNaoPermitidoPelaMatricula(int matricula) {
		ArrayList<RegistroAcessoNegado> registrosHorarioNaoPermitido = new ArrayList<>();
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMatricula() == matricula && registro.getMotivo() == Motivo.HORARIO_NAO_PERMITIDO)
				registrosHorarioNaoPermitido.add(registro);
		}
		return registrosHorarioNaoPermitido;
	}
	
}
