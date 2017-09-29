/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Date;

/**
 *
 * @author thiagobrezinski
 */
public class RegistroAcesso {
    
    private Date dataHora;
    private int matricula;
    private Motivo motivo;
    
    public RegistroAcesso(Date dataHora, int matricula, Motivo motivo) {
        this.dataHora = dataHora;
        this.matricula = matricula;
        this.motivo = motivo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }
    
}
