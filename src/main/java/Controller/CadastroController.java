/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.CadastroHelper;
import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Cadastro;
import dao.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Pedro
 */
public class CadastroController {
    
    private final Cadastro view;
    private final CadastroHelper helper;

    public CadastroController(Cadastro view) {
        this.view = view;
        this.helper = new CadastroHelper(view);
    }
    
    public void salvarCadastro(){
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Usuario usuario = helper.obterModelo();
        Cliente cliente = helper.obterModeloCliente();
        UsuarioDAO userdao = new UsuarioDAO(em);
        ClienteDAO clientedao = new ClienteDAO(em);
        
        clientedao.insert(cliente);
        userdao.insert(usuario);
        em.getTransaction().commit();
	em.close();
    }
}
