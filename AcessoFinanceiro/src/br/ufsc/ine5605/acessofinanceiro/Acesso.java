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

	public boolean validaAcesso(Acesso acesso, Funcionario funcionario, Date data) {
		if(funcionario.getCargo().ehGerente()) return true;
		if(funcionario.getCargo().temAcessoAoFinanceiro())
			return validaHorarioAcesso(acesso, funcionario.getCargo(), data);
		controladorAcesso.novoRegistroAcessoNegado(data, matricula, Motivo.CARGO_SEM_ACESSO);
		controladorAcesso.exibeAcessoNegadoCargoSemAcesso();
		return false;
	}

	public boolean validaHorarioAcesso(Acesso acesso, Cargo cargo, Date data) {
        if(!(acesso.getData().after(cargo.getHorarioInicio()) && acesso.getData().before(cargo.getHorarioFim()))) {
			controladorAcesso.novoRegistroAcessoNegado(data, acesso.getMatricula(), Motivo.HORARIO_NAO_PERMITIDO);
			controladorAcesso.exibeAcessoNegadoHorarioNaoPermitido();
            return false;
        }
        return true;
	}
    
}
