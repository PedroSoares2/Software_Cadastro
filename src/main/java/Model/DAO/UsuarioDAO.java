/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author tiago
 */
public class UsuarioDAO {
    
    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }
    
    public void insert(Usuario usuario){
        em.persist(usuario);
    }
    
 
    public void delete(Usuario usuario){
        usuario = em.merge(usuario);
        em.remove(usuario);
    }
    
   
    /**
     * Retorna um Objeto do tipo usuario se a funcao encontrar o usuario passado como parâmetro no banco, para considerar sao usado nome e senha
     * @param usuario
     * @return Usuario encontrado no banco de dados
     */
    public Usuario selectPorNomeESenha(Usuario usuario){
        String jpql = "select u from Usuario as u "
                + "where u.nome = :nome and u.senha = :pSenha";
        Usuario user;
        try{
            user = em.createQuery(jpql, Usuario.class).setParameter("nome", usuario.getNome()).setParameter("pSenha", usuario.getSenha()).getSingleResult();
        } catch(NoResultException e) {
            user = null;
        }
        return user;
    }


    /**
     * Recebe dois objetos e verifica se são iguais verificando o nome e senha
     * @param usuario
     * @param usuarioAPesquisar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean nomeESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
        return usuario.getNome().equals(usuarioAPesquisar.getNome()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }

    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param usuario
     * @param usuarioAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
        return usuario.getId() ==  usuarioAComparar.getId();
    }
    
    
    
}
