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
public class ControladorDataSistema implements IControladorDataSistema {

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
                dataHoraSistema = alteraDataHoraSistema();
                exibeDataHoraSistema();
                this.telaDataHora.exibeConfirmacaoDataHoraSistema();
                controlaConfirmacaoDataHoraSistema();
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

    private Date alteraDataHoraSistema() {
        String dataEHoraInseridos = this.telaDataHora.pedeDataHoraSistema();
        try {
            Date dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm")
                    .parse(dataEHoraInseridos);
            return dataEHora;
        } catch (ParseException ex) {
            this.telaDataHora.mensagemDataInvalida();
            alteraDataHoraSistema();
        }
        return null;
    }

    @Override
    public Date getDataSistema() {
        return this.dataHoraSistema;
    }

    private void controlaConfirmacaoDataHoraSistema() {
        int opcao = this.telaDataHora.pedeOpcao();
        switch (opcao) {
            case 1:
                this.telaDataHora.mensagemDataHoraAtualizadosSucesso();
                menuDataHoraSistema();
                break;
            case 2:
                this.telaDataHora.mensagemDataHoraNaoAtualizados();
                alteraDataHoraSistema();
                break;
            default:
                this.telaDataHora.opcaoInexistente();
                controlaConfirmacaoDataHoraSistema();
                break;
        }
    }
}
