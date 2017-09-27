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
public class TelaAcesso {
    
    private Scanner teclado;
    private ControladorAcesso owner;
    
    public TelaAcesso(ControladorAcesso owner) {
        this.teclado = new Scanner(System.in);
        this.owner = owner;
    }
    
    public int exibeAcessoFinanceiro(){
        int matricula = 0;
        boolean matriculaInvalida = true;
        
        System.out.println(Constantes.ACESSO_FINANCEIRO);
        System.out.println(Constantes.INSIRA_MATRICULA);
        
        while(matriculaInvalida) {
            try {
                matricula = teclado.nextInt();
                matriculaInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.MATRICULA_INVALIDA);
            }
        }
        return matricula;
    }
    
}
