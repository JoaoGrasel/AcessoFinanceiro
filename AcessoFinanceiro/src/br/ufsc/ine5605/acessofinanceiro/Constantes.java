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
    
    // ACESSO AO FINANCEIRO
    public static final String ACESSO_FINANCEIRO = "+-+-+-+-+-+-+-+ Acesso ao financeiro +-+-+-+-+-+-+-+";
    public static final String ACESSO_MATRICULA_INEXISTENTE = "Nao foi possivel acessar o financeiro. A matricula inserida nao existe.";
    public static final String ACESSO_PERMITIDO = "Parabens, voce conseguiu acessar o financeiro. Faca a festa!";
    
    // RELATORIO
    public static final String RELATORIO_ACESSO = "+-+-+-+-+-+-+-+ Relatorio de acesso negado +-+-+-+-+-+-+-+";
    public static final String RELATORIO_ESCOLHA_FILTRO = "Escolha o filtro: ";
    public static final String RELATORIO_FILTRO_MOTIVO = "1 - Por motivo";
    public static final String RELATORIO_FILTRO_MATRICULA = "2 - Por matricula";
    public static final String RELATORIO_FILTRO_ESCOLHA_MOTIVO = "Escolha o motivo: ";
    public static final String RELATORIO_FILTRO_MOTIVO_MATRICULA_INEXISTENTE = "1 - Matricula inexistente";
    public static final String RELATORIO_FILTRO_MOTIVO_CARGO_SEM_ACESSO = "2 - Cargo sem acesso";
    public static final String RELATORIO_FILTRO_MOTIVO_HORARIO_NAO_PERMITIDO = "3 - Horario nao permitido";
    public static final String RELATORIO_FILTRO_MOTIVO_ACESSO_BLOQUEADO = "4 - Acesso bloqueado";
}
