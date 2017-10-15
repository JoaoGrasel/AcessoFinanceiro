/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author bruno
 */
public class ControladorCargo implements IControladorCargo {

    private ArrayList<Cargo> cargos;
    private TelaCargo telaCargo;

    public ControladorCargo() {
        this.cargos = new ArrayList<>();
        this.telaCargo = new TelaCargo(this);
    }

    public void exibeMenuCargo() {
        telaCargo.exibeMenuCargo();
        controlaMenuCargo();
    }

    public void controlaMenuCargo() {

        int opcao = this.telaCargo.pedeOpcao();

        switch (opcao) {
            case 1:
                incluiCargo();
                exibeMenuCargo();
                break;
            case 2:
                editaCargo();
                break;
            case 3:
                pedeListaCargos();
                break;
            case 4:
                menuDeletarCargo();
                break;
            case 5:
                ControladorPrincipal.getInstance().exibeMenuPrincipal();
                break;
            default:
                this.telaCargo.opcaoInexistente();
                exibeMenuCargo();
                break;
        }
    }

    public void voltaMenuPrincipal() {
        ControladorPrincipal.getInstance().exibeMenuPrincipal();
    }

    public Cargo incluiCargo() {
        this.telaCargo.mensagemNovoCargo();
        String nome = pedeNome();
        int codigo = verificaCodigoInserido();
        int tipoCargo = this.telaCargo.pedeTipoCargo();
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
		try {
			Date horaInicioManha = formatador.parse(Constantes.HORA_INICIO_MANHA_COMERCIAL);
			Date horaFimManha = formatador.parse(Constantes.HORA_FIM_MANHA_COMERCIAL);
			Date horaInicioTarde = formatador.parse(Constantes.HORA_INICIO_TARDE_COMERCIAL);
			Date horaFimTarde = formatador.parse(Constantes.HORA_FIM_TARDE_COMERCIAL);
			Cargo cargo = new Cargo(codigo, nome, false, true, horaInicioManha, horaFimManha, horaInicioTarde, horaFimTarde);
			switch(tipoCargo){
				case 1:
					cargo.setEhGerencial(true);
					this.cargos.add(cargo);
					this.telaCargo.mensagemCargoCadastrado();
					break;
				case 2:
					this.cargos.add(cargo);
					this.telaCargo.mensagemCargoCadastrado();
					break;
				case 3:
					cargo = criaCargoEspecial(nome, codigo, formatador);
					this.telaCargo.mensagemCargoCadastrado();
					break;
				case 4:
					cargo = criaCargoComum(nome, codigo, formatador);
					this.telaCargo.mensagemCargoCadastrado();
					break;
				case 5:
					cargo.setTemAcessoAoFinanceiro(false);
					this.cargos.add(cargo);
					this.telaCargo.mensagemCargoCadastrado();
					break;
				default:
					this.telaCargo.exibeOpcaoInexistente();
					incluiCargo();
					break;
			}
			return cargo;
		} catch (ParseException e) {
			telaCargo.exibeErroConstantesFormatador();
			ControladorPrincipal.getInstance().exibeMenuPrincipal();
		}
        return null;
    }


    /**
     * Controla o que o sistema faz com base na opcao que o usuario selecionar
     * no menu para deletar o cargo. Caso o usuario aperte 1: deleta o cargo.
     * Caso o usuario aperte 2: volta para o menu principal do cargo. Caso o
     * usuario aperte outra tecla qualquer: apresenta a mensagem de opcao
     * inexistente e exibe o menu de deletar um cargo novamente
     *
     * @param cargo a ser deletado
     */
    public void controlaMenuDeletarCargo(Cargo cargo) {
        int opcao = this.telaCargo.pedeOpcao();
        switch (opcao) {
            case 1:
                deletaCargo(cargo);
                exibeMenuCargo();
                break;
            case 2:
                exibeMenuCargo();
                break;
            default:
                this.telaCargo.opcaoInexistente();
                controlaMenuDeletarCargo(cargo);
                break;
        }
    }

    public void menuDeletarCargo() {
        this.telaCargo.mensagemDeletaCargo();
        Cargo cargo = pedeCargo();
        this.telaCargo.exibeMensagemCargoSelecionado();
        this.telaCargo.exibeCargo(cargo.getCodigo(), cargo.getNome(), cargo.ehGerencial(), cargo.temAcessoAoFinanceiro());
        this.telaCargo.exibeMenuConfirmacaoDeletarCargo();
        controlaMenuDeletarCargo(cargo);
    }

