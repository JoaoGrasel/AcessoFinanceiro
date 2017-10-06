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
    
	/**
	 * Solicita a tela que exiba o menu para selecao de filtro para emissao do
	 * relatorio e trata a opcao recebida.
	 */
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

	/**
	 * Solicita a tela que exiba os motivos existentes que o usuario possa
	 * escolher para filtrar a emissao do relatorio e trata a opcao recebida.
	 */
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

	/**
	 * Solicita a exibicao do input para a matricula e da existencia desta,
	 * procura os registros de acesso negado com esta matricula e solicita a
	 * exibicao do relatorio destes registros.
	 */
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

	/**
	 * Encontra os registros de acesso negado com o motivo recebido e solicita
	 * que a tela um relatorio destes.
	 * 
	 * @param motivo usado para encontrar todos os registros que tenham este
	 * mesmo motivo.
	 */
	public void exibeRelatorioPorMotivo(Motivo motivo) {
		boolean encontrouRegistro = false;
		int opcao = 0;
		
		ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
		registrosEncontrados = encontraRegistrosPorMotivo(motivo);
		if(!registrosEncontrados.isEmpty()) encontrouRegistro = true;
		opcao = telaRegistroAcessoNegado.exibeRelatorioPorMotivo(registrosEncontrados, encontrouRegistro, motivo);
		if(opcao == 1) ControladorPrincipal.getInstance().exibeMenuPrincipal();
	}
	
	/**
	 * Solicita a exibicao da relatorio dos registros encontrados com a matricula
	 * inserida e trata o retorno do usuario ao menu principal.
	 * 
	 * @param registrosEncontrados registros de acesso negado da matricula inserida
	 * @param matricula matricula inserida para emissao do relatorio
	 * @param encontrouRegistro recebe true se o array registrosEncontrados nao 
	 * estiver vazio e false se estiver
	 */
	public void exibeRelatorioPorMatricula(ArrayList<RegistroAcessoNegado> registrosEncontrados, int matricula, boolean encontrouRegistro) {
		int opcao = 0;
		opcao = telaRegistroAcessoNegado.exibeRelatorioPorMatricula(registrosEncontrados, matricula, encontrouRegistro);
		if(opcao == 1) {
			ControladorPrincipal.getInstance().exibeMenuPrincipal();
		}
	}
	
	/**
	 * Encontra na colecao de registros de acesso negado todos que possuirem
	 * como motivo o recebido.
	 * 
	 * @param motivo desejado para encontrar os registros
	 * @return ArrayList de registros encontrados
	 */
	public ArrayList<RegistroAcessoNegado> encontraRegistrosPorMotivo(Motivo motivo) {
		ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMotivo() == motivo) {
				registrosEncontrados.add(registro);
			}
		}
		return registrosEncontrados;
	}
	
	/**
	 * Encontra na colecao de registros de acesso negado todos que possuirem
	 * como matricula a recebida.
	 * 
	 * @param matricula desejada para encontrar os registros
	 * @return ArrayList de registros encontrados
	 */
	public ArrayList<RegistroAcessoNegado> encontraRegistrosPorMatricula(int matricula) {
		ArrayList<RegistroAcessoNegado> registrosEncontrados = new ArrayList<>();
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMatricula() == matricula) {
				registrosEncontrados.add(registro);
			}
		}
		return registrosEncontrados;
	}

	/**
	 * Encontra na colecao de registros de acesso negado todos que possuirem
	 * como motivo horario nao permitido e como matricula a recebida.
	 * 
	 * @param matricula desejada para encontrar os registros
	 * @return ArrayList de registros encontrados
	 */
	public ArrayList<RegistroAcessoNegado> encontraRegistrosHorarioNaoPermitidoPelaMatricula(int matricula) {
		ArrayList<RegistroAcessoNegado> registrosHorarioNaoPermitido = new ArrayList<>();
		for(RegistroAcessoNegado registro : this.registros) {
			if(registro.getMatricula() == matricula && registro.getMotivo() == Motivo.HORARIO_NAO_PERMITIDO)
				registrosHorarioNaoPermitido.add(registro);
		}
		return registrosHorarioNaoPermitido;
	}
	
	/**
	 * Instancia um novo RegistroAcessoNegado e inclui na colecao de registros.
	 * 
	 * @param data data do acesso negado
	 * @param matricula matricula do funcionario tentando o acesso
	 * @param motivo motivo pelo qual o funcionario teve o acesso negado
	 */
	public void novoRegistroAcessoNegado(Date data, int matricula, Motivo motivo) {
		RegistroAcessoNegado registro = new RegistroAcessoNegado(data, matricula, motivo);
		this.registros.add(registro);
	}
	
	/**
	 * Solicita a tela a exibicao de que a matricula inserida nao existe e trata
	 * a opcao recebida para tentar novamente ou voltar ao menu principal.
	 */
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
