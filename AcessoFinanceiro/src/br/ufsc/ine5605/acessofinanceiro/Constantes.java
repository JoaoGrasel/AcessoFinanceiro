/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

/**
 *
 * Define as Strings constantes utilizadas no projeto.
 *
 * @author thiagobrezinski
 */
class Constantes {

    // COMUM
    public static final String INSIRA_MATRICULA = "Insira a matricula: ";
    public static final String MATRICULA_INVALIDA = "Matricula invalida: a matricula deve conter somente numeros.";
    public static final String OPCAO_INVALIDA = "Opcao invalida: por favor digite somente um numero.";
    public static final String OPCAO_INEXISTENTE = "Opcao inexistente: tente novamente.";
    public static final String INSIRA_OPCAO = "Insira a opcao: ";
    public static final String MATRICULA_JA_CADASTRADA = "Matricula invalida: a matricula inserida ja foi cadastrada";

    // ACESSO AO FINANCEIRO
    public static final String ACESSO_FINANCEIRO = "+-+-+-+-+-+-+-+ Acesso ao financeiro +-+-+-+-+-+-+-+";
    public static final String ACESSO_MATRICULA_INEXISTENTE = "Nao foi possivel acessar o financeiro. A matricula inserida nao existe.";
    public static final String ACESSO_PERMITIDO = "Parabens, voce conseguiu acessar o financeiro. Faca a festa!";

    // RELATORIO
    public static final String RELATORIO_ACESSO = "+-+-+-+-+-+-+-+ Gerenciar Relatorios +-+-+-+-+-+-+-+";
    public static final String RELATORIO_ESCOLHA_FILTRO = "Escolha o filtro: ";
    public static final String RELATORIO_FILTRO_MOTIVO = "1 - Por motivo";
    public static final String RELATORIO_FILTRO_MATRICULA = "2 - Por matricula";
    public static final String RELATORIO_FILTRO_ESCOLHA_MOTIVO = "Escolha o motivo: ";
    public static final String RELATORIO_FILTRO_MOTIVO_MATRICULA_INEXISTENTE = "1 - Matricula inexistente";
    public static final String RELATORIO_FILTRO_MOTIVO_CARGO_SEM_ACESSO = "2 - Cargo sem acesso";
    public static final String RELATORIO_FILTRO_MOTIVO_HORARIO_NAO_PERMITIDO = "3 - Horario nao permitido";
    public static final String RELATORIO_FILTRO_MOTIVO_ACESSO_BLOQUEADO = "4 - Acesso bloqueado";
    public static final String RELATORIO_ACESSO_MATRICULA = "Relatorio de acesso negado - matricula: ";
    public static final String RELATORIO_VOLTAR_MENU_PRINCIPAL = "1 - Voltar ao menu principal";
    public static final String RELATORIO_REGISTRO_CABECALHO = "+-+-+ Registro ";
    public static final String RELATORIO_REGISTRO_DATA = "Data: ";
    public static final String RELATORIO_REGISTRO_MOTIVO = "Motivo: ";

    //MENU GERENCIAR FUNCIONARIO
    public static final String GERENCIAR_FUNCIONARIO = " +-+-+-+-+-+-+-+ Gerenciar Funcionários +-+-+-+-+-+-+-+";
    public static final String CADASTRAR_FUNCIONARIO = " 1. Cadastrar Funcionário ";
    public static final String EDITAR_FUNCIONARIO = " 2. Editar Funcionário ";
    public static final String LISTAR_FUNCIONARIOS = " 3. Listar Funcionários ";
    public static final String DELETAR_FUNCIONARIO = " 4. Deletar Funcionário ";
    public static final String VOLTAR_AO_MENU_PRINCIPAL = " 5. Voltar ao menu principal ";

