/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Cliente;
import Model.Usuario;
import View.Cadastro;

/**
 *
 * @author Pedro
 */
public class CadastroHelper implements IHelper{
    
    private final Cadastro view;

    public CadastroHelper(Cadastro view) {
        this.view = view;
    }
    
    @Override
    public Usuario obterModelo() {
        String nome = view.getjTextFieldNome().getText();
        String sexo = view.getjTextFieldSexo().getText();
        String dataNascimento = view.getjTextFieldData().getText();
        String telefone = view.getjTextFieldTel().getText();
        String email = view.getjTextFieldemail().getText();
        String rg = view.getjTextFieldrg().getText();
        String senha = view.getjPasswordField1().getText();
        
        return new Usuario(nome,sexo,dataNascimento,telefone,email,rg,senha);
    }
    
    public Cliente obterModeloCliente() {
        String nome = view.getjTextFieldNome().getText();
        String sexo = view.getjTextFieldSexo().getText();
        String dataNascimento = view.getjTextFieldData().getText();
        String telefone = view.getjTextFieldTel().getText();
        String email = view.getjTextFieldemail().getText();
        String rg = view.getjTextFieldrg().getText();
        String endereco = view.getjTextFieldEndereco().getText();
        String cep = view.getjTextFieldcep().getText();

        return new Cliente(nome,sexo,dataNascimento,telefone,email,rg,endereco,cep);
    }

    @Override
    public void limparTela() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
