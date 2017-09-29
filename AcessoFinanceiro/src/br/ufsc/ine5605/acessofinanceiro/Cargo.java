/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Cargo {
    private int codigo;
    private String nome;
    // Vai mudar provavelmente.
    private TipoAcesso horario;
    private ArrayList<Funcionario> funcionarios;

    public Cargo(int codigo, String nome, TipoAcesso horario) {
        this.codigo = codigo;
        this.nome = nome;
        this.horario = horario;
        this.funcionarios = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAcesso getHorario() {
        return horario;
    }

    public void setHorario(TipoAcesso horario) {
        this.horario = horario;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}