    public void deletaCargo(Cargo cargo) {
        Cargo cargoIndefinido = encontraCargoIndefinido();
        if (cargo != null) {
            ControladorPrincipal.getInstance().deletaCargosFuncionarios(cargo, cargoIndefinido);
            cargos.remove(cargo);
            this.telaCargo.mensagemCargoDeletadoSucesso();                
        }
    }

    public int verificaCodigoInserido() {
        int codigo = this.telaCargo.pedeCodigo();
        for (Cargo cargoCadastrado : this.cargos) {
            if (cargoCadastrado.getCodigo() == codigo) {
                this.telaCargo.mensagemErroCodigoJaCadastrada();
                verificaCodigoInserido();
            }
        }
        return codigo;
    }
    
    /**
     * Pede para o usuário inserir um nome para o cargo, chama o método
     * para verificar se o nome é valido e, caso seja, retorna o nome.
     *
     * @return nome do cargo validado e inserido pelo usuário
     */
    public String pedeNome() {
        String nome = this.telaCargo.pedeNome();
        nome = verificaNome(nome);
        return nome;
    }
    
    public String verificaNome(String nome) {
        if (nome.length() > 2) {
            for (int i = 0; i < nome.length(); i++) {
                char letraAnalisada = nome.charAt(i);
                if (!Character.isLetter(letraAnalisada)) {
                    if (!Character.isSpace(letraAnalisada)) {
                        this.telaCargo.mensagemNomeInvalidoLetras();
                        nome = pedeNome();
                    }
                }
            }
        } else {
            this.telaCargo.mensagemNomeInvalidoTamanho();
            nome = pedeNome();
        }
        return nome;
    }
    
    public void editaCargo() {
        this.telaCargo.mensagemEditaCargo();
        Cargo cargo = pedeCargo();
        this.telaCargo.exibeMensagemCargoSelecionado();
        this.telaCargo.exibeCargo(cargo.getCodigo(), cargo.getNome(), cargo.ehGerencial(), cargo.temAcessoAoFinanceiro());
        menuEditaCargo(cargo);
    }
    
    public void menuEditaCargo(Cargo cargo) {
        this.telaCargo.exibeMenuEditaCargo();
        controlaMenuEditaCargo(cargo);
    }
    
    public void controlaMenuEditaCargo(Cargo cargo) {
        int opcao = this.telaCargo.pedeOpcao();
        
        switch (opcao) {
            case 1:
                String nome = this.telaCargo.pedeNome();
                cargo.setNome(nome);
                this.telaCargo.mensagemNomeEditadoSucesso();
                menuEditaCargo(cargo);
                break;
            case 2:
                int codigo = this.telaCargo.pedeCodigo();
                cargo.setCodigo(codigo);
                this.telaCargo.mensagemCodigoEditadoSucesso();
                menuEditaCargo(cargo);
                break;
            case 3: 
                int opcaoEhGerencial = this.telaCargo.pedeSeEhGerencial();
                atualizaEhGerencial(opcaoEhGerencial, cargo);
                this.telaCargo.mensagemGerencialEditadoSucesso();
                menuEditaCargo(cargo);
                break;
            case 4:
                int opcaoTemAcessoAoFinanceiro = this.telaCargo.pedeTemAcessoAoFinanceiro();
                atualizaTemAcessoAoFinanceiro(opcaoTemAcessoAoFinanceiro, cargo);
                this.telaCargo.mensagemAcessoEditadoSucesso();
                menuEditaCargo(cargo);
                break;
			case 5:
				if(cargo instanceof CargoHorarioEspecial) {
					atualizaHorariosCargoHorarioEspecial(cargo);
					telaCargo.mensagemHorariosEditadosSucesso();
				} else if(cargo.temAcessoAoFinanceiro()) {
					atualizaHorariosCargo(cargo);
					telaCargo.mensagemHorariosEditadosSucesso();
				} else {
					telaCargo.exibeEditaHorariosCargoSemAcesso();
					controlaMenuEditaCargo(cargo);
				}
            case 6:
                exibeMenuCargo();
                break;
            default:
                this.telaCargo.opcaoInexistente();
                editaCargo();
                break;
        }
    }
    
