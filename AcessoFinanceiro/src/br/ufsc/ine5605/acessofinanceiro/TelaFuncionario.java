/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author vladimir
 */
public class TelaFuncionario {

    private Scanner teclado;
    private ControladorFuncionario controlador;

    public TelaFuncionario(ControladorFuncionario owner) {
        this.controlador = owner;
        this.teclado = new Scanner(System.in);
    }

    public int exibeMenuFuncionario() {
        int opcao;

        System.out.println(Constantes.GERENCIAR_FUNCIONARIO);
        System.out.println();
        System.out.println(Constantes.CADASTRAR_FUNCIONARIO);
        System.out.println(Constantes.EDITAR_FUNCIONARIO);
        System.out.println(Constantes.LISTAR_FUNCIONARIOS);
        System.out.println(Constantes.DELETAR_FUNCIONARIO);
        System.out.println(Constantes.VOLTAR_AO_MENU_PRINCIPAL);
        System.out.println();

        //colocar exceção para caso ele digite uma letra ou sei la p repetir
        opcao = teclado.nextInt();

        return opcao;
    }

    public void mensagemNovoFuncionario() {
        System.out.println(Constantes.MENSAGEM_NOVO_USUARIO);
        System.out.println();
    }

    public void mensagemEditaFuncionario() {
        System.out.println(Constantes.TITULO_EDITAR_FUNCIONARIO);
        System.out.println();
    }

    public int opcaoCargoFuncionario() {
        int opcao;
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.USAR_CARGO_EXISTENTE);
        System.out.println(Constantes.CRIAR_CARGO_PARA_FUNCIONARIO);
        opcao = teclado.nextInt();
        return opcao;

    }

    public void listaCargo(int codigo, String nome) {
        System.out.println(Constantes.CODIGO_DO_CARGO + codigo);
        System.out.println(Constantes.NOME_DO_CARGO + nome);
        System.out.println();
    }

    public int exibeMenuEditaFuncionario() {

        int opcao;

        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.ALTERAR_NOME);
        System.out.println(Constantes.ALTERAR_MATRICULA);
        System.out.println(Constantes.ALTERAR_DATA_NASCIMENTO);
        System.out.println(Constantes.ALTERAR_TELEFONE);
        System.out.println(Constantes.ALTERAR_SALARIO);
        System.out.println(Constantes.ALTERAR_CARGO);
        System.out.println(Constantes.OPCAO_VOLTAR);

        opcao = teclado.nextInt();
        return opcao;
    }

    public void exibeFuncionarioSelecionado() {
        System.out.println(Constantes.FUNCIONARIO_SELECIONADO);
    }

    public void exibeFuncionario(int matricula, String nome, Date dataNascimento, int telefone, int salario, Cargo cargo) {
        System.out.println(Constantes.MATRICULA + matricula);
        System.out.println(Constantes.NOME + nome);
        System.out.println(Constantes.DATA_NASCIMENTO + dataNascimento);
        System.out.println(Constantes.TELEFONE + telefone);
        System.out.println(Constantes.SALARIO + salario);
        System.out.println(Constantes.CARGO + cargo);
        System.out.println();
    }

    public void mensagemListaFuncionarios() {
        System.out.println(Constantes.LISTA_DE_FUNCIONARIOS);
        System.out.println();
    }

    public void mensagemDeletaFuncionario() {
        System.out.println(Constantes.TITULO_DELETAR_FUNCIONARIO);
        System.out.println();

    }

    public int exibeMenuDeletaFuncionario() {
        int opcao;
        System.out.println(Constantes.TEM_CERTEZA_EXCLUIR);
        System.out.println(Constantes.SIM);
        System.out.println(Constantes.NAO);
        opcao = teclado.nextInt();
        return opcao;
    }

    public String pedeNome() {
        System.out.println(Constantes.DIGITE_NOME);
        String nome = teclado.nextLine();
        //fazer as excecoes do nome
        return nome;
    }

    public int pedeMatricula() {
        System.out.println(Constantes.DIGITE_MATRICULA);
        int matricula = teclado.nextInt();
        //fazer as execoes da matricula
        return matricula;
    }

    public Date pedeDataNascimento() {
        System.out.println(Constantes.DIGITE_DATA_NASCIMENTO);
        String dataNascimento = teclado.nextLine();
        //fazer as excecoes da data e depois transformar em um string
        return
    }

    public int pedeTelefone() {
        System.out.println(Constantes.DIGITE_TELEFONE);
        int telefone = teclado.nextInt();
        //tratar excecoes telefone
        return telefone;
    }

    public int pedeSalario() {
        System.out.println(Constantes.DIGITE_SALARIO);
        int salario = teclado.nextInt();
        //tratar as excecoes do salario
        return salario;
    }

    public int pedeCodigo() {
        System.out.println(Constantes.DIGITE_CODIGO);
        int codigo = teclado.nextInt();
        //tratar as excecoes do codigo
        return codigo;
    }

    public void mensagemErroMatriculaJaCadastrada() {
        System.out.println(Constantes.MATRICULA_JA_CADASTRADA);
    }

}
