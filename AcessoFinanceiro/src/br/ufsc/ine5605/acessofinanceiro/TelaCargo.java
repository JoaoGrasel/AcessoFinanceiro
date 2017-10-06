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
public class TelaCargo {

    private Scanner teclado;
    private ControladorCargo controlador;

    public TelaCargo(ControladorCargo owner) {
        this.controlador = owner;
        this.teclado = new Scanner(System.in);
    }

    /**
     * Exibe na tela o menu com as opcoes do CRUD do cargo (cadastrar, editar,
     * listar e deletar)
     */
    public void exibeMenuCargo() {
        System.out.println();
        System.out.println(Constantes.GERENCIAR_CARGO);
        System.out.println();
        System.out.println(Constantes.CADASTRAR_CARGO);
        System.out.println(Constantes.EDITAR_CARGO);
        System.out.println(Constantes.LISTAR_CARGOS);
        System.out.println(Constantes.DELETAR_CARGO);
        System.out.println(Constantes.VOLTAR_AO_MENU_PRINCIPAL);
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println();
    }

    /**
     * Pede que o usuario insira um numero correspondente a opcao que ele deseja
     * selecionar
     *
     * @return opcao inserida pelo usuario
     */
    public int pedeOpcao() {
        int opcao = 0;
        boolean opcaoInvalida = true;

        while (opcaoInvalida) {
            try {
                System.out.println();
                opcao = teclado.nextInt();
                opcaoInvalida = false;
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.OPCAO_INVALIDA);
                System.out.println();
            }
        }
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

    public void mensagemListaCargos() {
        System.out.println();
        System.out.println(Constantes.LISTA_DE_CARGOS);
        System.out.println();
    }

    public int opcaoInexistente() {

    }

    public void exibeCargo(int codigo, String nome, boolean ehGerente, boolean temAcessoAoFinanceiro) {
        System.out.println();
        System.out.println(Constantes.CODIGO + codigo);
        System.out.println(Constantes.NOME + nome);
        System.out.println(Constantes.EH_GERENTE + ehGerente);
        System.out.println(Constantes.TEM_ACESSO_AO_FINANCEIRO + temAcessoAoFinanceiro);
        System.out.println();
    }

    public void exibeCargoSelecionado() {
        System.out.println(Constantes.CARGO_SELECIONADO);
    }

}
