/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vladimir
 */
public class ControladorDataSistema {

    private TelaDataHoraSistema telaDataHora;
    private ControladorPrincipal controladorPrincipal;
    private Date dataHoraSistema;

    public ControladorDataSistema(ControladorPrincipal owner) {
        this.controladorPrincipal = owner;
        this.telaDataHora = new TelaDataHoraSistema(this);
        this.dataHoraSistema = new Date();
    }

    public void menuDataHoraSistema() {
        exibeDataHoraSistema();
        exibeMenuDataHoraSistema();
        controlaMenuDataHoraSistema();
    }

    public void exibeDataHoraSistema() {
        this.telaDataHora.exibeDataHoraSistema(dataHoraSistema);
    }

    public void exibeMenuDataHoraSistema() {
        this.telaDataHora.exibeMenuDataHoraSistema();
    }

    private void controlaMenuDataHoraSistema() {
        int opcao = this.telaDataHora.pedeOpcao();
        switch (opcao) {
            case 1:
                alteraDataHoraSistema();
                break;
            case 2:
                this.controladorPrincipal.exibeMenuPrincipal();
                break;
            default:
                this.telaDataHora.opcaoInexistente();
                controlaMenuDataHoraSistema();
                break;
        }
    }

    private void alteraDataHoraSistema() {
        String dataEHora = this.telaDataHora.pedeDataHoraSistema();
        SimpleDateFormat formatadorDataNascimento = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = formatadorDataNascimento.parse(dataNascimentoInserida);
        try {
            dataNascimento = formatadorDataNascimento.parse(formatadorDataNascimento.format(dataNascimentoInserida));

        } catch (ParseException ex) {
            System.out.println("Data invalida");
        }
    }

}
