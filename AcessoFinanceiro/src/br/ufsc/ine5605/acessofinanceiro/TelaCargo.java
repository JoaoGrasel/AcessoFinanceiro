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
        boolean opcaoValida = true;
        while (opcaoValida) {
            try {
                System.out.println();
                opcao = teclado.nextInt();
                teclado.nextLine();
                System.out.println();
                opcaoValida = false;

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.OPCAO_INVALIDA);
                teclado.next();
            }
        }
        return opcao;
    }
    
    /**
     * Pede que o usuário insira o nome do cargo que deseja cadastrar
     *
     * @return nome do cargo
     */
    public String pedeNome() {
        System.out.println();
        System.out.println(Constantes.DIGITE_NOME_CARGO);
        String nome = teclado.nextLine();
        System.out.println();
        return nome;
    }
	
    public int pedeTipoCargo() {
        System.out.println();
        System.out.println(Constantes.ESCOLHA_TIPO_CARGO);
        System.out.println();
        System.out.println(Constantes.TIPO_CARGO_GERENCIAL);
        System.out.println(Constantes.TIPO_CARGO_COMERCIAL);
        System.out.println(Constantes.TIPO_CARGO_ESPECIAL);
        System.out.println();
        return teclado.nextInt();
    }
    
    /**
     * Exibe na tela o titulo do cadastro de cargo: Novo Cargo
     */
    public void mensagemNovoCargo() {
        System.out.println();
        System.out.println(Constantes.MENSAGEM_NOVO_CARGO);
        System.out.println();
    }
    
    /**
     * Exibe na tela o titulo da seção de edição de cargo: Editar Cargo
     */
    public void mensagemEditaCargo() {
        System.out.println();
        System.out.println(Constantes.TITULO_EDITAR_CARGO);
        System.out.println();
    }

    public void mensagemListaCargos() {
        System.out.println();
        System.out.println(Constantes.LISTA_DE_CARGOS);
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

    public void exibeCargo(int codigo, String nome, boolean ehGerencial, boolean temAcessoAoFinanceiro) {
        System.out.println();
        System.out.println(Constantes.CODIGO + codigo);
        System.out.println(Constantes.NOME + nome);
        System.out.println(Constantes.EH_GERENTE + ehGerencial);
        System.out.println(Constantes.TEM_ACESSO_AO_FINANCEIRO + temAcessoAoFinanceiro);
        System.out.println();
    }

    public void exibeCargoSelecionado() {
        System.out.println(Constantes.CARGO_SELECIONADO);
    }
    
    public int pedeCodigo() {
        int codigo = 0;
        boolean codigoInvalido = true;

        while (codigoInvalido) {
            try {
                System.out.println();
                System.out.println(Constantes.DIGITE_CODIGO_CARGO);
                codigo = teclado.nextInt();
                teclado.nextLine();
                System.out.println();
                codigoInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.CODIGO_INVALIDO);
                teclado.nextLine();
            }

        }
        return codigo;
    }
    
    public void mensagemErroCodigoJaCadastrada() {
        System.out.println();
        System.out.println(Constantes.CODIGO_JA_CADASTRADO);
        System.out.println();
    }

    public void mensagemDeletaCargo() {
        System.out.println();
        System.out.println(Constantes.TITULO_DELETAR_CARGO);
        System.out.println();
    }
    
    /**
     * exibe a mensagem de cargo cadastrado com sucesso
     */
    public void mensagemCargoCadastrado() {
        System.out.println();
        System.out.println(Constantes.CARGO_CADASTRADO_SUCESSO);
        System.out.println();
    }

    public void exibeMensagemCargoSelecionado() {
        System.out.println();
        System.out.println(Constantes.CARGO_SELECIONADO);
        System.out.println();
    }

    public void exibeMenuConfirmacaoDeletarCargo() {
        System.out.println();
        System.out.println(Constantes.CONFIRMACAO_EXCLUSAO_CARGO);
        System.out.println(Constantes.SIM);
        System.out.println(Constantes.NAO);
        System.out.println();
    }

    public void mensagemCargoDeletadoSucesso() {
        System.out.println();
        System.out.println(Constantes.CARGO_DELETADO_SUCESSO);
        System.out.println();
    }

    public void exibeOpcaoInexistente() {
        System.out.println(Constantes.OPCAO_INEXISTENTE);
    }

    public void exibeMenuEditaCargo() {
        System.out.println();
        System.out.println(Constantes.O_QUE_DESEJA_FAZER);
        System.out.println(Constantes.ALTERAR_NOME_CARGO);
        System.out.println(Constantes.ALTERAR_CODIGO_CARGO);
        System.out.println(Constantes.ALTERAR_EH_GERENCIAL);
        System.out.println(Constantes.ALTERAR_TEM_ACESSO);
        System.out.println(Constantes.OPCAO_VOLTAR_CARGO);
        System.out.println(); 
    }

    public void mensagemCargoNaoEncontrado() {
        System.out.println(Constantes.MENSAGEM_CARGO_NAO_ENCONTRADO);
    }

    public void mensagemNomeEditadoSucesso() {
        System.out.println(Constantes.NOME_EDITADO_SUCESSO);
    }

    public void mensagemCodigoEditadoSucesso() {
        System.out.println(Constantes.CODIGO_EDITADO_SUCESSO);
    }
    
    public void mensagemGerencialEditadoSucesso() {
        System.out.println(Constantes.EH_GERENCIAL_EDITADO_SUCESSO);
    }
    
    public void mensagemAcessoEditadoSucesso() {
        System.out.println(Constantes.TEM_ACESSO_EDITADO_SUCESSO);
    }
    
    public int pedeSeEhGerencial() {
        int ehGerencial = 0;
        boolean gerencialInvalido = true;
        
        while (gerencialInvalido) {
            try {
                System.out.println();
                System.out.println(Constantes.TORNAR_CARGO_GERENCIAL);
                System.out.println(Constantes.SIM);
                System.out.println(Constantes.NAO);
                ehGerencial = teclado.nextInt();
                teclado.nextLine();
                System.out.println();
                gerencialInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.OPCAO_INVALIDA);
                teclado.nextLine();
            }
        }
        return ehGerencial;
    }

    public int pedeTemAcessoAoFinanceiro() {
        int temAcessoAoFinanceiro = 0;
        boolean temAcessoInvalido = true;
        
        while (temAcessoInvalido) {
            try {
                System.out.println();
                System.out.println(Constantes.ESCOLHA_TEM_ACESSO);
                System.out.println(Constantes.SIM);
                System.out.println(Constantes.NAO);
                temAcessoAoFinanceiro = teclado.nextInt();
                teclado.nextLine();
                System.out.println();
                temAcessoInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Constantes.OPCAO_INVALIDA);
                teclado.nextLine();
            }
        }
        return temAcessoAoFinanceiro;
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

    public void mensagemNomeInvalidoTamanho() {
        System.out.println();
        System.out.println(Constantes.NOME_INVALIDO_TAMANHO);
        System.out.println();
    }

    public String pedeHoraInicio() {
        System.out.println();
        System.out.println(Constantes.DIGITE_HORA_INICIO);
        String horaInicio = teclado.nextLine();
        System.out.println();
        return horaInicio;
    }
	
    public String pedeHoraFim() {
        System.out.println();
        System.out.println(Constantes.DIGITE_HORA_FIM);
        String horaFim = teclado.nextLine();
        System.out.println();
        return horaFim;
    }

    public void exibeHoraInseridaFormatoIncorreto() {
        System.out.println(Constantes.HORA_INSERIDA_FORMATO_INCORRETO);
    }
	
}
