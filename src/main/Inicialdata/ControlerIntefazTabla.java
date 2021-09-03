/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Inicialdata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import main.accessDAL.*;
import main.modelBL.*;
import main.view.TabbedPane;

/**
 *
 * @author COMPUMAX
 */
public class ControlerIntefazTabla  {

    private TabbedPane interfaz = null;
      private InitialData inicialdata = null;
    private JTable tblResultadosUsuaros;
     private JTable tblResultadoscampania;
      private JTable tblResultadoscampaniasAplicadas;
       private JTable tblResultadoConsumo;
       

    public ControlerIntefazTabla(TabbedPane tabbedPane) {
        this.interfaz = tabbedPane;
  
      
        
        
    }
  public void iniciarVista() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        interfaz.setLocationRelativeTo(null);

     this.tblResultadosUsuaros = interfaz.tblUsuario;
     this.tblResultadoscampania = interfaz.tblCampania;
        InitialData initialData = new InitialData();
           this.setTblResultadosCampanias(initialData.getCampanias());
        
        this.setTblResultadosUsuario(initialData.getUsuarios()); 
     

    }
  

     
     public void setTblResultadosUsuario(ArrayList<UsuarioModelBL> usuarioModelBLs) {
        String[] headers = {"Alias", "Nombre", "Apellido", "Email", "Celular", "Clave", "Fecha de nacimiento"};
        this.tblResultadosUsuaros.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadosUsuaros.setModel(tableModel);
        for (int i = 0; i < usuarioModelBLs.size(); i++) {
            tableModel.addRow(usuarioModelBLs.get(i).toArray());
        }
    }
       public void setTblResultadosCampanias(ArrayList<Campania> campanias) {
        String[] headers = {"ID", "DESCRIPCION"};
        this.tblResultadoscampania.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoscampania.setModel(tableModel);
        for (int i = 0; i < campanias.size(); i++) {
            tableModel.addRow(campanias.get(i).toArray());
        }
    }  public void setTblResultadosCampaniasAplicadas(ArrayList<UsuarioModelBL> usuarioModelBLs) {
        String[] headers = {"Alias", "Nombre", "Apellido", "Email", "Celular", "Clave", "Fecha de nacimiento"};
        this.tblResultadosUsuaros.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadosUsuaros.setModel(tableModel);
        for (int i = 0; i < usuarioModelBLs.size(); i++) {
            tableModel.addRow(usuarioModelBLs.get(i).toArray());
        }
    }
    

}
