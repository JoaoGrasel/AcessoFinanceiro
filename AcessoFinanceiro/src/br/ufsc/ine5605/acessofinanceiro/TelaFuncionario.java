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

    /**
     * Exibe na tela o menu com as opcoes do CRUD do funcionario (cadastrar,
     * editar, listar e deletar)
     */
    public void exibeMenuFuncionario() {
        System.out.println();
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

    /**
     * Exibe na tela o titulo do cadastro de funcionaio: Novo Usuario
     */
    public void mensagemNovoFuncionario() {
        System.out.println();
        System.out.println(Constantes.MENSAGEM_NOVO_USUARIO);
        System.out.println();
    }

    /**
     * Exibe na tela o titulo da seção de edição de funcionario: Editar
     * Funcionario
     */
    public void mensagemEditaFuncionario() {
        System.out.println();
        System.out.println(Constantes.TITULO_EDITAR_FUNCIONARIO);
        System.out.println();
    }

    /**
     * Exibe as opcoes que o usuario pode selecionar para editar o cargo de um
     * funcionario: trocar o cargo atual por um existe ou então criar um novo
     */
    public void exibeOpcaoCargoFuncionario() {
        System.out.println();
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.USAR_CARGO_EXISTENTE);
        System.out.println(Constantes.CRIAR_CARGO_PARA_FUNCIONARIO);
        System.out.println();

    }

    /**
     * Exibe na tela o nome e o codigo de um cargo
     *
     * @param codigo do cargo
     * @param nome do cargo
     */
    public void listaCargo(int codigo, String nome) {
        System.out.println();
        System.out.println(Constantes.CODIGO_DO_CARGO + codigo);
        System.out.println(Constantes.NOME_DO_CARGO + nome);
        System.out.println();
    }

    /**
     * Exibe um menu com as opcoes que o usuario pode selecionar com relação a
     * editar um funcionario. (Alterar o nome, alterar a matricula, alterar a
     * data de nascimento, alterar o telefone, alterar o salario, alterar o
     * cargo, voltar ao menu de gerenciar funcionario)
     */
    public void exibeMenuEditaFuncionario() {
        System.out.println();
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.ALTERAR_NOME);
        System.out.println(Constantes.ALTERAR_MATRICULA);
        System.out.println(Constantes.ALTERAR_DATA_NASCIMENTO);
        System.out.println(Constantes.ALTERAR_TELEFONE);
        System.out.println(Constantes.ALTERAR_SALARIO);
        System.out.println(Constantes.ALTERAR_CARGO);
        System.out.println(Constantes.OPCAO_VOLTAR);
        System.out.println();
    }

    /**
     * Exibe a mensagem "Funcionario selecionado: "
     */
    public void exibeMensagemFuncionarioSelecionado() {
        System.out.println();
        System.out.println(Constantes.FUNCIONARIO_SELECIONADO);
    }

    /**
     * Exibe na tela o funcionário selecionado (matricula, nome, data de
     * nascimento, telefone, salario, cargo)
     *
     * @param matricula do funcionario selecionado
     * @param nome do funcionario selecionado
     * @param dataNascimento do funcionario selecionado
     * @param telefone do funcionario selecionado
     * @param salario do funcionario selecionado
     * @param cargo do funcionario selecionado
     */
    public void exibeFuncionario(int matricula, String nome, String dataNascimento, int telefone, int salario, Cargo cargo) {
        System.out.println();
        System.out.println(Constantes.MATRICULA + matricula);
        System.out.println(Constantes.NOME + nome);
        System.out.println(Constantes.DATA_NASCIMENTO + dataNascimento);
        System.out.println(Constantes.TELEFONE + telefone);
        System.out.println(Constantes.SALARIO + salario);
        System.out.println(Constantes.CARGO + cargo);
        System.out.println();
    }

    /**
     * Exibe na tela a mensagem: "Lista de funcionarios cadastrados: "
     */
    public void mensagemListaFuncionarios() {
        System.out.println();
        System.out.println(Constantes.LISTA_DE_FUNCIONARIOS);
        System.out.println();
    }

    /**
     * Exibe na tela o titulo do menu para deletar funcionario
     */
    public void mensagemDeletaFuncionario() {
        System.out.println();
        System.out.println(Constantes.TITULO_DELETAR_FUNCIONARIO);
        System.out.println();

    }

    /**
     * Exibe um menu pedindo ao usuário se ele confirma que quer deletar o
     * funcionário selecionado ou se ele não quer deletar e quer voltar ao menu
     * anterior
     */
    public void exibeMenuConfirmacaoDeletarFuncionario() {
        System.out.println();
        System.out.println(Constantes.TEM_CERTEZA_EXCLUIR);
        System.out.println(Constantes.SIM);
        System.out.println(Constantes.NAO);
        System.out.println();

    }

    /**
     * Pede que o usuário insira o nome do funcionário que deseja cadastrar
     *
     * @return nome do funcionário
     */
    public String pedeNome() {
        System.out.println();
        System.out.println(Constantes.DIGITE_NOME);
        System.out.println();
        String nome = teclado.nextLine();
        System.out.println();
        return nome;
    }

    /**
     * Pede que o usuário insira a matricula do funcionário que deseja cadastrar
     *
     * @return matricula do funcionario
     */
    public int pedeMatricula() {
        int matricula = 0;
        boolean matriculaInvalida = true;

        while (matriculaInvalida) {
            try {
                System.out.println();
                System.out.println(Constantes.DIGITE_MATRICULA);
                matricula = teclado.nextInt();
                System.out.println();
                matriculaInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.MATRICULA_INVALIDA);
                System.out.println();
                pedeMatricula();
            }

        }
        return matricula;
    }

    /**
     * Pede que o usuário insira a data de nascimento do funcionário que deseja
     * cadastrar no formato dd/MM/yyyy
     *
     * @return data de nascimento do funcionário
     */
    public String pedeDataNascimento() {
        System.out.println();
        System.out.println(Constantes.DIGITE_DATA_NASCIMENTO);
        System.out.println();
        String dataNascimento = teclado.nextLine();
        System.out.println();
        return dataNascimento;
    }

    /**
     * Pede que o usuário insira o telefone do funcionário que deseja cadastrar
     *
     * @return telefone do funcionário
     */
    public int pedeTelefone() {
        int telefone = 0;
        boolean telefoneInvalido = true;

        while (telefoneInvalido) {
            try {
                System.out.println();
                System.out.println(Constantes.DIGITE_TELEFONE);
                System.out.println();
                telefone = teclado.nextInt();
                System.out.println();
                telefoneInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.TELEFONE_INVALIDO);
                System.out.println();
                pedeTelefone();
            }

        }
        return telefone;
    }

    /**
     * Pede que o usuário insira o salario do funcionário que deseja cadastrar
     *
     * @return salario do funcionario
     */
    public int pedeSalario() {
        int salario = 0;

        boolean salarioInvalido = true;

        while (salarioInvalido) {
            try {
                System.out.println();
                System.out.println(Constantes.DIGITE_SALARIO);
                System.out.println();
                salario = teclado.nextInt();
                System.out.println();
                salarioInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.SALARIO_INVALIDO);
                System.out.println();
                pedeSalario();
            }

        }
        return salario;

    }

    /**
     * Pede que o usuário insira o codigo do cargo que deseja selecionar
     *
     * @return codigo do cargo
     */
    public int pedeCodigo() {
        int codigo = 0;
        boolean codigoInvalido = true;

        while (codigoInvalido) {
            try {
                System.out.println();
                System.out.println(Constantes.DIGITE_CODIGO);
                System.out.println();
                codigo = teclado.nextInt();
                System.out.println();
                codigoInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.CODIGO_INVALIDO);
                System.out.println();
                pedeCodigo();
            }

        }
        return codigo;
    }

    /**
     * Exibe a mensagem de erro de matricula ja cadastrada
     */
    public void mensagemErroMatriculaJaCadastrada() {
        System.out.println();
        System.out.println(Constantes.MATRICULA_JA_CADASTRADA);
        System.out.println();
    }

    /**
     * Exibe a mensagem de erro de opcao inexistente
     */
    public void opcaoInexistente() {
        System.out.println();
        System.out.println(Constantes.OPCAO_INEXISTENTE);
        System.out.println();
    }

    /**
     * exibe a mensagem de funcionario cadastrado com sucesso
     */
    public void mensagemFuncionarioCadastrado() {
        System.out.println();
        System.out.println(Constantes.FUNCIONARIO_CADASTRADO_SUCESSO);
        System.out.println();
    }

    /**
     * Exibe a mensagem de erro de cargo nao encontrado
     */
    public void mensagemCargoNaoEncontrado() {
        System.out.println();
        System.out.println(Constantes.CARGO_NAO_ENCONTRADO);
        System.out.println();
    }

    /**
     * Exibe a mensagem de funcionario deletado com sucesso
     */
    public void mensagemFuncionarioDeletadoSucesso() {
        System.out.println();
        System.out.println(Constantes.FUNCIONARIO_DELETADO_SUCESSO);
        System.out.println();
    }

    /**
     * Exibe a mensagem de erro de nome inserido invalido: deve conter somente
     * letras
     */
    public void mensagemNomeInvalidoLetras() {
        System.out.println();
        System.out.println(Constantes.NOME_INVALIDO_LETRAS);
        System.out.println();
    }

    /**
     * Exibe a mensagem de erro de nome inserido invalido: deve conter no minimo
     * 3 letras
     */
    public void mensagemNomeInvalidoTamanho() {
        System.out.println();
        System.out.println(Constantes.NOME_INVALIDO_TAMANHO);
        System.out.println();
    }

    /**
     * Exibe a mensagem de erro de data de nascimento invalida: não está no
     * formato pedido
     */
    public void mensagemErroDataNascimento() {
        System.out.println();
        System.out.println(Constantes.DATA_NASCIMENTO_INVALIDA);
        System.out.println();
    }

    /**
     * exibe a data inserida e apresenta um menu para que o usuario confirme a
     * data cadastrada ou não, caso não confirme ele deve inserir uma nova data
     *
     * @param dataInserida pelo usuario
     */
    public void exibeMenuConfirmacaoCadastroDataNascimento(String dataInserida) {
        System.out.println();
        System.out.println(Constantes.EXIBE_DATA_CADASTRADA + dataInserida);
        System.out.println(Constantes.CONFIRMA_DATA_CADASTRADA);
        System.out.println(Constantes.SIM);
        System.out.println(Constantes.NAO);
        System.out.println();
    }
}
