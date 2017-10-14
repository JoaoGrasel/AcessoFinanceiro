/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.Date;

/**
 *
 * @author bruno
 */
public class CargoHorarioComercial extends Cargo {
	
	private Date horaInicioManha;
	private Date horaInicioTarde;
	private Date horaFimManha;
	private Date horaFimTarde;
	
    public CargoHorarioComercial(int codigo, String nome) {
        super(codigo, nome, false, true);
    }

	public Date getHoraInicioManha() {
		this.horaInicioManha = ControladorPrincipal.getInstance().getDataSistema();
		this.horaInicioManha.setHours(8);
		this.horaInicioManha.setMinutes(0);
		this.horaInicioManha.setSeconds(0);
		return this.horaInicioManha;
	}

	public Date getHoraInicioTarde() {
		this.horaInicioTarde = ControladorPrincipal.getInstance().getDataSistema();
		this.horaInicioTarde.setHours(14);
		this.horaInicioTarde.setMinutes(0);
		this.horaInicioTarde.setSeconds(0);
		return horaInicioTarde;
	}

	public Date getHoraFimManha() {
		this.horaFimManha = ControladorPrincipal.getInstance().getDataSistema();
		this.horaFimManha.setHours(12);
		this.horaFimManha.setMinutes(0);
		this.horaFimManha.setSeconds(0);
		return horaFimManha;
	}

	public Date getHoraFimTarde() {
		this.horaFimTarde = ControladorPrincipal.getInstance().getDataSistema();
		this.horaFimTarde.setHours(18);
		this.horaFimTarde.setMinutes(0);
		this.horaFimTarde.setSeconds(0);
		return horaFimTarde;
	}
	
 }
