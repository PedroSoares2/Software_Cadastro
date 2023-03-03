/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Agendamento;
import Model.Cliente;
import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tiago
 */
public class AgendamentoDAO {
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param agendamento exige que seja passado um objeto do tipo agendamento
     */
    private EntityManager em;

    public AgendamentoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void insert(Agendamento agendamento){
        em.persist(agendamento);
    }
    
    public Agendamento selectById(int id){
        return em.find(Agendamento.class, id);   
    }
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param agendamento
     * @return 
     */
    public void delete(Agendamento agendamento){
        agendamento = em.merge(agendamento);
        em.remove(agendamento);
    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public List<Agendamento> selectAll(){
        String jpql = "select c from Agendamento as c";
        return em.createQuery(jpql, Agendamento.class).getResultList();
    }
    
    public List<Agendamento> selectAllById(Usuario usuario){
        String jpql = "select c from Agendamento c where c.cliente.nome = :nome";
        return em.createQuery(jpql, Agendamento.class).setParameter("nome", usuario.getNome()).getResultList();   
    }
    

    
}
