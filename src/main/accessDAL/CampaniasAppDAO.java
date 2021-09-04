/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.accessDAL;

import java.util.ArrayList;
import utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import main.modelBL.*;
/**
 *
 * @author COMPUMAX
 */
public class CampaniasAppDAO {

    private Connection conn = null;

    public ArrayList<CampaniaAplicada> obtenerCampaniasApli(String tipoconsulta) {
        ArrayList<CampaniaAplicada> campaniaAplicada = new ArrayList<CampaniaAplicada>();
        System.err.println("hola Camapñas");
        try {

            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "";
            if (tipoconsulta.equalsIgnoreCase("consumo")) {
                //la consuta para consumo

                sql = "select cpa_app_id as \"Crédito No.\", concat(usuario.usr_nombres, concat(\" \", usuario.usr_apellidos)) as \"Nombre Cliente\" , cmp_descripcion as \"Descripción Crédito\", concat(asesor_comercial.asr_nombres, concat(\" \", asesor_comercial.asr_apellidos)) as \"Nombre Asesor\", \n"
                        + "campania_aplicada.cpa_app_fecha as \"Fecha de Aplicacion a campaña\", cpa_campania , cpa_usuario\n"
                        + "from campania_aplicada, campania, usuario, consumo, asesor_comercial\n"
                        + "where campania_aplicada.cpa_usuario = usuario.usr_alias\n"
                        + "and campania_aplicada.cpa_campania = campania.cmp_id\n"
                        + "and campania_aplicada.cpa_campania = consumo.csm_id\n"
                        + "and consumo.csm_asesor = asesor_comercial.asr_id \n"
                        + "order by cpa_app_id ;";

                Statement statdatosconsul = conn.createStatement();
                ResultSet resultado = statdatosconsul.executeQuery(sql);
                while (resultado.next()) {
                    CampaniaAplicada camApp = new CampaniaAplicada(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(5), resultado.getInt(6), resultado.getString(4), resultado.getString(7));
                    campaniaAplicada.add(camApp);
                }

            } else if (tipoconsulta.equalsIgnoreCase("libranza")) {
                sql = "select cpa_app_id as \"Crédito No.\", concat(usuario.usr_nombres, concat(\" \", usuario.usr_apellidos)) as \"Nombre Cliente\" , cmp_descripcion as \"Descripción Crédito\", libranza.lbr_empresa AS \"Nombre de Empresa\",  campania_aplicada.cpa_app_fecha as \"Fecha de Aplicacion a campaña\",  cpa_campania, cpa_usuario\n"
                        + "from campania_aplicada,campania, usuario, libranza\n"
                        + "where campania_aplicada.cpa_usuario = usuario.usr_alias\n"
                        + "and campania_aplicada.cpa_campania = campania.cmp_id\n"
                        + "and campania_aplicada.cpa_campania = libranza.lbr_id\n"
                        + "order by cpa_app_id ;";

                Statement statdatosconsul = conn.createStatement();
                ResultSet resultado = statdatosconsul.executeQuery(sql);
                while (resultado.next()) {
                    CampaniaAplicada camApp = new CampaniaAplicada(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(5), resultado.getString(4), resultado.getInt(6), resultado.getString(7));
                    campaniaAplicada.add(camApp);
                }

            } else {
                System.out.println("holacmpania2");
                sql = "select cpa_app_id , concat(usuario.usr_nombres, concat(\" \", usuario.usr_apellidos)), cmp_descripcion , campania_aplicada.cpa_app_fecha ,\n" +
"                        cpa_campania, cpa_usuario\n" +
"                        from campania_aplicada\n" +
"                        join usuario on campania_aplicada.cpa_usuario = usuario.usr_alias\n" +
"                        join  campania on campania_aplicada.cpa_campania = campania.cmp_id ;\n" +
"                        ";
                Statement statdatosconsul = conn.createStatement();
                ResultSet resultado = statdatosconsul.executeQuery(sql);
                while (resultado.next()) {
                    CampaniaAplicada camApp = new CampaniaAplicada(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getInt(5), resultado.getString(6));
                    campaniaAplicada.add(camApp);
                }
            }

        } catch (SQLException ex) {

        }
        return campaniaAplicada;
    }

    public CampaniaAplicada obtenerCampaniasApli(int cpaAppid) {
        CampaniaAplicada camApp2 = null;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select cpa_app_id as \"Crédito No.\", concat(usuario.usr_nombres, concat(\" \", usuario.usr_apellidos)) as \"Nombre Cliente\" , cmp_descripcion as \"Descripción Crédito\", campania_aplicada.cpa_app_fecha as \"Fecha de Aplicacion a campaña\", cpa_usuario from campania_aplicada\n"
                    + "join usuario on campania_aplicada.cpa_usuario = usuario.usr_alias\n"
                    + "join  campania on campania_aplicada.cpa_campania = campania.cmp_id where cpa_app_id = ?;";
            PreparedStatement consultadatos = conn.prepareStatement(sql);
            consultadatos.setInt(0, cpaAppid);
            ResultSet resultado = consultadatos.executeQuery();
            camApp2 = new CampaniaAplicada(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getInt(5), resultado.getString(6));
            // cuando se imprima esto se debe evaluar si el id numerico de lacampañaes es menor a 5 para saber si es de consumo o sino es de libranza
        } catch (SQLException ex) {
        }

        return camApp2;
    }

    public void AgregarCampaniaApli(CampaniaAplicada CampaniaAgregar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "INSERT INTO campania_aplicada (cpa_usuario, cpa_campania, cpa_app_fecha) VALUES (?, ?, ?); ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            //stadatos.setInt(1, CampaniasAplicadas.getcpaAppId());
            stadatos.setString(0, CampaniaAgregar.getCpaUsuario());
            stadatos.setInt(1, CampaniaAgregar.getIdcpaCampania());
            stadatos.setString(2, CampaniaAgregar.getCpaAppFecha());
            int NumerosRowsInserted = stadatos.executeUpdate();
            if (NumerosRowsInserted > 0) {
                System.out.println("Insercion exitosa " + NumerosRowsInserted);
            } else {
                System.out.println("No se pudo Insertar los datos ");
            }
        } catch (SQLException ex) {

        }
    }

    public void ActualizarCampaniaApli(CampaniaAplicada CampaniaActualizar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "UPDATE campania_aplicada SET cpa_app_id = ?, cpa_usuario = ?, cpa_campania = ?,cpa_app_fecha = ?, where cpa_app_id = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setInt(0, CampaniaActualizar.getCpaAppId());
            stadatosActualiza.setString(1, CampaniaActualizar.getCpaUsuari_ID());
            stadatosActualiza.setInt(2, CampaniaActualizar.getIdcpaCampania());
            stadatosActualiza.setString(3, CampaniaActualizar.getCpaAppFecha());
            int resulconsul = stadatosActualiza.executeUpdate();
            if (resulconsul > 0) {
                System.out.println("Actualizacion exitosa " + resulconsul);
            } else {
                System.out.println("No se pudo Actuaizar los datos ");
            }

        } catch (SQLException ex) {
        }

    }

    public void EliminarCampaniaApli(int Campaniaeliminar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "DELETE FROM campania_aplicada WHERE campania_aplicada.cpa_app_id = "+Campaniaeliminar+";";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
           // stadatosActualiza.setInt(0, Campaniaeliminar);

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