    public void pedeListaCargos() {
        listaCargos();
        exibeMenuCargo();
    }
    
    @Override
    public void listaCargos() {
        this.telaCargo.mensagemListaCargos();
        for (Cargo cargoCadastrado : cargos) {
            int codigo = cargoCadastrado.getCodigo();
            String nome = cargoCadastrado.getNome();
            boolean ehGerencial = cargoCadastrado.ehGerencial();
            boolean temAcessoAoFinanceiro = cargoCadastrado.temAcessoAoFinanceiro();
            this.telaCargo.exibeCargo(codigo, nome, ehGerencial, temAcessoAoFinanceiro);
        }
	
    }

    @Override
    public Cargo encontraCargoPorCodigo(int codigo) {
        for(Cargo cargoLista : this.cargos) {
            if(cargoLista.getCodigo() == codigo) return cargoLista;
        }
        return null;
    }


    public Cargo pedeCargo() {
        int codigo = this.telaCargo.pedeCodigo();
        Cargo cargo = encontraCargoPorCodigo(codigo);
        if (cargo == null) {
            this.telaCargo.mensagemCargoNaoEncontrado();
            cargo = pedeCargo();
        }
        return cargo;
    }

//    public Cargo criaCargoGerencial(String nome, int codigo) {
//        Cargo cargo = new Cargo(codigo, nome, true, true);
//        this.cargos.add(cargo);
//        return cargo;
//    }
//
//    public CargoHorarioComercial criaCargoComercial(String nome, int codigo) {
//        CargoHorarioComercial cargo = new CargoHorarioComercial(codigo, nome);
//        this.cargos.add(cargo);
//        return cargo;
//    }
        
    public CargoHorarioEspecial criaCargoEspecial(String nome, int codigo, SimpleDateFormat formatador) {
//        try {
//            Date horaInicioManha = formatador.parse(this.telaCargo.pedeHoraInicioManha());
//            Date horaFimManha = formatador.parse(this.telaCargo.pedeHoraFimManha());
//            Date horaInicioTarde = formatador.parse(this.telaCargo.pedeHoraInicioTarde());
//            Date horaFimTarde = formatador.parse(this.telaCargo.pedeHoraFimTarde());
//            Date horaInicioEspecial = formatador.parse(this.telaCargo.pedeHoraInicioEspecial());
//            Date horaFimEspecial = formatador.parse(this.telaCargo.pedeHoraFimEspecial());
			Date horaInicioManha = pedeHora(Constantes.DIGITE_HORA_INICIO_MANHA, formatador);
			Date horaFimManha = pedeHora(Constantes.DIGITE_HORA_FIM_MANHA, formatador);
			Date horaInicioTarde = pedeHora(Constantes.DIGITE_HORA_INICIO_TARDE, formatador);
			Date horaFimTarde = pedeHora(Constantes.DIGITE_HORA_FIM_TARDE, formatador);
			Date horaInicioEspecial = pedeHora(Constantes.DIGITE_HORA_INICIO_ESPECIAL, formatador);
			Date horaFimEspecial = pedeHora(Constantes.DIGITE_HORA_FIM_ESPECIAL, formatador);
            CargoHorarioEspecial cargo = new CargoHorarioEspecial(codigo, nome, horaInicioManha, horaFimManha,
			horaInicioTarde, horaFimTarde, horaInicioEspecial, horaFimEspecial);
            this.cargos.add(cargo);
            return cargo;
//        } catch (ParseException e) {
//            this.telaCargo.exibeHoraInseridaFormatoIncorreto();
//            criaCargoEspecial(nome, codigo, formatador);
//        }
//        return null;
    }
    
    public void atualizaEhGerencial(int opcaoEhGerencial, Cargo cargo) {
        switch(opcaoEhGerencial) {
            case 1: 
                cargo.setEhGerencial(true);
                cargo.setTemAcessoAoFinanceiro(true);
                break;
            case 2: 
                cargo.setEhGerencial(false);
                break;
            default:
                this.telaCargo.opcaoInexistente();
                menuEditaCargo(cargo);
                break;
        }
    }
    
