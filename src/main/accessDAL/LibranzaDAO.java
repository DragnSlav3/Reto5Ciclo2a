/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.accessDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.modelBL.*;
import utils.ConnectionDB;

/**
 *
 * @author COMPUMAX
 */
public class LibranzaDAO {

    private Connection conn = null;
//obtener todos los creditos de Libranza

    public ArrayList<Libranza> obtenerlLibranza() {
        ArrayList<Libranza> creditoLibranza = new ArrayList<Libranza>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT lbr_id_PRIMARY as \"LLAVE PRINCIPAL\", campania.cmp_descripcion AS \"DESCRIPCION DE CAMPAÑA\" ,lbr_empresa AS \"EMPRESAS\",lbr_meses_plazo AS \"MESES DE PLAZO\", lbr_tasa_interes AS \"TASA DE INTERES\",lbr_id AS \"ID CAMPAÑA\"\n"
                    + "FROM libranza join campania on libranza.lbr_id = campania.cmp_id order by  lbr_id_PRIMARY;";
            Statement statdatosconsul = conn.createStatement();
            ResultSet resultado = statdatosconsul.executeQuery(sql);
            while (resultado.next()) {
                Libranza libranacredi = new Libranza(resultado.getInt(1), resultado.getInt(6), resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getFloat(5));
                creditoLibranza.add(libranacredi);
            }

        } catch (SQLException ex) {
        }
        return creditoLibranza;
    }

   public void AgregarLibranza(Libranza AgregarLibranza) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "insert  libranza(lbr_id,lbr_empresa,lbr_meses_plazo,lbr_tasa_interes) values (?,?,?,?); ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            stadatos.setInt(1, AgregarLibranza.getLbrIdCamapania());
            stadatos.setString(2,AgregarLibranza.getLbrEmpresa());
            stadatos.setInt(3, AgregarLibranza.getLbrMesesPlazo());
            stadatos.setFloat(4,AgregarLibranza.getLbrTasaInteres());

            int NumerosRowsInserted = stadatos.executeUpdate();
            //opcional
            if (NumerosRowsInserted > 0) {
                System.out.println("Insercion exitosa " + NumerosRowsInserted);
            } else {
                System.out.println("No se pudo Insertar los datos ");
            }
        } catch (SQLException ex) {

        }
    }

    public void Actualizarlibranza(Libranza ActualizarLibranza) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE libranza SET lbr_id_PRIMARY = ?, lbr_id = ?, lbr_empresa = ?, lbr_meses_plazo = ?, lbr_tasa_interes = ? WHERE lbr_id_PRIMARY = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setInt(1, ActualizarLibranza.getLbrIdPRIMARY());
            stadatosActualiza.setInt(2, ActualizarLibranza.getLbrIdCamapania());
            stadatosActualiza.setString(3, ActualizarLibranza.getLbrEmpresa());
            stadatosActualiza.setInt(4, ActualizarLibranza.getLbrMesesPlazo());
            stadatosActualiza.setFloat(5, ActualizarLibranza.getLbrTasaInteres());
            stadatosActualiza.setInt(6, ActualizarLibranza.getLbrIdPRIMARY());

            int resulconsul = stadatosActualiza.executeUpdate();
            //OPCIONAL 
            if (resulconsul > 0) {
                System.out.println("Actualizacion exitosa " + resulconsul);
            } else {
                System.out.println("No se pudo Actuaizar los datos ");
            }

        } catch (SQLException ex) {
        }

    }

    public void EliminarLibranza(int libranza) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "DELETE FROM libranza WHERE lbr_id_PRIMARY = "+libranza+";";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
           

            int resulconsul = stadatosActualiza.executeUpdate();
            if (resulconsul > 0) {
                System.out.println("Se elimino el registro exitosamente " + resulconsul);
            } else {
                System.out.println("No se pudo eliminar el registro");
            }

        } catch (SQLException ex) {
        }

    }
}
