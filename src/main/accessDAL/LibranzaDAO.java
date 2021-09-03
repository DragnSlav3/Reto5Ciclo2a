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
                    + "FROM libranza join campania on libranza.lbr_id = campania.cmp_id;";
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

    //obtener una libranza espesifica por la llave principal
    public Libranza obtenerusconsumo(int lbrIdPRIMARY) {
        Libranza libranzacredi = null;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT lbr_id_PRIMARY as \"LLAVE PRINCIPAL\", campania.cmp_descripcion AS \"DESCRIPCION DE CAMPAÑA\" ,lbr_empresa AS \"EMPRESAS\",lbr_meses_plazo AS \"MESES DE PLAZO\", lbr_tasa_interes AS \"TASA DE INTERES\",lbr_id AS \"ID CAMPAÑA\"\n"
                    + "FROM libranza join campania on libranza.lbr_id = campania.cmp_id where lbr_id_PRIMARY = ?;";
            PreparedStatement consultadatos = conn.prepareStatement(sql);
            consultadatos.setInt(0, lbrIdPRIMARY);
            ResultSet resultado = consultadatos.executeQuery();
              libranzacredi = new Libranza(resultado.getInt(1), resultado.getInt(6), resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getFloat(5));

        } catch (SQLException ex) {
        }
        return libranzacredi;
    }
/*
    public void AgregarLibranza(Libranza AgregarLibranza) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "insert into consumo(csm_id , csm_asesor, csm_cuotas, csm_tasa_interes) values (?,?,?,?); ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            stadatos.setInt(0, Agregarconsu.getCsmId());
            stadatos.setInt(1, Agregarconsu.getCsmAsesor());
            stadatos.setInt(2, Agregarconsu.getCsmCuotas());
            stadatos.setFloat(0, Agregarconsu.getCsmTasaInteres());

            int NumerosRowsInserted = stadatos.executeUpdate();
            //opcional
            if (NumerosRowsInserted > 0) {
                System.out.println("Insercion exitosa " + NumerosRowsInserted);
            } else {
                System.out.println("No se pudo Insertar los datos ");
            }
        } catch (SQLException ex) {

        }
    }*/

    public void ActualizarConsumo(Consumo Actualizarconsumo) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE consumo SET csm_idprimary = ? , csm_id = ?, csm_asesor = ?, csm_cuotas = ?, csm_tasa_interes = ? where csm_idprimary = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setInt(0, Actualizarconsumo.getCsmIdPrimary());
            stadatosActualiza.setInt(1, Actualizarconsumo.getCsmId());
            stadatosActualiza.setInt(2, Actualizarconsumo.getCsmAsesor());
            stadatosActualiza.setInt(3, Actualizarconsumo.getCsmCuotas());
            stadatosActualiza.setFloat(4, Actualizarconsumo.getCsmTasaInteres());
            stadatosActualiza.setInt(5, Actualizarconsumo.getCsmIdPrimary());

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

    public void EliminarConsumo(Consumo eliminarcons) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "DELETE FROM consumo WHERE csm_idprimary = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setInt(0, eliminarcons.getCsmIdPrimary());

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
