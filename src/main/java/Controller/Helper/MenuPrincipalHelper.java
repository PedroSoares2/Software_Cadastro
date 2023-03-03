/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;


import Model.Agendamento;
import View.MenuPrincipal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pedro
 */
public class MenuPrincipalHelper {
    
    private final MenuPrincipal view;

    public MenuPrincipalHelper(MenuPrincipal view) {
        this.view = view;
    }
    
    public void preencherAgendamentos(List<Agendamento> agendamentos){
      DefaultTableModel tableModel = (DefaultTableModel) view.getTableMeusAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo o tableModel
        for (Agendamento agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
        }          
    }
    
    public void preencherIdAgendamentos(List<Agendamento> agendamentos){
        
        DefaultComboBoxModel comboBoxmodel = (DefaultComboBoxModel) view.getjComboBox1().getModel();
        comboBoxmodel.removeAllElements();
        
        for (Agendamento agendamento : agendamentos) {
            comboBoxmodel.addElement(agendamento.getId()); //aqui esta a sacada adicionar cliente e nao cliente getnome()          
        }  
    }
    
    public int obterId() {
        return (int) view.getjComboBox1().getSelectedItem();
    }
}
