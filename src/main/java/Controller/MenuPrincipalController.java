/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.MenuPrincipalHelper;
import Model.Agendamento;
import Model.DAO.AgendamentoDAO;
import View.Agenda;
import View.MenuPrincipal;
import dao.JPAUtil;
import java.time.Clock;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tiago
 */
public class MenuPrincipalController {

    private final MenuPrincipal view;
    private final MenuPrincipalHelper helper;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
        this.helper = new MenuPrincipalHelper(view);
    }
    
    
    public void navegarParaAgenda(){
        
        Agenda agenda = new Agenda();
        agenda.setVisible(true);       
    }
    
    public void atualizaAgendamentos() {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(em);
        
        List<Agendamento> agendamentos = agendamentoDAO.selectAllById(LoginController.getUsuarioLogado());
        
        helper.preencherAgendamentos(agendamentos);
        em.getTransaction().commit();
	em.close();
    }
    
    public void atualizarIdAgendamentos(){
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(em);
        
        List<Agendamento> agendamentos = agendamentoDAO.selectAllById(LoginController.getUsuarioLogado());
        
        helper.preencherIdAgendamentos(agendamentos);
        em.getTransaction().commit();
	em.close();
    }
    
    public void deletarAgendamento(){
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(em);
        
        Agendamento agendamento;
        
        agendamento = agendamentoDAO.selectById(helper.obterId());
        
        agendamentoDAO.delete(agendamento);
        
        em.getTransaction().commit();
	em.close();
    }
}
