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
    private boolean ehGerencial;
    private boolean temAcessoAoFinanceiro;

    public Cargo(int codigo, String nome, boolean ehGerencial, boolean temAcessoAoFinanceiro) {
        this.codigo = codigo;
        this.nome = nome;
        this.ehGerencial = ehGerencial;
        this.temAcessoAoFinanceiro = temAcessoAoFinanceiro;
    }
    
    public boolean ehGerencial(){
        return this.ehGerencial;
    }
    
    public void setEhGerencial(boolean ehGerencial) {
        this.ehGerencial = ehGerencial;
    }
    
    public boolean temAcessoAoFinanceiro() {
        return this.temAcessoAoFinanceiro;
    }
    
    public void setTemAcessoAoFinanceiro(boolean temAcessoAoFinanceiro) {
        this.temAcessoAoFinanceiro = temAcessoAoFinanceiro;
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

}
