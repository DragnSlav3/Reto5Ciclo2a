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
import main.modelBL.*;

/**
 *
 * @author Gabriel
 */
public class CampaniaDAO {

    private Connection conn = null;

    public ArrayList<Campania> obtenerCampania() {
        ArrayList<Campania> campania = new ArrayList<Campania>();

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select cmp_id, cmp_descripcion from campania;";
            Statement statdatosconsul = conn.createStatement();
            ResultSet resultado = statdatosconsul.executeQuery(sql);
            System.out.println("HOLA");
            while (resultado.next()) {
                Campania camApp = new Campania(resultado.getInt(1), resultado.getString(2));
                campania.add(camApp);
            }
        } catch (SQLException ex) {
        }
        return campania;

    }

    public Campania obtenerCampaniaID(int cmpId) {
        Campania campania = null;

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select cmp_id, cmp_descripcion from campania where cmp_id = ?;";
            PreparedStatement consultadatos = conn.prepareStatement(sql);
            consultadatos.setInt(0, cmpId);
            ResultSet resultado = consultadatos.executeQuery();
            campania = new Campania(resultado.getInt(1), resultado.getString(2));

        } catch (SQLException ex) {
        }
        return campania;

    }
//para generar una lista si es de consumo o de limbransa

    public ArrayList<Campania> obtenerCampaniaDES(String cmpDescrpcion) {
        ArrayList<Campania> campania = new ArrayList<Campania>();

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            if (cmpDescrpcion.equalsIgnoreCase("consumo")) {

                String sql = "select cmp_id, cmp_descripcion from campania where cmp_descripcion not LIKE \"%libranza%\" ;";
                Statement statdatosconsul = conn.createStatement();
                ResultSet resultado = statdatosconsul.executeQuery(sql);
                while (resultado.next()) {
                    Campania camApp = new Campania(resultado.getInt(1), resultado.getString(2));
                    campania.add(camApp);
                }

            } else {

                String sql = "select cmp_id, cmp_descripcion from campania where cmp_descripcion LIKE \"%libranza%\" ;";
                Statement statdatosconsul = conn.createStatement();
                ResultSet resultado = statdatosconsul.executeQuery(sql);
                while (resultado.next()) {
                    Campania camApp = new Campania(resultado.getInt(1), resultado.getString(2));
                    campania.add(camApp);
                }

            }

        } catch (SQLException ex) {
        }
        return campania;

    }

    //para generar una lista si es de consumo o de limbransa con el nombre del asesor o de la empresa
    public ArrayList<Campania> obtenerCampaniaAS(String cmpDescrpcion, int tipo) {
        ArrayList<Campania> campania = new ArrayList<Campania>();

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            if (cmpDescrpcion.equalsIgnoreCase("consumo")) {

                String sql = "select cmp_id, cmp_descripcion, concat(asesor_comercial.asr_nombres, concat(\" \", asesor_comercial.asr_apellidos)) as \"Nombre Asesor\"  from campania , consumo, asesor_comercial\n"
                        + " where  campania.cmp_id = consumo.csm_id\n"
                        + " and consumo.csm_asesor = asesor_comercial.asr_id;";
                Statement statdatosconsul = conn.createStatement();
                ResultSet resultado = statdatosconsul.executeQuery(sql);
                while (resultado.next()) {
                    Campania camApp = new Campania(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                    campania.add(camApp);
                }

            } else {

                String sql = "select cmp_id, cmp_descripcion, libranza.lbr_empresa  from campania, libranza\n"
                        + " where  campania.cmp_id = libranza.lbr_id;";
                Statement statdatosconsul = conn.createStatement();
                ResultSet resultado = statdatosconsul.executeQuery(sql);
                while (resultado.next()) {
                    Campania camApp = new Campania(resultado.getString(3), resultado.getInt(1), resultado.getString(2));
                    campania.add(camApp);
                }

            }

        } catch (SQLException ex) {
        }
        return campania;

    }

    public void AgregarCampania(Campania CampaniaAgregar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "INSERT INTO campania(cmp_id, cmp_descripcion) VALUES (?, ?); ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            stadatos.setInt(0, CampaniaAgregar.getCmpId() );
            stadatos.setString(1, CampaniaAgregar.getCmpDescripcion());
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

     public void ActualizarCampania(Campania CampaniaActualizar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            
            
           String sql = "UPDATE campania SET cmp_id = ? , cmp_descripcion = ? WHERE cmp_id = ?;";
           PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
           stadatosActualiza.setInt(0,CampaniaActualizar.getCmpId());
           stadatosActualiza.setString(1,CampaniaActualizar.getCmpDescripcion());
           stadatosActualiza.setInt(2,CampaniaActualizar.getCmpId());
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
     
     public void EliminarCampania(int Campaniaeliminar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            System.out.println("eliminando");
            String sql = "DELETE FROM campania WHERE campania.cmp_id = "+ Campaniaeliminar+";";
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