    public void atualizaTemAcessoAoFinanceiro(int opcaoTemAcessoAoFinanceiro, Cargo cargo) {
        switch(opcaoTemAcessoAoFinanceiro) {
            case 1: 
                cargo.setTemAcessoAoFinanceiro(true);
                break;
            case 2: 
                cargo.setTemAcessoAoFinanceiro(false);
                break;
            default:
                this.telaCargo.opcaoInexistente();
                menuEditaCargo(cargo);
                break;
        }
    }

    public void criaCargoPadrao() {
		Date dataIndefinida = new Date();
        Cargo cargo = new Cargo(0, Constantes.CARGO_INDEFINIDO, false, false,
		dataIndefinida, dataIndefinida, dataIndefinida, dataIndefinida);
        this.cargos.add(cargo);
    }

    public Cargo encontraCargoIndefinido() {
        return encontraCargoPorCodigo(0);
    }

	public Cargo criaCargoComum(String nome, int codigo, SimpleDateFormat formatador) {
//		try {
			Date horaInicioManha = pedeHora(Constantes.DIGITE_HORA_INICIO_MANHA, formatador);
			Date horaFimManha = pedeHora(Constantes.DIGITE_HORA_FIM_MANHA, formatador);
			Date horaInicioTarde = pedeHora(Constantes.DIGITE_HORA_INICIO_TARDE, formatador);
			Date horaFimTarde = pedeHora(Constantes.DIGITE_HORA_FIM_TARDE, formatador);
			Cargo cargo = new Cargo(codigo, nome, false, true, horaInicioManha, horaFimManha,
			horaInicioTarde, horaFimTarde);
			this.cargos.add(cargo);
			return cargo;
//		} catch (ParseException e) {
//			telaCargo.exibeHoraInseridaFormatoIncorreto();
//			criaCargoComum(nome, codigo, formatador);
//		}
//		return null;
	}

	public void atualizaHorariosCargoHorarioEspecial(Cargo cargo) {
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
		Date horaInicioManha = pedeHora(Constantes.DIGITE_HORA_INICIO_MANHA, formatador);
		Date horaFimManha = pedeHora(Constantes.DIGITE_HORA_FIM_MANHA, formatador);
		Date horaInicioTarde = pedeHora(Constantes.DIGITE_HORA_INICIO_TARDE, formatador);
		Date horaFimTarde = pedeHora(Constantes.DIGITE_HORA_FIM_TARDE, formatador);
		Date horaInicioEspecial = pedeHora(Constantes.DIGITE_HORA_INICIO_ESPECIAL, formatador);
		Date horaFimEspecial = pedeHora(Constantes.DIGITE_HORA_FIM_ESPECIAL, formatador);
		((CargoHorarioEspecial) cargo).setHoraInicioManha(horaInicioManha);
		((CargoHorarioEspecial) cargo).setHoraFimManha(horaFimManha);
		((CargoHorarioEspecial) cargo).setHoraInicioTarde(horaInicioTarde);
		((CargoHorarioEspecial) cargo).setHoraFimTarde(horaFimTarde);
		((CargoHorarioEspecial) cargo).setHoraInicioEspecial(horaInicioEspecial);
		((CargoHorarioEspecial) cargo).setHoraFimEspecial(horaFimEspecial);
	}

	public Date pedeHora(String constante, SimpleDateFormat formatador) {
		try {
			return formatador.parse(telaCargo.pedeHora(constante));
		} catch (ParseException e) {
			telaCargo.exibeHoraInseridaFormatoIncorreto();
			pedeHora(constante, formatador);
		}
		return null;
	}

	public void atualizaHorariosCargo(Cargo cargo) {
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
		Date horaInicioManha = pedeHora(Constantes.DIGITE_HORA_INICIO_MANHA, formatador);
		Date horaFimManha = pedeHora(Constantes.DIGITE_HORA_FIM_MANHA, formatador);
		Date horaInicioTarde = pedeHora(Constantes.DIGITE_HORA_INICIO_TARDE, formatador);
		Date horaFimTarde = pedeHora(Constantes.DIGITE_HORA_FIM_TARDE, formatador);
		cargo.setHoraInicioManha(horaInicioManha);
		cargo.setHoraFimManha(horaFimManha);
		cargo.setHoraInicioTarde(horaInicioTarde);
		cargo.setHoraFimTarde(horaFimTarde);
	}

}
