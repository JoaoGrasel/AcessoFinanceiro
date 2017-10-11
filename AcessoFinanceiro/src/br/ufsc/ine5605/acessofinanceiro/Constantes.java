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
    public static final String MATRICULA_INVALIDA = "-- Matricula invalida: a matricula deve conter somente numeros --";
    public static final String OPCAO_INVALIDA = "-- Opcao invalida: por favor digite somente um numero --";
    public static final String OPCAO_INEXISTENTE = "-- Opção solicitada não existe, confira as opcoes do menu e tente novamente --";
    public static final String INSIRA_OPCAO = "Insira a opcao: ";
    public static final String MATRICULA_JA_CADASTRADA = "-- Matricula invalida: a matricula inserida ja foi cadastrada --";
    public static final String CODIGO_JA_CADASTRADO = "-- Codigo invalido: o codigo inserido ja foi cadastrado --";
    public static final String MATRICULA_INEXISTENTE = "-- Matricula inexistente: a matricula inserida nao pertence a nenhum funcionario --";
    public static final String TENTAR_NOVAMENTE = "1 - Tentar novamente";
    public static final String VOLTAR_MENU_PRINCIPAL_1 = "1 - Voltar ao menu principal";
    public static final String VOLTAR_MENU_PRINCIPAL_2 = "2 - Voltar ao menu principal";
    public static final String VOLTAR_MENU_PRINCIPAL_3 = "3 - Voltar ao menu principal";
    public static final String VOLTAR_MENU_PRINCIPAL_4 = "4 - Voltar ao menu principal";
    public static final String VOLTAR_MENU_PRINCIPAL_5 = "5 - Voltar ao menu principal";
    public static final String NOME_INVALIDO_LETRAS = "-- Nome invalido, o nome deve conter somente letras --";
    public static final String NOME_INVALIDO_TAMANHO = "-- Nome invalido, o nome deve conter no mínimo 3 letras --";
    public static final String DATA_NASCIMENTO_INVALIDA = "Data de nascimento inválida. A data deve ser inserida no formato dd/mm/yyyy";
    public static final String SIM = " 1. Sim ";
    public static final String NAO = " 2. Não";
    public static final String NOVA_TENTATIVA_FILTRO_MATRICULA = "Tentar novamente filtro matricula";
    public static final String NOVA_TENTATIVA_FILTRO_MOTIVO = "Tentar novamente filtro motivo";
    public static final String MENSAGEM_FUNCIONARIO_NAO_ENCONTRADO = " Funcionário não encontrado. Insira uma matricula existente. ";
    public static final String VOLTAR_2 = "2 - Voltar";
    public static final String VOLTAR_5 = "5 - Voltar";

    // ACESSO AO FINANCEIRO
    public static final String ACESSO_FINANCEIRO = "+-+-+-+-+-+-+-+ Acesso ao financeiro +-+-+-+-+-+-+-+";
    public static final String ACESSO_MATRICULA_INEXISTENTE = "Nao foi possivel acessar o financeiro. A matricula inserida nao existe.";
    public static final String ACESSO_PERMITIDO = "Parabens, voce conseguiu acessar o financeiro. Faca a festa!";
    public static final String ACESSO_NEGADO_MATRICULA_INEXISTENTE = "Acesso negado: matricula inexistente.";
    public static final String ACESSO_NEGADO_HORARIO_NAO_PERMITIDO = "Acesso negado: horario nao permitido.";
    public static final String ACESSO_NEGADO_CARGO_SEM_ACESSO = "Acesso negado: cargo sem acesso.";
    public static final String ACESSO_NEGADO_ACESSO_BLOQUEADO = "Acesso negado: acesso bloqueado.";

    // RELATORIO
    public static final String RELATORIO_ACESSO = "+-+-+-+-+-+-+-+ Emitir relatorio +-+-+-+-+-+-+-+";
    public static final String RELATORIO_ESCOLHA_FILTRO = "Escolha o filtro: ";
    public static final String RELATORIO_FILTRO_MOTIVO = "1 - Por motivo";
    public static final String RELATORIO_FILTRO_MATRICULA = "2 - Por matricula";
    public static final String RELATORIO_FILTRO_ESCOLHA_MOTIVO = "Escolha o motivo: ";
    public static final String RELATORIO_FILTRO_MOTIVO_MATRICULA_INEXISTENTE = "1 - Matricula inexistente";
    public static final String RELATORIO_FILTRO_MOTIVO_CARGO_SEM_ACESSO = "2 - Cargo sem acesso";
    public static final String RELATORIO_FILTRO_MOTIVO_HORARIO_NAO_PERMITIDO = "3 - Horario nao permitido";
    public static final String RELATORIO_FILTRO_MOTIVO_ACESSO_BLOQUEADO = "4 - Acesso bloqueado";
    public static final String RELATORIO_ACESSO_MATRICULA = "Relatorio de acesso negado - matricula: ";
    public static final String RELATORIO_ACESSO_MOTIVO_MATRICULA_INEXISTENTE = "Relatorio de acesso negado - motivo: matricula inexistente";
    public static final String RELATORIO_ACESSO_MOTIVO_ACESSO_BLOQUEADO = "Relatorio de acesso negado - motivo: acesso bloqueado";
    public static final String RELATORIO_ACESSO_MOTIVO_CARGO_SEM_ACESSO = "Relatorio de acesso negado - motivo: cargo sem acesso";
    public static final String RELATORIO_ACESSO_MOTIVO_HORARIO_NAO_PERMITIDO = "Relatorio de acesso negado - motivo: horario nao permitido";
    public static final String RELATORIO_REGISTRO_CABECALHO = "+-+-+ Registro ";
    public static final String RELATORIO_REGISTRO_DATA = "Data: ";
    public static final String RELATORIO_REGISTRO_MOTIVO = "Motivo: ";
    public static final String RELATORIO_REGISTRO_MATRICULA = "Matricula: ";
    public static final String RELATORIO_REGISTRO_NENHUM_ENCONTRADO = "Nenhum registro encontrado.";

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
    public static final String DIGITE_DATA_NASCIMENTO = " Digite a data de nascimento do funcionário no formato dd/mm/yyyy:";
    public static final String DIGITE_TELEFONE = " Digite o telefone do funcionário:";
    public static final String DIGITE_SALARIO = " Digite o salário do funcionário:";
    public static final String DIGITE_CODIGO = " Digite o código do cargo que deseja atribuir ao funcionário: ";
    public static final String EXIBE_DATA_CADASTRADA = "Data cadastrada: ";
    public static final String CONFIRMA_DATA_CADASTRADA = "Você confirma a data cadastrada?";

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
    public static final String CARGO_EDITADO_SUCESSO = " Cargo editado com sucesso!";
    public static final String SALARIO_EDITADO_SUCESSO = " Salario editado com sucesso!";
    public static final String TELEFONE_EDITADO_SUCESSO = " Telefone editado com sucesso!";
    public static final String DATA_NASCIMENTO_EDITADA_SUCESSO = " Data de nascimento editada com sucesso!";
    public static final String MATRICULA_EDITADA_SUCESSO = " Matricula editada com sucesso!";
    public static final String NOME_EDITADO_SUCESSO = " Nome editado com sucesso!";

