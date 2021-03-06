package main.Controller;

import main.Model.AsesorComercial;
import main.Model.Campania;
import main.Model.Libranza;
import main.Model.Usuario;
import main.Model.Consumo;
import main.Model.CampaniaAplicada;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import main.View.TabbedPane;

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

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.tblResultadosUsuaros = interfaz.tblUsuario;
        this.tblResultadoscampania = interfaz.tblCampania;
        this.tblResultadoscampaniasAplicadas = interfaz.tblCampaniaAplicada;
        this.tblResultadoConsumo = interfaz.tblConsumo;
        this.tblResultadoAsesor = interfaz.tblAsesor;
        this.tblResultadolibraza = interfaz.tblLibranza;
        this.tblResultadoGeneral = interfaz.tblGeneral1;
        this.tblResultadoGeneral2 = interfaz.tblGeneral2;

        InitialData initialData = new InitialData();
        //inicalizamos las tablas de la interfaz
        this.setTblResultadosGeneral2(initialData.getConsultaLibranza());
        this.setTblResultadosGeneral(initialData.getConsultaConsumo());
        this.setTblResultadosConsumo(initialData.getConsumos());
        this.setTblResultadosCampanias(initialData.getCampanias());
        this.setTblResultadosCampaniasAplicadas(initialData.getCampaniasAplicadas());
        this.setTblResultadosUsuario(initialData.getUsuarios());
        this.setTblResultadosAsesor(initialData.getAsesores());
        this.setTblResultadoslibranza(initialData.getLibranzas());
        //el control de los botones de la interfas
        interfaz.btnCampaniaBorrar.setEnabled(false);
        interfaz.brnCampaniaAplicadaBorrar.setEnabled(false);
        interfaz.btnConsumoBorrar.setEnabled(false);
        interfaz.btnLibranzaBorrar.setEnabled(false);
        interfaz.btnUsuarioBorrar.setEnabled(false);
        interfaz.btnAsesorBorrar.setEnabled(false);
        interfaz.btnCampaniaEditar.setEnabled(false);
        interfaz.btnCampaniaAgregar.setEnabled(true);
        interfaz.brnCampaniaAplicadaAgregar.setEnabled(true);
        interfaz.brnCampaniaAplicadaEditar.setEnabled(false);
        interfaz.btnConsumoEditar.setEnabled(false);
        interfaz.btnConsumoAgregar.setEnabled(true);
        interfaz.btnLibranzaAgregar.setEnabled(true);
        interfaz.btnLibranzaEditar.setEnabled(false);
        interfaz.btnUsuarioAgregar.setEnabled(true);
        interfaz.btnUsuarioEditar.setEnabled(false);
        interfaz.btnAsesorAgregar.setEnabled(true);
        interfaz.btnAsesorEditar.setEnabled(false);

    }
    //llenado de todsa las tablas con la informacion equeridad 
    public void setTblResultadosUsuario(ArrayList<Usuario> usuarioModelBLs) {
        String[] headers = {"Alias", "Nombres", "Apellidos", "Email", "Celular", "Clave", "Fecha de nacimiento"};
        this.tblResultadosUsuaros.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadosUsuaros.setModel(tableModel);
        for (int i = 0; i < usuarioModelBLs.size(); i++) {
            tableModel.addRow(usuarioModelBLs.get(i).toArray());
        }
    }

    public void setTblResultadosCampanias(ArrayList<Campania> campanias) {
        String[] headers = {"ID", "Descripci??n"};
        this.tblResultadoscampania.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoscampania.setModel(tableModel);
        for (int i = 0; i < campanias.size(); i++) {
            tableModel.addRow(campanias.get(i).toArray());
        }
    }

    public void setTblResultadosCampaniasAplicadas(ArrayList<CampaniaAplicada> campaniaAplicadas) {
        String[] headers = {"Cr??dito No.", "Nombre usuario", "Descripci??n campa??a", "Fecha de aplicaci??n", "ID campa??a", "Alias usuario"};
        this.tblResultadoscampaniasAplicadas.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoscampaniasAplicadas.setModel(tableModel);
        for (int i = 0; i < campaniaAplicadas.size(); i++) {
            tableModel.addRow(campaniaAplicadas.get(i).toArray());
        }
    }

    public void setTblResultadosConsumo(ArrayList<Consumo> consumos) {
        String[] headers = {"ID", "Descripci??n campa??a", "Cuotas", "Tasa de inter??s", "Nombre asesor", "ID asesor", "ID campa??a"};
        this.tblResultadoConsumo.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoConsumo.setModel(tableModel);
        for (int i = 0; i < consumos.size(); i++) {
            tableModel.addRow(consumos.get(i).toArray());
        }
    }

    public void setTblResultadosAsesor(ArrayList<AsesorComercial> asesorComercials) {
        String[] headers = {"ID", "Nombres", "Apellidos", "Sucursal bancaria"};
        this.tblResultadoAsesor.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoAsesor.setModel(tableModel);
        for (int i = 0; i < asesorComercials.size(); i++) {
            tableModel.addRow(asesorComercials.get(i).toArray());
        }
    }

    public void setTblResultadoslibranza(ArrayList<Libranza> libranzas) {
        String[] headers = {"ID", "Descripci??n campa??a", "Empresa", "Meses de plazo", "Tasa de inter??s", "ID campa??a"};
        this.tblResultadolibraza.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadolibraza.setModel(tableModel);
        for (int i = 0; i < libranzas.size(); i++) {
            tableModel.addRow(libranzas.get(i).toArray());
        }
    }

    public void setTblResultadosGeneral(ArrayList<CampaniaAplicada> general) {
        String[] headers = {"ID", "Nombre usuario", "Descripci??n campa??a", "Nombre asesor", "Fecha aplicaci??n", "Alias usuario", "ID campa??a"};
        this.tblResultadoGeneral.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoGeneral.setModel(tableModel);
        for (int i = 0; i < general.size(); i++) {
            tableModel.addRow(general.get(i).toArrayconsumo());
        }
    }

    public void setTblResultadosGeneral2(ArrayList<CampaniaAplicada> general) {
        String[] headers = {"ID", "Nombre usuario", "Descripci??n campa??a", "Empresa", "Fecha aplicaci??n", "Alias usuario", "ID campa??a"};
        this.tblResultadoGeneral2.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultadoGeneral2.setModel(tableModel);
        for (int i = 0; i < general.size(); i++) {
            tableModel.addRow(general.get(i).toArraylibranza());
        }
    }

}
