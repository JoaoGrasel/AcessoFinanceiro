/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
class TelaPrincipal {

    private Scanner teclado;
    private ControladorPrincipal controlador;

    public TelaPrincipal(ControladorPrincipal owner) {
        this.teclado = new Scanner(System.in);
        this.controlador = owner;
    }

    public void exibeMenuPrincipal() {
        System.out.println(Constantes.MENU_PRINCIPAL);
        System.out.println();
        System.out.println(Constantes.ACESSO_AO_FINANCEIRO);
        System.out.println(Constantes.GERENCIAR_FUNCIONARIOS);
        System.out.println(Constantes.GERENCIAR_CARGOS);
        System.out.println(Constantes.GERENCIAR_DATA);
        System.out.println(Constantes.EMITIR_RELATORIO);
        System.out.println();
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println();
    }

    public int pedeOpcao() {
        int opcao = 0;
        boolean opcaoValida = true;
        while (opcaoValida) {
            try {
                System.out.println();
                opcao = teclado.nextInt();
                teclado.nextLine();
                System.out.println();
                opcaoValida = false;

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.OPCAO_INVALIDA);
                teclado.nextLine();
            }
        }
        return opcao;
    }

    public void exibeOpcaoInexistente() {
        System.out.println();
        System.out.println(Constantes.OPCAO_INEXISTENTE);
        System.out.println();
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println();
    }

}
