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
public class ControladorFuncionario implements IControladorFuncionario {

    private TelaFuncionario telaFuncionario;
    private ControladorPrincipal controladorPrincipal;
    private ArrayList<Funcionario> funcionarios;

    public ControladorFuncionario(ControladorPrincipal owner) {
        this.telaFuncionario = new TelaFuncionario(this);
        this.funcionarios = new ArrayList<>();
        this.controladorPrincipal = owner;

    }

    public void exibeMenuFuncionario() {
        telaFuncionario.exibeMenuFuncionario();
        controlaMenuFuncionario();
    }

    public void controlaMenuFuncionario() {
        int opcao = this.telaFuncionario.pedeOpcao();

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
                exibeMenuFuncionario();
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
        this.telaFuncionario.exibeOpcaoCargoFuncionario();
        Cargo cargo = opcaoCargoFuncionario();

        if (!this.funcionarios.contains(encontraFuncionarioPorMatricula(matricula))) {
            Funcionario funcionario = new Funcionario(matricula, nome, dataNascimento, telefone, salario, cargo);
            funcionarios.add(funcionario);
            this.telaFuncionario.mensagemUsuarioCadastrado();
        }
        exibeMenuFuncionario();
    }

    public Cargo opcaoCargoFuncionario() {
        int opcao = this.telaFuncionario.pedeOpcao();
        Cargo cargo = null;
        switch (opcao) {
            case 1:
                listaCargos();
                cargo = atribuiCargoPorCodigo();
                break;
            case 2:
                cargo = this.controladorPrincipal.controladorCargo.cadastraCargoParaFuncionario();
                break;
            default:
                this.telaFuncionario.opcaoInexistente();
                opcaoCargoFuncionario();
                break;
        }
        return cargo;
    }

    public void editaFuncionario() {
        this.telaFuncionario.mensagemEditaFuncionario();
        Funcionario funcionario = pedeFuncionario();
        this.telaFuncionario.exibeMensagemFuncionarioSelecionado();
        this.telaFuncionario.exibeFuncionario(funcionario.getMatricula(), funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getTelefone(), funcionario.getSalario(), funcionario.getCargo());

        this.telaFuncionario.exibeMenuEditaFuncionario();
        controlaMenuEditaFuncionario(funcionario);

    }

    public void controlaMenuEditaFuncionario(Funcionario funcionario) {
        int opcao = this.telaFuncionario.pedeOpcao();

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
                this.telaFuncionario.exibeOpcaoCargoFuncionario();
                Cargo cargo = opcaoCargoFuncionario();
                funcionario.setCargo(cargo);
                break;

            case 7:
                exibeMenuFuncionario();
                break;
            default:
                this.telaFuncionario.opcaoInexistente();
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
        exibeMenuFuncionario();
    }

    public void menuDeletarFuncionario() {
        this.telaFuncionario.mensagemDeletaFuncionario();
        Funcionario funcionario = pedeFuncionario();
        this.telaFuncionario.exibeMensagemFuncionarioSelecionado();
        this.telaFuncionario.exibeFuncionario(funcionario.getMatricula(), funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getTelefone(), funcionario.getSalario(), funcionario.getCargo());
        this.telaFuncionario.exibeMenuDeletaFuncionario();
        controlaMenuDeletarFuncionario(funcionario);
    }

    public void controlaMenuDeletarFuncionario(Funcionario funcionario) {
        int opcao = this.telaFuncionario.pedeOpcao();
        switch (opcao) {
            case 1:
                deletaFuncionario(funcionario);
                exibeMenuFuncionario();
                break;
            case 2:
                exibeMenuFuncionario();
                break;
            default:
                this.telaFuncionario.opcaoInexistente();
                controlaMenuDeletarFuncionario(funcionario);
                break;
        }

    }

    public void deletaFuncionario(Funcionario funcionario) {
        if (funcionario != null) {
            if (funcionarios.contains(funcionario)) {
                funcionarios.remove(funcionario);
                funcionario = null;
                this.telaFuncionario.mensagemFuncionarioDeletadoSucesso();
            }
        }
    }

    public Funcionario encontraFuncionarioPorMatricula(int matricula) {
        for (Funcionario funcionarioCadastrado : this.funcionarios) {
            if (matricula == funcionarioCadastrado.getMatricula()) {
                return funcionarioCadastrado;
            }
        }
        return null;
    }

    public Funcionario pedeFuncionario() {
        int matricula = this.telaFuncionario.pedeMatricula();
        Funcionario funcionario = encontraFuncionarioPorMatricula(matricula);
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
            if (cargoListado.getCodigo() == codigo) {
                return cargoListado;
            }
        }
        this.telaFuncionario.mensagemCargoNaoEncontrado();
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
