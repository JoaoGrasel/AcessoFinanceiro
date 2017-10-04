/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

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

    public void exibeMenuFuncionario() {
        System.out.println(Constantes.GERENCIAR_FUNCIONARIO);
        System.out.println();
        System.out.println(Constantes.CADASTRAR_FUNCIONARIO);
        System.out.println(Constantes.EDITAR_FUNCIONARIO);
        System.out.println(Constantes.LISTAR_FUNCIONARIOS);
        System.out.println(Constantes.DELETAR_FUNCIONARIO);
        System.out.println(Constantes.VOLTAR_AO_MENU_PRINCIPAL);
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println();
    }

    public int pedeOpcao() {
        int opcao = 0;
        boolean opcaoInvalida = true;

        while (opcaoInvalida) {
            try {
                opcao = teclado.nextInt();
                opcaoInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.OPCAO_INVALIDA);
            }

        }
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

    public void exibeOpcaoCargoFuncionario() {

        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.USAR_CARGO_EXISTENTE);
        System.out.println(Constantes.CRIAR_CARGO_PARA_FUNCIONARIO);

    }

    public void listaCargo(int codigo, String nome) {
        System.out.println(Constantes.CODIGO_DO_CARGO + codigo);
        System.out.println(Constantes.NOME_DO_CARGO + nome);
        System.out.println();
    }

    public void exibeMenuEditaFuncionario() {
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.ALTERAR_NOME);
        System.out.println(Constantes.ALTERAR_MATRICULA);
        System.out.println(Constantes.ALTERAR_DATA_NASCIMENTO);
        System.out.println(Constantes.ALTERAR_TELEFONE);
        System.out.println(Constantes.ALTERAR_SALARIO);
        System.out.println(Constantes.ALTERAR_CARGO);
        System.out.println(Constantes.OPCAO_VOLTAR);
    }

    public void exibeMensagemFuncionarioSelecionado() {
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

    public void exibeMenuDeletaFuncionario() {

        System.out.println(Constantes.TEM_CERTEZA_EXCLUIR);
        System.out.println(Constantes.SIM);
        System.out.println(Constantes.NAO);

    }

    public String pedeNome() {
        System.out.println(Constantes.DIGITE_NOME);
        String nome = teclado.nextLine();
        return nome;
    }

    public int pedeMatricula() {
        int matricula = 0;
        boolean matriculaInvalida = true;

        while (matriculaInvalida) {
            try {
                System.out.println(Constantes.DIGITE_MATRICULA);
                matricula = teclado.nextInt();
                matriculaInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.MATRICULA_INVALIDA);
                pedeMatricula();
            }

        }
        return matricula;
    }

    public Date pedeDataNascimento() {
        System.out.println(Constantes.DIGITE_DATA_NASCIMENTO);
        String dataNascimento = teclado.nextLine();
        //fazer as excecoes da data e depois transformar em um string
        return
    }

    public int pedeTelefone() {
        int telefone = 0;
        boolean telefoneInvalido = true;

        while (telefoneInvalido) {
            try {
                System.out.println(Constantes.DIGITE_TELEFONE);
                telefone = teclado.nextInt();
                telefoneInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.TELEFONE_INVALIDO);
                pedeTelefone();
            }

        }
        return telefone;
    }

    public int pedeSalario() {
        int salario = 0;

        boolean salarioInvalido = true;

        while (salarioInvalido) {
            try {
                System.out.println(Constantes.DIGITE_SALARIO);
                salario = teclado.nextInt();
                salarioInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.SALARIO_INVALIDO);
                pedeSalario();
            }

        }
        return salario;

    }

    public int pedeCodigo() {
        int codigo = 0;
        boolean codigoInvalido = true;

        while (codigoInvalido) {
            try {
                System.out.println(Constantes.DIGITE_CODIGO);
                codigo = teclado.nextInt();
                codigoInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.CODIGO_INVALIDO);
                pedeCodigo();
            }

        }
        return codigo;
    }

    public void mensagemErroMatriculaJaCadastrada() {
        System.out.println(Constantes.MATRICULA_JA_CADASTRADA);
    }

    public void opcaoInexistente() {
        System.out.println(Constantes.OPCAO_INEXISTENTE);
    }

    public void mensagemUsuarioCadastrado() {
        System.out.println(Constantes.USUARIO_CADASTRADO_SUCESSO);
    }

    public void mensagemCargoNaoEncontrado() {
        System.out.println(Constantes.CARGO_NAO_ENCONTRADO);
    }

    public void mensagemFuncionarioDeletadoSucesso() {
        System.out.println(Constantes.FUNCIONARIO_DELETADO_SUCESSO);
    }

    public void mensagemNomeInvalidoLetras() {
        System.out.println(Constantes.NOME_INVALIDO_LETRAS);
    }

    public void mensagemNomeInvalidoTamanho() {
        System.out.println(Constantes.NOME_INVALIDO_TAMANHO);
    }
}
