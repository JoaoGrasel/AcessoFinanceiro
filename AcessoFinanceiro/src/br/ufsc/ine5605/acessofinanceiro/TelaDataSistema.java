/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author vladimir
 */
public class TelaDataSistema {

    private Scanner teclado;
    private ControladorDataSistema controlador;

    public TelaDataSistema(ControladorDataSistema owner) {
        this.teclado = new Scanner(System.in);
        this.controlador = owner;
    }

    public int exibeMenuDataSistema() {
        int opcao;
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.ALTERAR_DATA_E_HORA);
        System.out.println(Constantes.DATA_VOLTAR_MENU_PRINCIPAL);
        opcao = teclado.nextInt();
        return opcao;
    }

    public void exibeDataHoraSistema(Date dataSistema) {
        System.out.println(Constantes.HORA_ATUAL_DO_SISTEMA + dataSistema);
    }

    void pedeDataSistema() {
        System.out.println(Constantes.INSIRA_DATA_SISTEMA)
    }

}