    //CADASTRAR FUNCIONARIO
    public static final String MENSAGEM_NOVO_USUARIO = "+-+-+-+-+-+-+-+ Novo Funcionário +-+-+-+-+-+-+-+";
    public static final String DIGITE_NOME = " Digite o nome do funcionário:";
    public static final String DIGITE_MATRICULA = " Digite a matrícula do funcionário:";
    public static final String DIGITE_DATA_NASCIMENTO = " Digite a data de nascimento do funcionário:";
    public static final String DIGITE_TELEFONE = " Digite o telefone do funcionário:";
    public static final String DIGITE_SALARIO = " Digite o salário do funcionário:";
    public static final String DIGITE_CODIGO = " Digite o código do cargo que deseja atribuir ao funcionário: ";

    //EDITAR FUNCIONARIO
    public static final String TITULO_EDITAR_FUNCIONARIO = "+-+-+-+-+-+-+-+ Editar Funcionário +-+-+-+-+-+-+-+";
    public static final String FUNCIONARIO_SELECIONADO = " Funcionário selecionado: ";
    public static final String ALTERAR_NOME = " 1. Alterar Nome";
    public static final String ALTERAR_MATRICULA = " 2. Alterar Matricula ";
    public static final String ALTERAR_DATA_NASCIMENTO = " 3. Alterar a Data de Nascimento ";
    public static final String ALTERAR_TELEFONE = " 4. Alterar o Telefone ";
    public static final String ALTERAR_SALARIO = " 5. Alterar o Salário ";
    public static final String ALTERAR_CARGO = " 6. Alterar o Cargo ";
    public static final String OPCAO_VOLTAR = " 7. Voltar ";

    //SELECIONAR OU CRIAR CARGO NO CADASTRO
    public static final String O_QUE_DESEJA_FAZER = " O que você deseja fazer?";
    public static final String USAR_CARGO_EXISTENTE = " 1. Usar cargo ja existente ";
    public static final String CRIAR_CARGO_PARA_FUNCIONARIO = " 2. Criar cargo ";
    public static final String CODIGO_DO_CARGO = "Codigo do cargo: ";
    public static final String NOME_DO_CARGO = "Nome do cargo: ";

    //LISTAR CARGOS
    public static final String LISTA_DE_FUNCIONARIOS = "+-+-+-+-+-+-+-+ Lista de Funcionários +-+-+-+-+-+-+-+";
    public static final String MATRICULA = " Matricula: ";
    public static final String NOME = "Nome : ";
    public static final String DATA_NASCIMENTO = " Data de Nascimento: ";
    public static final String TELEFONE = " Telefone: ";
    public static final String SALARIO = " Salario: ";
    public static final String CARGO = " Cargo: ";

    //DELETAR FUNCIONARIO
    public static final String TITULO_DELETAR_FUNCIONARIO = "+-+-+-+-+-+-+-+ Deletar Funcionário +-+-+-+-+-+-+-+";
    public static final String TEM_CERTEZA_EXCLUIR = " Tem certeza que deseja excluir o funcionario? ";
    public static final String SIM = " 1. Sim ";
    public static final String NAO = " 2. Não";

    //DATA DO SISTEMA
    public static final String HORA_ATUAL_DO_SISTEMA = "Data e hora do sistema: ";
    public static final String ALTERAR_DATA_E_HORA = " 1. Alterar data e hora do sistema";
    public static final String DATA_VOLTAR_MENU_PRINCIPAL = " 2. Voltar ao menu principal";

    //COMUM
    public static final String CODIGO_INVALIDO = "Codigo invalido: o codigo deve conter somente numeros. Tente novamente.";
    public static final String SALARIO_INVALIDO = "Salario invalido: o salario deve conter somente numeros.";
    public static final String TELEFONE_INVALIDO = "Telefone invalido: o telefone deve conter somente numeros.";
    public static final String CARGO_NAO_ENCONTRADO = "O sistema nao encontrou nenhum cargo com este codigo. Tente novamente.";
    public static final String FUNCIONARIO_DELETADO_SUCESSO = "O funcionario foi deletado com sucesso!";

    public static final String USUARIO_CADASTRADO_SUCESSO = "Usuario cadastrado com sucesso!";

}
