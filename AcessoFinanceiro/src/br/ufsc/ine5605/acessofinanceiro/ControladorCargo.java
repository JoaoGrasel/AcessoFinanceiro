/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.acessofinanceiro;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class ControladorCargo implements IControladorCargo{
    private ArrayList<Cargo> cargos;
    private ControladorPrincipal controladorPrincipal;
    private TelaCargo telaCargo;

    public ControladorCargo(ControladorPrincipal owner) {
        this.cargos = new ArrayList<>();
        this.telaCargo = new TelaCargo(this);
        this.controladorPrincipal = owner;
    }
    
    public void exibeMenuCargo() {
        telaCargo.exibeMenuCargo();
        controlaMenuCargo();
    }
    
    public void controlaMenuCargo(){
        
        int opcao = this.telaCargo.pedeOpcao();

        switch (opcao) {
            case 1:
                incluiCargo();
                break;
            case 2:
                editaCargo();
                break;
            case 3:
                listaCargo();
                break;
            case 4:
                menuDeletarCargo();
                break;
            case 5:
                this.controladorPrincipal.exibeMenuPrincipal();
                break;
            default:
                this.telaCargo.opcaoInexistente();
                exibeMenuCargo();
                break;
        }
    }
    
    public void voltaMenuPrincipal() {
        controladorPrincipal.exibeMenuPrincipal();
    }
    //COMENTAR ISSO SE PRECISAR TESTAR.
    @Override
    public Cargo encontraCargoPorCodigo(int codigo) {
        return cargos;
    }

    private void incluiCargo() {
    }

    private void editaCargo() {
    }

    private void listaCargo() {
    }

    private void menuDeletarCargo() {
    }
    //COMENTAR ISSO SE PRECISAR TESTAR.
    @Override
    public Cargo cadastraCargoParaFuncionario() {
        
    }

    @Override
    public void listaCargos() {
        this.telaCargo.mensagemListaCargos();
        for (Cargo cargoCadastrado : cargos) {
            int codigo = cargoCadastrado.getCodigo();
            String nome = cargoCadastrado.getNome();
            boolean ehGerente = cargoCadastrado.ehGerente();
            boolean temAcessoAoFinanceiro = cargoCadastrado.temAcessoAoFinanceiro();
            this.telaCargo.exibeCargo(codigo, nome, ehGerente, temAcessoAoFinanceiro);
        }
        exibeMenuCargo();
    }
    
    
}
