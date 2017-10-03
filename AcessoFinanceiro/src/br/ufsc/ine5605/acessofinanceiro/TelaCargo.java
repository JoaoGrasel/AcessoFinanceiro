/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class TelaCargo {
    private Scanner teclado;
    private ControladorCargo controlador;

    public TelaCargo(ControladorCargo owner) {
        this.controlador = owner;
        this.teclado = new Scanner(System.in);
    }

    public int exibeMenuCargo() {
        int opcao;
        
        System.out.println(Constantes.GERENCIAR_CARGO);
        System.out.println();
        System.out.println(Constantes.CADASTRAR_CARGO);
        System.out.println(Constantes.EDITAR_CARGO);
        System.out.println(Constantes.LISTAR_CARGOS);
        System.out.println(Constantes.DELETAR_CARGO);
        System.out.println(Constantes.VOLTAR_AO_MENU_PRINCIPAL);
        System.out.println();

        //colocar exceção para caso ele digite uma letra ou sei la p repetir
        opcao = teclado.nextInt();

        return opcao;
    }
    
    public void mensagemNovoCargo() {
        System.out.println(Constantes.MENSAGEM_NOVO_CARGO);
        System.out.println();
    }
    
    public void mensagemEditaCargo() {
        System.out.println(Constantes.TITULO_EDITAR_CARGO);
        System.out.println();
    }
    
    public int opcaoCargo
    
    public void exibeCargoSelecionado(){
        System.out.println(Constantes.CARGO_SELECIONADO);
    }
    
}
