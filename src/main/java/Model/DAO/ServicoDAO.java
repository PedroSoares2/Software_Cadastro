/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import Model.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tiago
 */
public class ServicoDAO {
    
    
    /**
     * Insere um servico dentro do banco de dados
     * @param servico exige que seja passado um objeto do tipo servico
     */
    private EntityManager em;

    public ServicoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void insert(Servico servico){
        em.persist(servico);
    }
  
    public void delete(Servico servico){
        servico = em.merge(servico);
        em.remove(servico);
    }
    
    /**
     * Retorna um arraylist com todos os servicos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public List<Servico> selectAll(){
         String jpql = "select c from Servico as c";
        return em.createQuery(jpql, Servico.class).getResultList();
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param servico
     * @param servicoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Servico servico, Servico servicoAComparar) {
        return servico.getId() ==  servicoAComparar.getId();
    }
    
}
