/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Date;

/**
 *
 * @author vladimir
 */
public class ControladorDataSistema {

    private TelaDataSistema telaData;
    private ControladorPrincipal controlador;
    private Date dataSistema;

    public ControladorDataSistema(ControladorPrincipal owner) {
        this.controlador = owner;
        this.telaData = new TelaDataSistema(this);
        this.dataSistema =
    }

    public void exibeMenuDataSistema() {
        exibeDataHoraSistema();
        int opcao = this.telaData.exibeMenuDataSistema();
        controlaMenuDataSistema(opcao);
    }

    public void exibeDataHoraSistema() {
        this.telaData.exibeDataHoraSistema(dataSistema);
    }

    private void controlaMenuDataSistema(int opcao) {
        switch (opcao) {
            case 1:
                alteraDataSistema();
                break;
        }
    }

    private void alteraDataSistema() {
        this.telaData.pedeDataSistema();
    }

}
