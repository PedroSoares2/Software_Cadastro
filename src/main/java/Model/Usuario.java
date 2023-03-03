/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;

/**
 * Classe representa um usuario do sistema
 * @author tiago
 */

@Entity
public class Usuario extends Pessoa{

    private String senha;

    /**
     *  Construtor Cmpleto da Classe Usuario
     * @param id identificador
     * @param nome
     * @param sexo
     * @param dataNascimento
     * @param telefone
     * @param email
     * @param rg
     * @param senha
     */
    public Usuario(String nome, String sexo, String dataNascimento, String telefone, String email, String rg, String senha) {
        super(nome, sexo, dataNascimento, telefone, email, rg);
        this.senha = senha;
    }

    public Usuario(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }

    public Usuario() {
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
