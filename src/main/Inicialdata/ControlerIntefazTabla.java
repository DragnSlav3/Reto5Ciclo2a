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
public class ControlerIntefazTabla {

    private TabbedPane interfaz = null;
    private InitialData inicialdata = null;
    private JTable tblResultadosUsuaros;
    private JTable tblResultadoscampania;
    private JTable tblResultadoscampaniasAplicadas;
    private JTable tblResultadoConsumo;
    private JTable tblResultadoAsesor;
    private JTable tblResultadolibraza;
    private JTable tblResultadoGeneral;
    private JTable tblResultadoGeneral2;

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
        this.tblResultadoscampaniasAplicadas = interfaz.tblCampaniaAplicada;
        this.tblResultadoConsumo = interfaz.tblConsumo;
        this.tblResultadoAsesor = interfaz.tblAsesor;
        this.tblResultadolibraza = interfaz.tblLibranza;
        this.tblResultadoGeneral = interfaz.tblGeneral1;
        this.tblResultadoGeneral2 = interfaz.tblGeneral2;
        
        InitialData initialData = new InitialData();
        
        this.setTblResultadosGeneral2(initialData.getConsultaLibranza());
        this.setTblResultadosGeneral(initialData.getConsultaConsumo());
        this.setTblResultadosConsumo(initialData.getConsumos());
        this.setTblResultadosCampanias(initialData.getCampanias());
        this.setTblResultadosCampaniasAplicadas(initialData.getCampaniasAplicadas());
        this.setTblResultadosUsuario(initialData.getUsuarios());
        this.setTblResultadosAsesor(initialData.getAsesores());
        this.setTblResultadoslibranza(initialData.getLibranzas());
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
    }

    public void setTblResultadosCampaniasAplicadas(ArrayList<CampaniaAplicada> campaniaAplicadas) {
        String[] headers = {"CRÉDITO No.", "NOMBRE DEL CLIENTE", "CAMPAÑA DESCRISCION", "FECHA DE APLICACION", "ID CAMPAÑA", "ALIAS USARIO"};
        this.tblResultadoscampaniasAplicadas.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoscampaniasAplicadas.setModel(tableModel);
        for (int i = 0; i < campaniaAplicadas.size(); i++) {
            tableModel.addRow(campaniaAplicadas.get(i).toArray());
        }
    }

    public void setTblResultadosConsumo(ArrayList<Consumo> consumos) {
        String[] headers = {"ID", "DESCRIPCION DE CAMPAÑA", "CUOTAS", "TASA DE INTERES", "NOMBRE DEL ASESOR"};
        this.tblResultadoConsumo.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoConsumo.setModel(tableModel);
        for (int i = 0; i < consumos.size(); i++) {
            tableModel.addRow(consumos.get(i).toArray());
        }
    }

    public void setTblResultadosAsesor(ArrayList<AsesorComercial> asesorComercials) {
        String[] headers = {"ID", "NOMBRE", "APELLIDO", "SURCUSAL BANCARIA"};
        this.tblResultadoAsesor.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoAsesor.setModel(tableModel);
        for (int i = 0; i < asesorComercials.size(); i++) {
            tableModel.addRow(asesorComercials.get(i).toArray());
        }
    }

    public void setTblResultadoslibranza(ArrayList<Libranza> libranzas) {
        String[] headers = {"ID", "DESCRPCION DE CAMPAÑA", "EMPRESA", "MESES DE PLAZO", "TAZA DE INTERES"};
        this.tblResultadolibraza.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadolibraza.setModel(tableModel);
        for (int i = 0; i < libranzas.size(); i++) {
            tableModel.addRow(libranzas.get(i).toArray());
        }
    }

    public void setTblResultadosGeneral(ArrayList<CampaniaAplicada> general) {
        String[] headers = {"ID", "NOMBRE DE USUARO", "DESCRPCION DE CAMPAÑA", "NOMBRE DE ASESOR", "FECHA DE APLICACION ", "ALIAS DE USUARIO", "ID CAMPAÑA"};
        this.tblResultadoGeneral.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoGeneral.setModel(tableModel);
        for (int i = 0; i < general.size(); i++) {
            tableModel.addRow(general.get(i).toArrayconsumo());
        }
    }

    public void setTblResultadosGeneral2(ArrayList<CampaniaAplicada> general) {
        String[] headers = {"ID", "NOMBRE DE USUARO", "DESCRPCION DE CAMPAÑA", "EMPREZA", "FECHA DE APLICACION ", "ALIAS DE USUARIO", "ID CAMPAÑA"};
        this.tblResultadoGeneral2.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoGeneral2.setModel(tableModel);
        for (int i = 0; i < general.size(); i++) {
            tableModel.addRow(general.get(i).toArraylibranza());
        }
    }

}
