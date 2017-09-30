/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorRelatorioAcesso {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaRelatorioAcesso telaRelatorioAcesso;
    
    public ControladorRelatorioAcesso() {
        this.controladorPrincipal = new ControladorPrincipal();
        this.telaRelatorioAcesso = new TelaRelatorioAcesso(this);
    }
    
    public void exibeRelatorio() {
        int filtro = 0;
        filtro = telaRelatorioAcesso.exibeMenuRelatorio();
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
        int opcao = telaRelatorioAcesso.exibeFiltroPorMotivo();
        switch(opcao) {
            case 1:
                telaRelatorioAcesso.exibeRelatorioMatriculaInexistente();
                break;
            case 2:
                telaRelatorioAcesso.exibeRelatorioCargoSemAcesso();
                break;
            case 3:
                telaRelatorioAcesso.exibeRelatorioHorarioNaoPermitido();
                break;
            case 4:
                telaRelatorioAcesso.exibeRelatorioAcessoBloqueado();
                break;
            default:
                exibeFiltroPorMotivo();
                break;
        }
    }

    public void exibeFiltroPorMatricula() {
        int matricula = telaRelatorioAcesso.exibeFiltroPorMatricula();
		if(controladorPrincipal.validaMatricula(matricula)) {
			encontraRegistrosPorMatricula(matricula);
		} else {
			trataRegistroNaoEncontrado();
		}
    }

	public void encontraRegistrosPorMatricula(int matricula) {
		//encontrar registros por matricula
		//quem apagar o model Relatorio?
		//botar array de registros aqui
	}
    
}
