/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Scanner;

/**
 *
 * @author thiagobrezinski
 */
public class TelaAcesso {
    
    private Scanner teclado;
    private ControladorAcesso owner;
    
    public TelaAcesso() {
        this.teclado = new Scanner(System.in);
        this.owner = new ControladorAcesso();
    }
    
    public void exibeAcessoFinanceiro() {
        int matricula = 0;
        
        System.out.println("+-+-+-+ Acesso ao financeiro +-+-+-+");
        System.out.println("Insira sua matrícula: ");
        
        if(teclado.hasNextInt()) matricula = teclado.nextInt();
        if(Character.isDigit(matricula)) {
            Funcionario funcionario = owner.encontraFuncionarioPelaMatricula(matricula);
            owner.validaAcessoFinanceiro(funcionario);
        } else {
            
        }
        
        
    }
    
}
