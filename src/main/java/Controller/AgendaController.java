/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import View.MenuPrincipal;
import dao.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tiago
 */
public class AgendaController {

    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(EntityManager em){
        //Buscar Lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(em);
        List<Agendamento> agendamentos = agendamentoDAO.selectAll();//depurar aqui
        
        //Exibir essa lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaClientes(){
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        //Buscar Clientes do banco
        ClienteDAO clienteDAO = new ClienteDAO(em);
        List<Cliente> clientes = clienteDAO.selectAll();
        
        //Exibir clientes no combobox cliente
        helper.preencherClientes(clientes);
        em.getTransaction().commit();
	em.close();
    }
    
    
    public void atualizaServicos(){
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        //Buscar Servicos do Banco
        ServicoDAO servicoDAO = new ServicoDAO(em);
        List<Servico> servicos = servicoDAO.selectAll();
        
        //Exibir Servicos na combobox Servico
        helper.preencherServicos(servicos);
        em.getTransaction().commit();
	em.close();
    }

    public void atualizaValor() {
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }

    public void agendar() {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        //Buscar Objeto Agendamento da Tela
        Agendamento agendamento = helper.obterModelo();
        
        //Salvar no banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(em);
        agendamentoDAO.insert(agendamento);
        
        //atualizar Tabela
        atualizaTabela(em);
        helper.limparTela();
        em.getTransaction().commit();
	em.close();
    }
    
}
