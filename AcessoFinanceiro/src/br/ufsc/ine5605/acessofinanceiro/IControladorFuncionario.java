/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

/**
 *
 * @author vladimir
 */
public interface IControladorFuncionario {

    /**
     * Metódo utilizado para encontrar um funcionario a partir da matricula.
     *
     * @param matricula matricula para encontrar o funcionario
     * @return funcionario
     */
    public Funcionario encontraFuncionarioPelaMatricula(int matricula);

    /**
     * verifica se um funcionario ja possui a matricula passada como parametro
     *
     * @param matricula - matricula que deve ser verificada
     * @return boolean - verdadeiro caso encontrou um funcionario com a
     * matricula inserida
     */
    public boolean matriculaExiste(int matricula);

    public void deixaFuncionarioSemCargo(Cargo cargoDeletado, Cargo semCargo);
}
