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

        System.out.println(" --------- Gerenciar Funcionários ---------");
        System.out.println(" ------------------------------------------");
        System.out.println(" ----------------- Opções -----------------");
        System.out.println(" ------------------------------------------");
        System.out.println(" -------- 1- Cadastrar Funcionário --------");
        System.out.println(" -------- 2- Editar Funcionário -----------");
        System.out.println(" -------- 3- Listar Funcionários ----------");
        System.out.println(" -------- 4- Deletar Funcionário ----------");
        System.out.println(" -------- 5- Voltar ao menu principal -----");
        System.out.println(" ------------------------------------------");

        //colocar exceção para caso ele digite uma letra ou sei la p repetir
        opcao = teclado.nextInt();

        return opcao;
    }

    public void mensagemNovoFuncionario() {
        System.out.println("--------- Novo Funcionário ---------");
        System.out.println("------------------------------------");
    }

    public void mensagemEditaFuncionario() {
        System.out.println("--------- Editar Funcionário ---------");
        System.out.println("-------------------------------------");
    }

    public int exibeMenuEditaFuncionario() {

        int opcao;

        System.out.println(" O que você deseja fazer?");
        System.out.println(" -------- 1- Alterar Nome --------");
        System.out.println(" -------- 2- Alterar Matricula -----------");
        System.out.println(" -------- 3- Alterar a Data de Nascimento ----------");
        System.out.println(" -------- 4- Alterar o Telefone ----------");
        System.out.println(" -------- 5- Alterar o Salário -----");
        System.out.println(" -------- 6- Alterar o Cargo -----");
        System.out.println(" -------- 7- Voltar -----");

        opcao = teclado.nextInt();
        return opcao;
    }

    public void exibeFuncionarioSelecionado() {
        System.out.println(" Funcionário selecionado: ");
    }

    public void exibeFuncionario(int matricula, String nome, Date dataNascimento, int telefone, int salario, Cargo cargo) {
        System.out.println(" Matricula : " + matricula);
        System.out.println(" Nome: " + nome);
        System.out.println(" Data de Nascimento: " + dataNascimento);
        System.out.println(" Telefone: " + telefone);
        System.out.println(" Salario: " + salario);
        System.out.println(" Cargo: " + cargo);
        System.out.println(" ");
    }

    public void mensagemListaFuncionarios() {
        System.out.println("--------- Lista de Funcionários ---------");
        System.out.println(" ");
    }

    public void mensagemDeletaFuncionario() {
        System.out.println("--------- Deletar Funcionário ---------");
        System.out.println("-------------------------------------");

    }

    public int exibeMenuDeletaFuncionario() {
        int opcao;
        System.out.println("--------- Tem certeza que deseja excluir? ---------");
        System.out.println("--- 1. Sim ---------");
        System.out.println("--- 2. Não ---------");
        opcao = teclado.nextInt();
        return opcao;
    }

    public String pedeNome() {
        System.out.println(" Digite o nome do funcionário:");
        String nome = teclado.nextLine();
        //fazer as excecoes do nome
        return nome;
    }

    public int pedeMatricula() {
        System.out.println(" Digite a matrícula do funcionário:");
        int matricula = teclado.nextInt();
        //fazer as execoes da matricula
        return matricula;
    }

    public Date pedeDataNascimento() {
        System.out.println(" Digite a data de nascimento do funcionário:");
        String dataNascimento = teclado.nextLine();
        //fazer as excecoes da data e depois transformar em um string
        return
    }

    public int pedeTelefone() {
        System.out.println(" Digite o telefone do funcionário:");
        int telefone = teclado.nextInt();
        //tratar excecoes telefone
        return telefone;
    }

    public int pedeSalario() {
        System.out.println(" Digite o salário do funcionário:");
        int salario = teclado.nextInt();
        //tratar as excecoes do salario
        return salario;
    }

}
