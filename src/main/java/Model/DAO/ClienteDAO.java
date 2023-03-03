/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tiago
 */
public class ClienteDAO {
    
    
    /**
     * Insere um cliente dentro do banco de dados
     * @param cliente exige que seja passado um objeto do tipo cliente
     */
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }
    
    public void insert(Cliente cliente){
        em.persist(cliente);
    }
   
    public void delete(Cliente cliente){
        cliente = em.merge(cliente);
        em.remove(cliente);
    }
    
    /**
     * Retorna um arraylist com todos os clientes do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public List<Cliente> selectAll(){
        String jpql = "select c from Cliente as c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param cliente
     * @param clienteAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Cliente cliente, Cliente clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }
    
    
    
}
