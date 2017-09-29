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

    public void exibeMenuCargo() {

        int opcao = 0;

        System.out.println(" ------------ Gerenciar Cargos ------------");
        System.out.println(" ------------------------------------------");
        System.out.println(" ----------------- Opções -----------------");
        System.out.println(" ------------------------------------------");
        System.out.println(" -------- 1- Cadastrar Cargo --------------");
        System.out.println(" -------- 2- Editar Cargo -----------------");
        System.out.println(" -------- 3- Listar Cargos ----------------");
        System.out.println(" -------- 4- Deletar Cargo ----------------");
        System.out.println(" -------- 5- Voltar ao menu principal -----");
        System.out.println(" ------------------------------------------");

        opcao = teclado.nextInt();

        switch (opcao) {
            case 1:
                incluiCargo();
                break;
            case 2:
                editaCargo();
                break;
            case 3:
                listaCargos();
                break;
            case 4:
                excluiCargo();
                break;
            case 5:
                controlador.voltaMenuPrincipal();
                break;
        }

    }

    public void incluiCargo() {
        //mudar para atender as necessidades do cargo.
        System.out.println("--------- Novo Cargo ---------");
        System.out.println("------------------------------------");
        System.out.println(" Digite o nome do cargo:");
        String nome = teclado.nextLine();
        //deletar, pq não tem matricula em cargo.
        System.out.println(" Digite a matrícula do funcionário:");
        String matricula = teclado.nextLine();
        for (controlador.verificaMatricula(matricula)                 ) {
            System.out.println(" Digite a matrícula do funcionário:");
            matricula = teclado.nextLine();
        }

        System.out.println(" Digite a data de nascimento do funcionário:");
        String dataNascimento = teclado.nextLine();
        System.out.println(" Digite o salário do funcionário:");
        String salario = teclado.nextLine();
        System.out.println(" Escolha o cargo do funcionário:");

    }

    public void editaCargo() {

        int opcao = 0;

        System.out.println("--------- Editar Cargo ---------");
        System.out.println("-------------------------------------");
        System.out.println(" Digite o nome do cargo:");
        String nome = teclado.nextLine();

        Cargo cargo = controlador.findCargoByNome(nome);

        System.out.println(" Cargo selecionado:");
        System.out.println(cargo.getNome());
        System.out.println(cargo.getMatricula());
        System.out.println(cargo.getCargo().getNome());

        System.out.println(" O que você deseja fazer?");
        System.out.println(" -------- 1- Alterar Nome --------");
        System.out.println(" -------- 2- Alterar Matricula -----------");
        System.out.println(" -------- 3- Alterar a Data de Nascimento ----------");
        System.out.println(" -------- 4- Alterar o Telefone ----------");
        System.out.println(" -------- 5- Alterar o Salário -----");
        System.out.println(" -------- 6- Alterar o Cargo -----");
        System.out.println(" -------- 7- Voltar -----");

        switch (opcao) {
            case 1:
                System.out.println(" Digite o nome do funcionário:");
                String novoNome = teclado.nextLine();
                funcionario.setNome(novoNome);
                break;
            case 2:
                System.out.println(" Digite a matricula do funcionário:");
                String novaMatricula = teclado.nextLine();
                funcionario.setMatricula(novaMatricula);
            case 3:
                System.out.println(" Digite a data de nascimento do funcionário:");
                String novaDataNascimento = teclado.nextLine();
                funcionario.setDataNascimento(novaDataNascimento);
                break;
            case 4:
                System.out.println(" Digite o telefone do funcionário:");
                String novoTelefone = teclado.nextLine();
                funcionario.setTelefone(novoTelefone);
                break;
            case 5:
                System.out.println(" Digite o salario do funcionário:");
                String novoSalario = teclado.nextLine();
                funcionario.setSalario(novoSalario);
                break;
            case 6:
                trocaCargoFuncionario();
                break;
            case 7:
                exibeMenuFuncionario();
                break;
        }

    }

    public void listaCargos() {

        System.out.println("--------- Lista de Funcionários ---------");

        for (Funcionario funcionarioListado : controlador.getFuncionarios()) {

            System.out.println("Nome: " + funcionarioListado.getNome());
            System.out.println("Matricula: " + funcionarioListado.getMatricula());
            System.out.println("Data de nascimento: " + funcionarioListado.getDataNascimento());
            System.out.println("Salario: " + funcionarioListado.getSalario());
            System.out.println("Telefone: " + funcionarioListado.getTelefone());
            System.out.println("Cargo: " + funcionarioListado.getCargo().getNome());
        }

    }

    public void excluiCargo() {

        int opcao = 0;

        System.out.println("--------- Deletar Funcionário ---------");
        System.out.println("-------------------------------------");
        System.out.println(" Digite a matrícula do funcionário:");
        String matricula = teclado.nextLine();

        Funcionario funcionario = controlador.findFuncionarioByMatricula(matricula);

        System.out.println(" Funcionário selecionado:");
        System.out.println(funcionario.getNome());
        System.out.println(funcionario.getMatricula());
        System.out.println(funcionario.getCargo().getNome());

        System.out.println("--------- Tem certeza que deseja excluir? ---------");
        System.out.println("--- 1. Sim ---------");
        System.out.println("--- 2. Não ---------");

        switch (opcao) {
            case 1:
                controlador.getFuncionarios().remove(funcionario);
                System.out.println("--- Usuário deletado com sucesso! ---------");
                exibeMenuFuncionario();
                break;
            case 2:
                exibeMenuFuncionario();
                break;
        }

    }
    
}
