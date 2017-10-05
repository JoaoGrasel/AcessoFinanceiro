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
        System.out.println(Constantes.HORA_ATUAL_DO_SISTEMA + dataHoraSistema);
        System.out.println();
    }

    public void exibeMenuDataHoraSistema() {
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.ALTERAR_DATA_E_HORA);
        System.out.println(Constantes.DATA_VOLTAR_MENU_PRINCIPAL);
    }

    public String pedeDataHoraSistema() {
        System.out.println(Constantes.INSIRA_DATA_SISTEMA);
        String dataEHora = teclado.nextLine();
        return dataEHora;

    }

    public int pedeOpcao() {
        int opcao = 0;
        boolean opcaoInvalida = true;

        while (opcaoInvalida) {
            try {
                opcao = teclado.nextInt();
                opcaoInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.OPCAO_INVALIDA);
            }

        }
        return opcao;
    }

    public void opcaoInexistente() {
        System.out.println(Constantes.OPCAO_INEXISTENTE);
    }

}
