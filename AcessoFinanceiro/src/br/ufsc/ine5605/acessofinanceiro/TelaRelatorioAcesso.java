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
 * @author thiagobrezinski
 */
class TelaRelatorioAcesso {
    
    private Scanner teclado;
    private ControladorRelatorioAcesso owner;
    
    public TelaRelatorioAcesso(ControladorRelatorioAcesso owner) {
        this.owner = owner;
        this.teclado = new Scanner(System.in);
    }
    
    public int exibeRelatorio() {
        int opcao = 0;
        boolean opcaoInvalida = true;
        
        System.out.println(Constantes.RELATORIO_ACESSO);
        
        while(opcaoInvalida) {
            try {
                System.out.println(Constantes.RELATORIO_ESCOLHA_FILTRO);
                System.out.println(Constantes.RELATORIO_FILTRO_MOTIVO);
                System.out.println(Constantes.RELATORIO_FILTRO_MATRICULA);
                opcao = teclado.nextInt();
                opcaoInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.RELATORIO_FILTRO_INVALIDO);
            }
        }
        return opcao;
    }
    
}
