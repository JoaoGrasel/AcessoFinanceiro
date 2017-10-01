/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vladimir
 */
public class ControladorFuncionario {

    private TelaFuncionario telaFuncionario;
    private ControladorPrincipal controladorPrincipal;
    private ArrayList<Funcionario> funcionarios;

    public ControladorFuncionario(ControladorPrincipal owner) {
        this.telaFuncionario = new TelaFuncionario(this);
        this.funcionarios = new ArrayList<>();
        this.controladorPrincipal = owner;

    }

    public void menuFuncionario() {

        int opcao = telaFuncionario.exibeMenuFuncionario();

        switch (opcao) {
            case 1:
                incluiFuncionario();
                break;
            case 2:
                editaFuncionario();
                break;
            case 3:
                listaFuncionarios();
                break;
            case 4:
                menuDeletarFuncionario();
                break;
            case 5:
                this.controladorPrincipal.exibeMenuPrincipal();
                break;
            default:
                System.out.println(Constantes.OPCAO_INEXISTENTE);
                menuFuncionario();
                break;
        }

    }

    public void incluiFuncionario() {

        this.telaFuncionario.mensagemNovoFuncionario();

        String nome = this.telaFuncionario.pedeNome();
        int matricula = cadastraMatricula();

        Date dataNascimento = this.telaFuncionario.pedeDataNascimento();
        int telefone = this.telaFuncionario.pedeTelefone();
        int salario = this.telaFuncionario.pedeSalario();
        int opcao;
        opcao = this.telaFuncionario.opcaoCargoFuncionario();
        Cargo cargo = null;
        switch (opcao) {
            case 1:
                listaCargos();
                cargo = atribuiCargoPorCodigo();
                break;
            case 2:
                cargo = this.controladorPrincipal.controladorCargo.cadastraCargoParaFuncionario();
                break;
        }

        if (!this.funcionarios.contains(findFuncionarioByMatricula(matricula))) {
            Funcionario funcionario = new Funcionario(matricula, nome, dataNascimento, telefone, salario, cargo);
            funcionarios.add(funcionario);
        }

        menuFuncionario();
        return;
    }

    public void editaFuncionario() {
        this.telaFuncionario.mensagemEditaFuncionario();
        Funcionario funcionario = pedeFuncionario();
        this.telaFuncionario.exibeFuncionarioSelecionado();
        this.telaFuncionario.exibeFuncionario(funcionario.getMatricula(), funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getTelefone(), funcionario.getSalario(), funcionario.getCargo());

        int opcao = this.telaFuncionario.exibeMenuEditaFuncionario();

        switch (opcao) {
            case 1:
                String nome = this.telaFuncionario.pedeNome();
                funcionario.setNome(nome);
                break;
            case 2:
                int matricula = cadastraMatricula();
                funcionario.setMatricula(matricula);
                break;
            case 3:
                Date dataNascimento = this.telaFuncionario.pedeDataNascimento();
                funcionario.setDataNascimento(dataNascimento);
                break;
            case 4:
                int telefone = this.telaFuncionario.pedeTelefone();
                funcionario.setTelefone(telefone);
                break;
            case 5:
                int salario = this.telaFuncionario.pedeSalario();
                funcionario.setSalario(salario);
                break;

            case 6:
                int opcaoCargo = this.telaFuncionario.opcaoCargoFuncionario();
                Cargo cargo = null;
                switch (opcaoCargo) {
                    case 1:
                        listaCargos();
                        cargo = atribuiCargoPorCodigo();
                        break;
                    case 2:
                        cargo = this.controladorPrincipal.controladorCargo.cadastraCargoParaFuncionario();
                        break;
                }
                funcionario.setCargo(cargo);
                break;

            case 7:
                menuFuncionario();
                break;
            default:
                editaFuncionario();
                break;
        }
    }

    public void listaFuncionarios() {
        this.telaFuncionario.mensagemListaFuncionarios();
        for (Funcionario funcionarioCadastrado : funcionarios) {
            int matricula = funcionarioCadastrado.getMatricula();
            String nome = funcionarioCadastrado.getNome();
            Date dataNascimento = funcionarioCadastrado.getDataNascimento();
            int telefone = funcionarioCadastrado.getTelefone();
            int salario = funcionarioCadastrado.getSalario();
            Cargo cargo = funcionarioCadastrado.getCargo();
            this.telaFuncionario.exibeFuncionario(matricula, nome, dataNascimento, telefone, salario, cargo);
        }
        menuFuncionario();
    }

    public void menuDeletarFuncionario() {
        this.telaFuncionario.mensagemDeletaFuncionario();
        Funcionario funcionario = pedeFuncionario();
        this.telaFuncionario.exibeFuncionarioSelecionado();
        this.telaFuncionario.exibeFuncionario(funcionario.getMatricula(), funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getTelefone(), funcionario.getSalario(), funcionario.getCargo());
        int opcao = this.telaFuncionario.exibeMenuDeletaFuncionario();

        switch (opcao) {
            case 1:
                deletaFuncionario(funcionario);
                menuFuncionario();
                break;
            case 2:
                menuFuncionario();
                break;
            default:
                menuDeletarFuncionario();
                break;
        }
    }

    public void deletaFuncionario(Funcionario funcionario) {
        if (funcionario != null) {
            if (funcionarios.contains(funcionario)) {
                funcionarios.remove(funcionario);
                funcionario = null;
            }
        }
    }

    public Funcionario findFuncionarioByMatricula(int matricula) {
        for (Funcionario funcionarioCadastrado : this.funcionarios) {
            if (matricula == funcionarioCadastrado.getMatricula()) {
                return funcionarioCadastrado;
            }
        }
        return null;
    }

    public Funcionario pedeFuncionario() {
        int matricula = this.telaFuncionario.pedeMatricula();
        Funcionario funcionario = findFuncionarioByMatricula(matricula);
        return funcionario;
    }

    private void listaCargos() {
        ArrayList<Cargo> cargos = controladorPrincipal.controladorCargo.getCargos();
        for (Cargo cargoListado : cargos) {
            this.telaFuncionario.listaCargo(cargoListado.getCodigo(), cargoListado.getNome());
        }
    }

    private Cargo atribuiCargoPorCodigo() {
        int codigo = this.telaFuncionario.pedeCodigo();
        ArrayList<Cargo> cargos = controladorPrincipal.controladorCargo.getCargos();
        for (Cargo cargoListado : cargos) {
            if (cargoListado.getCodigo() == this.telaFuncionario.pedeCodigo()) {
                return cargoListado;
            }
        }
        atribuiCargoPorCodigo();
        return null;
    }

    public int cadastraMatricula() {
        int matricula = this.telaFuncionario.pedeMatricula();
        for (Funcionario funcionarioCadastrado : funcionarios) {
            if (funcionarioCadastrado.getMatricula() == matricula) {
                this.telaFuncionario.mensagemErroMatriculaJaCadastrada();
            }
            cadastraMatricula();
        }
        return matricula;
    }

}
