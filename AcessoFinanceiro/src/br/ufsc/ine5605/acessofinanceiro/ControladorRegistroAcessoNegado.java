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
    
    private TelaRegistroAcessoNegado telaRegistroAcessoNegado;
	private ArrayList<RegistroAcessoNegado> registros;
    
    public ControladorRegistroAcessoNegado() {
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
                ControladorPrincipal.getInstance().exibeMenuPrincipal();
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
                exibeRelatorioPorMotivo(Motivo.MATRICULA_INEXISTENTE);
                break;
            case 2:
                exibeRelatorioPorMotivo(Motivo.CARGO_SEM_ACESSO);
                break;
            case 3:
                exibeRelatorioPorMotivo(Motivo.HORARIO_NAO_PERMITIDO);
                break;
            case 4:
                exibeRelatorioPorMotivo(Motivo.ACESSO_BLOQUEADO);
                break;
			case 5:
				ControladorPrincipal.getInstance().exibeMenuPrincipal();
            default:
				telaRegistroAcessoNegado.exibeOpcaoInexistente();
                exibeFiltroPorMotivo();
                break;
        }
    }

    public void exibeFiltroPorMatricula() {
        int matricula = telaRegistroAcessoNegado.exibeFiltroPorMatricula();
		boolean encontrouRegistro = false;
		if(ControladorPrincipal.getInstance().matriculaExiste(matricula)) {
			ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
			registrosEncontrados = encontraRegistrosPorMatricula(matricula);
			if(!registrosEncontrados.isEmpty()) encontrouRegistro = true;
			exibeRelatorioPorMatricula(registrosEncontrados, matricula, encontrouRegistro);
		} else {
			exibeMatriculaInexistente();
		}
    }

	public void exibeRelatorioPorMotivo(Motivo motivo) {
		boolean encontrouRegistro = false;
		int opcao = 0;
		
		ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
		registrosEncontrados = encontraRegistrosPorMotivo(motivo);
		if(!registrosEncontrados.isEmpty()) encontrouRegistro = true;
		opcao = telaRegistroAcessoNegado.exibeRelatorioPorMotivo(registrosEncontrados, encontrouRegistro, motivo);
		if(opcao == 1) ControladorPrincipal.getInstance().exibeMenuPrincipal();
	}
	
	public void exibeRelatorioPorMatricula(ArrayList<RegistroAcessoNegado> registrosEncontrados, int matricula, boolean encontrouRegistro) {
		int opcao = 0;
		opcao = telaRegistroAcessoNegado.exibeRelatorioPorMatricula(registrosEncontrados, matricula, encontrouRegistro);
		if(opcao == 1) {
			ControladorPrincipal.getInstance().exibeMenuPrincipal();
		}
	}
	
	public ArrayList<RegistroAcessoNegado> encontraRegistrosPorMotivo(Motivo motivo) {
		ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMotivo() == motivo) {
				registrosEncontrados.add(registro);
			}
		}
		return registrosEncontrados;
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

	public ArrayList<RegistroAcessoNegado> encontraRegistrosHorarioNaoPermitidoPelaMatricula(int matricula) {
		ArrayList<RegistroAcessoNegado> registrosHorarioNaoPermitido = new ArrayList<>();
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMatricula() == matricula && registro.getMotivo() == Motivo.HORARIO_NAO_PERMITIDO)
				registrosHorarioNaoPermitido.add(registro);
		}
		return registrosHorarioNaoPermitido;
	}
	
	public void novoRegistroAcessoNegado(Date data, int matricula, Motivo motivo) {
		RegistroAcessoNegado registro = new RegistroAcessoNegado(data, matricula, motivo);
		this.registros.add(registro);
	}
	
	public void exibeMatriculaInexistente() {
		int opcao = 0;
		opcao = telaRegistroAcessoNegado.exibeMatriculaInexistente();
		if(opcao == 1) {
			exibeFiltroPorMatricula();
		} else if(opcao == 2) {
			ControladorPrincipal.getInstance().exibeMenuPrincipal();
		}
	}
	
}
