/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

/**
 *
 * @author bruno
 */
public interface IControladorCargo {

   
    //DEIXAR O CONTROLADOR CARGO COMO PUBLICO NO CONTROLADOR PRINCIPAL PRA PODER CHAMAR OS METODOS DELE NO CONTROLADOR FUNCIONARIO
    /**
     * Verifica se existe um cargo criado com o código passado como parametro,
     * caso exista retorna o cargo. Caso não exista retorna null.
     *
     * @return cargo
     */
    public Cargo encontraCargoPorCodigo(int codigo);
    
    /**
     *
     * Printa na tela todos os cargos criados com seu código, possibilidade de
     * acesso ou não e horarios que pode acessar a porta;
     *
     * @return
     */
    public void listaCargos();

}
