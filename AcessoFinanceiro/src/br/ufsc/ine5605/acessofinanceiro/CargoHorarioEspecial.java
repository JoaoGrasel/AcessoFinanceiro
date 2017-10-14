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
 * @author bruno
 */
public class CargoHorarioEspecial extends Cargo {

//	private Date horaInicioManha;
//	private Date horaInicioTarde;
//	private Date horaFimManha;
//	private Date horaFimTarde;
	
	private Date horaInicio;
	private Date horaFim;
	private SimpleDateFormat formatador;
	
//    public CargoHorarioEspecial(int codigo, String nome) {
	public CargoHorarioEspecial(int codigo, String nome, Date horaInicio, Date horaFim) {
        super(codigo, nome, false, true);
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.formatador = new SimpleDateFormat("HH:mm");
    }

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String hora) throws ParseException {
		this.horaInicio = formatador.parse(hora);
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String hora) throws ParseException {
		this.horaFim = formatador.parse(hora);
	}
	
//	public Date getHoraInicioManha() {
//		if(ControladorPrincipal.getInstance().getDataSistema().getYear() != this.horaInicioManha.getYear() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getMonth() != this.horaInicioManha.getMonth() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getDay() != this.horaInicioManha.getDay()) {
//			atualizaHoraInicioManha(
//				ControladorPrincipal.getInstance().getDataSistema().getYear(),
//				ControladorPrincipal.getInstance().getDataSistema().getMonth(),
//				ControladorPrincipal.getInstance().getDataSistema().getDay()
//			);
//		}
//		return horaInicioManha;
//	}
//
//	public void setHoraInicioManha(Date horaInicioManha) {
//		this.horaInicioManha = ControladorPrincipal.getInstance().getDataSistema();
//		this.horaInicioManha.setHours(horaInicioManha.getHours());
//		this.horaInicioManha.setMinutes(horaInicioManha.getMinutes());
//	}
//
//	public Date getHoraInicioTarde() {
//		if(ControladorPrincipal.getInstance().getDataSistema().getYear() != this.horaInicioTarde.getYear() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getMonth() != this.horaInicioTarde.getMonth() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getDay() != this.horaInicioTarde.getDay()) {
//			atualizaHoraInicioTarde(
//				ControladorPrincipal.getInstance().getDataSistema().getYear(),
//				ControladorPrincipal.getInstance().getDataSistema().getMonth(),
//				ControladorPrincipal.getInstance().getDataSistema().getDay()
//			);
//		}
//		return horaInicioTarde;
//	}
//
//	public void setHoraInicioTarde(Date horaInicioTarde) {
//		this.horaInicioTarde = ControladorPrincipal.getInstance().getDataSistema();
//		this.horaInicioTarde.setHours(horaInicioTarde.getHours());
//		this.horaInicioTarde.setMinutes(horaInicioTarde.getMinutes());
//	}
//
//	public Date getHoraFimManha() {
//		if(ControladorPrincipal.getInstance().getDataSistema().getYear() != this.horaFimManha.getYear() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getMonth() != this.horaFimManha.getMonth() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getDay() != this.horaFimManha.getDay()) {
//			atualizaHoraFimManha(
//				ControladorPrincipal.getInstance().getDataSistema().getYear(),
//				ControladorPrincipal.getInstance().getDataSistema().getMonth(),
//				ControladorPrincipal.getInstance().getDataSistema().getDay()
//			);
//		}
//		return horaFimManha;
//	}
//
//	public void setHoraFimManha(Date horaFimManha) {
//		this.horaFimManha = ControladorPrincipal.getInstance().getDataSistema();
//		this.horaFimManha.setHours(horaFimManha.getHours());
//		this.horaFimManha.setMinutes(horaFimManha.getMinutes());
//	}
//
//	public Date getHoraFimTarde() {
//		if(ControladorPrincipal.getInstance().getDataSistema().getYear() != this.horaFimTarde.getYear() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getMonth() != this.horaFimTarde.getMonth() ||
//		   ControladorPrincipal.getInstance().getDataSistema().getDay() != this.horaFimTarde.getDay()) {
//			atualizaHoraFimTarde(
//				ControladorPrincipal.getInstance().getDataSistema().getYear(),
//				ControladorPrincipal.getInstance().getDataSistema().getMonth(),
//				ControladorPrincipal.getInstance().getDataSistema().getDay()
//			);
//		}
//		return horaFimTarde;
//	}
//
//	public void setHoraFimTarde(Date horaFimTarde) {
//		this.horaFimTarde = ControladorPrincipal.getInstance().getDataSistema();
//		this.horaFimTarde.setHours(horaFimTarde.getHours());
//		this.horaFimTarde.setMinutes(horaFimTarde.getMinutes());
//	}
//
//	public void atualizaHoraInicioManha(int ano, int mes, int dia) {
//		this.horaInicioManha.setYear(ano);
//		this.horaInicioManha.setMonth(mes);
//		this.horaInicioManha.setDate(dia);
//		System.out.println(this.horaInicioManha);
//	}
//
//	public void atualizaHoraInicioTarde(int ano, int mes, int dia) {
//		this.horaInicioTarde.setYear(ano);
//		this.horaInicioTarde.setMonth(mes);
//		this.horaInicioTarde.setDate(dia);
//		System.out.println(this.horaInicioTarde);
//	}
//    
//	public void atualizaHoraFimManha(int ano, int mes, int dia) {
//		this.horaFimManha.setYear(ano);
//		this.horaFimManha.setMonth(mes);
//		this.horaFimManha.setDate(dia);
//		System.out.println(this.horaFimManha);
//	}
//	
//	public void atualizaHoraFimTarde(int ano, int mes, int dia) {
//		this.horaFimTarde.setYear(ano);
//		this.horaFimTarde.setMonth(mes);
//		this.horaFimTarde.setDate(dia);
//		System.out.println(this.horaFimTarde);
//	}
	
}
