/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;

/**
 *
 * @author vladimir
 */
public class ControladorFuncionario {

    private TelaFuncionario telaFuncionario;
    private ControladorPrincipal controladorPrincipal;
    private ArrayList<Funcionario> funcionarios;

    ControladorFuncionario(ControladorPrincipal owner) {
        this.telaFuncionario = new TelaFuncionario(this);
        this.funcionarios = new ArrayList<>();
        this.controladorPrincipal = owner;
    }

    public void exibeMenuFuncionario() {

        int opcao = telaFuncionario.exibeMenuFuncionario();

        switch (opcao) {
            case 1:
                incluiFuncionario();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                voltaMenuPrincipal();
                break;
        }

    }

    public void incluiFuncionario() {
        telaFuncionario.novoFuncionario();
        String nome = telaFuncionario.pedeNome();
        int matricula = telaFuncionario.pedeMatricula();
        Date dataNascimento = telaFuncionario.pedeDataNascimento();
        String telefone = telaFuncionario.pedeTelefone();
        String salario = telaFuncionario.pedeSalario();
    }

    public void voltaMenuPrincipal() {
        controladorPrincipal.exibeMenuPrincipal();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public boolean matriculaExiste(String matricula) {
        for (Funcionario funcionario : funcionarios) {
            String matriculaFuncionario = funcionario.getMatricula();
            if (matriculaFuncionario.equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaMatricula(String matricula) {
        if (matricula != null) {
            //verifica se é só numeros if(sohNumero)
            if (matriculaExiste(matricula)) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    public Funcionario findFuncionarioByMatricula(String matricula) {
        for (Funcionario funcionarioLista : funcionarios) {
            if (funcionarioLista.getMatricula().equals(matricula)) {
                return funcionarioLista;
            }
        }
        return null;
    }

}
