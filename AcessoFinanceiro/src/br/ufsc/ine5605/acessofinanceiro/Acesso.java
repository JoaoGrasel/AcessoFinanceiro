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
 * @author thiagobrezinski
 */
public class Acesso {
	
    private Date data;
    private int matricula;
	private ControladorAcesso controladorAcesso;
    
    public Acesso(Date data, int matricula) {
        this.data = data;
        this.matricula = matricula;
        this.controladorAcesso = new ControladorAcesso();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

	/**
	 * Verifica se o cargo do funcionario recebido eh gerencial ou se permite
	 * acesso ao financeiro. Se for gerencial ou se o horario do cargo com acesso
	 * estiver valido permite o acesso.
	 * 
	 * @param acesso Acesso tentado pelo funcionario
	 * @param funcionario Funcionario que tentou o acesso
	 * @param data Data da tentativa de acesso
	 * @return True se o acesso for validado
	 */
	public boolean validaAcesso(Acesso acesso, Funcionario funcionario, Date data) throws ParseException {
		if(funcionario.getCargo().ehGerencial()) return true;
		if(funcionario.getCargo().temAcessoAoFinanceiro())
			return validaHorarioAcesso(acesso, funcionario.getCargo(), data);
		controladorAcesso.novoRegistroAcessoNegado(data, acesso.getMatricula(), Motivo.CARGO_SEM_ACESSO);
		controladorAcesso.exibeAcessoNegadoCargoSemAcesso();
		return false;
	}

	/**
	 * Verifica se o horario que o funcionario tentou o acesso confere com o
	 * horario em que ele eh permitido acessar.
	 * 
	 * @param acesso Acesso tentado pelo funcionario
	 * @param cargo Cargo do funcionario
	 * @param data Data da tentativa de acesso
	 * @return True se o horario da tentativa de acesso estiver dentro do
	 * permitido pelo cargo
	 */
	public boolean validaHorarioAcesso(Acesso acesso, Cargo cargo, Date data) throws ParseException {
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
			Date horaAtual = formatador.parse(formatador.format(acesso.getData()));
			if(cargo instanceof CargoHorarioComercial) {
				if((horaAtual.after(((CargoHorarioComercial) cargo).getHoraInicioManha()) &&
						horaAtual.before(((CargoHorarioComercial) cargo).getHoraFimManha())) ||
				   (horaAtual.after(((CargoHorarioComercial) cargo).getHoraInicioTarde()) &&
						horaAtual.before(((CargoHorarioComercial) cargo).getHoraFimTarde()))) {
					System.out.println("acessou - RETIRAR");
					return true;
				}
			}
			if(cargo instanceof CargoHorarioEspecial) {
//				if((horaAtual.after(((CargoHorarioEspecial) cargo).getHoraInicioManha()) &&
//						horaAtual.before(((CargoHorarioEspecial) cargo).getHoraFimManha())) ||
//				   (horaAtual.after(((CargoHorarioEspecial) cargo).getHoraInicioTarde()) &&
//						horaAtual.before(((CargoHorarioEspecial) cargo).getHoraFimTarde()))) {
				if(horaAtual.after(((CargoHorarioEspecial) cargo).getHoraInicio()) &&
						horaAtual.before(((CargoHorarioEspecial) cargo).getHoraFim())) {
					System.out.println("acessou especial - RETIRAR");
					return true;
				} else if(((CargoHorarioComercial) cargo).getHoraInicioTarde().after(((CargoHorarioComercial) cargo).getHoraFimTarde())) {
					Date meiaNoite = formatador.parse("00:00");
					System.out.println("inicio depois do fim");
					if((horaAtual.after(((CargoHorarioEspecial) cargo).getHoraInicio()) && horaAtual.before(meiaNoite)) ||
							horaAtual.after(meiaNoite) && horaAtual.before(((CargoHorarioEspecial) cargo).getHoraFim())) {
						return true;
					}
				}
			}
		controladorAcesso.novoRegistroAcessoNegado(data, acesso.getMatricula(), Motivo.HORARIO_NAO_PERMITIDO);
		controladorAcesso.exibeAcessoNegadoHorarioNaoPermitido();
		return false;
	}
    
}
