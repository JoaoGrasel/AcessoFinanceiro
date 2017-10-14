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
public class CargoHorarioComercial extends Cargo {
	
//	private Date horaInicioManha;
//	private Date horaInicioTarde;
//	private Date horaFimManha;
//	private Date horaFimTarde;
	private SimpleDateFormat formatador;
	
    public CargoHorarioComercial(int codigo, String nome) {
        super(codigo, nome, false, true);
		formatador = new SimpleDateFormat("HH:mm");
    }

	public Date getHoraInicioManha() throws ParseException {
		return formatador.parse("08:00");
	}

	public Date getHoraInicioTarde() throws ParseException {
		return formatador.parse("14:00");
	}

	public Date getHoraFimManha() throws ParseException {
		return formatador.parse("12:00");
	}

	public Date getHoraFimTarde() throws ParseException {
		return formatador.parse("18:00");
	}
	
 }
