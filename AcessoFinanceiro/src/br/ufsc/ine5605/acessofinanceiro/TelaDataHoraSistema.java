/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vladimir
 */
public class TelaDataHoraSistema {

    private Scanner teclado;
    private ControladorDataSistema controlador;

    public TelaDataHoraSistema(ControladorDataSistema owner) {
        this.teclado = new Scanner(System.in);
        this.controlador = owner;
    }

    public void exibeDataHoraSistema(Date dataHoraSistema) {
        System.out.println();
        System.out.println(Constantes.HORA_ATUAL_DO_SISTEMA + dataHoraSistema);
        System.out.println();
    }

    public void exibeMenuDataHoraSistema() {
        System.out.println();
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.ALTERAR_DATA_E_HORA);
        System.out.println(Constantes.DATA_VOLTAR_MENU_PRINCIPAL);
        System.out.println();
    }

    public String pedeDataHoraSistema() {
        System.out.println();
        System.out.println(Constantes.INSIRA_DATA_SISTEMA);
        String dataEHora = teclado.nextLine();
        return dataEHora;

    }

    public int pedeOpcao() {
        int opcao = 0;
        boolean opcaoInvalida = true;

        while (opcaoInvalida) {
            try {
                System.out.println();
                opcao = teclado.nextInt();
                System.out.println();
                opcaoInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.OPCAO_INVALIDA);
                System.out.println();
            }

        }
        return opcao;
    }

    public void opcaoInexistente() {
        System.out.println();
        System.out.println(Constantes.OPCAO_INEXISTENTE);
        System.out.println();
    }

    public void mensagemDataInvalida() {
        System.out.println();
        System.out.println(Constantes.DATA_HORA_SISTEMA_INVALIDOS);
        System.out.println();
    }

    void exibeConfirmacaoDataHoraSistema() {
        System.out.println();
        System.out.println(Constantes.CONFIRMA_ALTERACAO_DATA_HORA);
        System.out.println(Constantes.SIM);
        System.out.println(Constantes.NAO);
        System.out.println();
    }

    void mensagemDataHoraAtualizadosSucesso() {
        System.out.println();
        System.out.println(Constantes.DATA_HORA_ATUALIZADOS_SUCESSO);
        System.out.println();
    }

    void mensagemDataHoraNaoAtualizados() {
        System.out.println();
        System.out.println(Constantes.DATA_HORA_NAO_ATUALIZADOS);
        System.out.println();
    }

}