//SELECIONAR OU CRIAR CARGO NO CADASTRO
    public static final String O_QUE_DESEJA_FAZER = " O que você deseja fazer?";
    public static final String USAR_CARGO_EXISTENTE = " 1. Usar cargo ja existente ";
    public static final String CRIAR_CARGO_PARA_FUNCIONARIO = " 2. Criar cargo ";
    public static final String CODIGO_DO_CARGO = "Codigo do cargo: ";
    public static final String NOME_DO_CARGO = "Nome do cargo: ";

    //LISTAR CARGOS
    public static final String LISTA_DE_FUNCIONARIOS = "+-+-+-+-+-+-+-+ Lista de Funcionários +-+-+-+-+-+-+-+";
    public static final String MATRICULA = " Matricula: ";
    public static final String NOME = " Nome : ";
    public static final String DATA_NASCIMENTO = " Data de Nascimento: ";
    public static final String TELEFONE = " Telefone: ";
    public static final String SALARIO = " Salario: ";
    public static final String CARGO = " Cargo: ";

    //DELETAR FUNCIONARIO
    public static final String TITULO_DELETAR_FUNCIONARIO = "+-+-+-+-+-+-+-+ Deletar Funcionário +-+-+-+-+-+-+-+";
    public static final String TEM_CERTEZA_EXCLUIR = " Tem certeza que deseja excluir o funcionario? Caso selecione não você voltará ao menu de funcionarios. ";

    //MENU GERENCIAR CARGO  @BRUNO
    public static final String GERENCIAR_CARGO = " +-+-+-+-+-+-+-+ Gerenciar Cargo +-+-+-+-+-+-+-+";
    public static final String CADASTRAR_CARGO = " 1. Cadastrar Cargo ";
    public static final String EDITAR_CARGO = " 2. Editar Cargo ";
    public static final String LISTAR_CARGOS = " 3. Listar Cargos ";
    public static final String DELETAR_CARGO = " 4. Deletar Cargo ";

    //CADASTRA CARGO    @BRUNO
    public static final String MENSAGEM_NOVO_CARGO = "+-+-+-+-+-+-+-+ Novo Cargo +-+-+-+-+-+-+-+";
    public static final String DIGITE_NOME_CARGO = " Digite o nome do cargo:";
    public static final String ESCOLHA_TIPO_CARGO = " Escolha o tipo do cargo:";
    public static final String TIPO_CARGO_GERENCIAL = "1 - Cargo Gerencial";
    public static final String TIPO_CARGO_COMERCIAL = "2 - Cargo Comercial";
    public static final String TIPO_CARGO_ESPECIAL = "3 - Cargo Especial";
    public static final String DIGITE_CODIGO_CARGO = " Digite o código que deseja atribuir ao cargo: ";

    //EDITAR CARGO   @BRUNO
    public static final String TITULO_EDITAR_CARGO = "+-+-+-+-+-+-+-+ Editar Cargo +-+-+-+-+-+-+-+";
    public static final String CARGO_SELECIONADO = " Cargo selecionado: ";
    public static final String ALTERAR_NOME_CARGO = " 1. Alterar Nome do Cargo";
    public static final String ALTERAR_CODIGO_CARGO = " 2. Alterar Código do Cargo ";
    public static final String OPCAO_VOLTAR_CARGO = " 3. Voltar ";

    //LISTAR CARGOS
    public static final String LISTA_DE_CARGOS = "+-+-+-+-+-+-+-+ Lista de Cargos +-+-+-+-+-+-+-+";
    public static final String CODIGO = " Codigo: ";
    public static final String NOME_CARGO = "Nome: ";
    public static final String EH_GERENTE = " O cargo é gerencial: ";
    public static final String TEM_ACESSO_AO_FINANCEIRO = " Tem Acesso ao Financeiro: ";

    //DATA DO SISTEMA
    public static final String TITULO_MENU_DATA_HORA_SISTEMA = "+-+-+-+-+-+-+-+ Menu de data e hora do sistema +-+-+-+-+-+-+-+";
    public static final String HORA_ATUAL_DO_SISTEMA = "Data e hora atuais do sistema: ";
    public static final String ALTERAR_DATA_E_HORA = " 1. Alterar data e hora do sistema";
    public static final String DATA_VOLTAR_MENU_PRINCIPAL = " 2. Voltar ao menu principal";
    public static final String INSIRA_DATA_SISTEMA = "Insira a nova data e hora do sistema no seguinte formato: dd-MM-yyyy HH:mm ";
    public static final String DATA_HORA_SISTEMA_INVALIDOS = "-- Formato invalido, utilize o formato correto solicitado --";
    public static final String CONFIRMA_ALTERACAO_DATA_HORA = "Voce confirma a alteracao de data e hora do sistema?";
    public static final String DATA_HORA_ATUALIZADOS_SUCESSO = "Data e hora do sistema atualizadas com sucesso!";
    public static final String DATA_HORA_NAO_ATUALIZADOS = "-- Atualização de data e hora do sistema abortada --";

    //COMUM
    public static final String CODIGO_INVALIDO = "-- Codigo invalido: o codigo deve conter somente numeros. Tente novamente --";
    public static final String SALARIO_INVALIDO = "-- Salario invalido: o salario deve conter somente numeros --";
    public static final String TELEFONE_INVALIDO = "-- Telefone invalido: o telefone deve conter somente numeros --";
    public static final String CARGO_NAO_ENCONTRADO = "-- O sistema nao encontrou nenhum cargo com este codigo. Tente novamente --";
    public static final String FUNCIONARIO_DELETADO_SUCESSO = "O funcionario foi deletado com sucesso!";

    public static final String FUNCIONARIO_CADASTRADO_SUCESSO = "Funcionario cadastrado com sucesso!";

    //MENU PRINCIPAL
    public static final String MENU_PRINCIPAL = "+-+-+-+-+-+-+-+ Menu Principal +-+-+-+-+-+-+-+";
    public static final String ACESSO_AO_FINANCEIRO = "1. Acesso à Porta do Financeiro";
    public static final String GERENCIAR_FUNCIONARIOS = "2. Gerenciar Funcionários";
    public static final String GERENCIAR_CARGOS = "3. Gerenciar Cargos";
    public static final String GERENCIAR_DATA = "4. Gerenciar data do sistema";
    public static final String EMITIR_RELATORIO = "5. Emitir Relatorio";

}
