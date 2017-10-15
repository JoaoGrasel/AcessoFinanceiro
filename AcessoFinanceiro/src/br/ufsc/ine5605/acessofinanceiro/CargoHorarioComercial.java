/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.text.ParseException;
import java.util.Date;

/**
 * @author bruno e thiago
 */
public class CargoHorarioComercial extends Cargo {
	
    public CargoHorarioComercial(int codigo, String nome) {
//		Date horaInicioManha = formatador.parse(Constantes.HORA_INICIO_MANHA_COMERCIAL);
//		Date horaFimManha = formatador.parse(Constantes.HORA_FIM_MANHA_COMERCIAL);
//		Date horaInicioTarde = formatador.parse(Constantes.HORA_INICIO_TARDE_COMERCIAL);
//		Date horaFimTarde = formatador.parse(Constantes.HORA_FIM_TARDE_COMERCIAL);
        super(codigo, nome, false, true, formatador.parse(Constantes.HORA_INICIO_MANHA_COMERCIAL), horaFimManha, horaInicioTarde, horaFimTarde);
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
