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
public class AsesorComercialDAO {
     private Connection conn = null;
//obtener todos los asesores

    public ArrayList<AsesorComercial> obteneAsesorComercial() {
        ArrayList<AsesorComercial> asesorcomercial = new ArrayList<AsesorComercial>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select asr_id As \"ID del asesor\",asr_nombres as \"Nombre\",asr_apellidos as \"Apellido\",asr_surcusal_bancaria as \"Sucursal\"  from asesor_comercial;";
            Statement statdatosconsul = conn.createStatement();
            ResultSet resultado = statdatosconsul.executeQuery(sql);
            while (resultado.next()) {
                AsesorComercial asesorC = new AsesorComercial(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                asesorcomercial.add(asesorC);
            }

        } catch (SQLException ex) {
        }
        return asesorcomercial;
    }

    //obtener un Asesor espesifico por el id
    public AsesorComercial obtenerAsesorComercial(int AsrId) {
        AsesorComercial asesorC = null;
        try {
            String sql = "select asr_id As \"ID del asesor\",asr_nombres as \"Nombre\",asr_apellidos as \"Apellido\",asr_surcusal_bancaria as \"Sucursal\" l where asr_id = ?;";
            PreparedStatement consultadatos = conn.prepareStatement(sql);
            consultadatos.setInt(0, AsrId);
            ResultSet resultado = consultadatos.executeQuery();
            
            asesorC = new AsesorComercial(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                
            
        } catch (SQLException ex) {
        }
        return asesorC;
    }

    //obtener usuarios por Nombre o apellido  la variable 1 para nombre 2 para apellido  y 3 paraa sucusal
    public ArrayList<AsesorComercial> obtenerAsesorComercials(String consulta, int tipNAoS) {
        ArrayList<AsesorComercial> asesoC = new ArrayList<AsesorComercial>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            if (tipNAoS == 1) {
                //busqueda por nombre
                String sql = "select asr_id As \"ID del asesor\",asr_nombres as \"Nombre\",asr_apellidos as \"Apellido\",asr_surcusal_bancaria as \"Sucursal\"  from asesor_comercial where asr_nombres like \"%?%\";";
                PreparedStatement consultadatos = conn.prepareStatement(sql);
                consultadatos.setString(0, consulta);
                ResultSet resultado = consultadatos.executeQuery();
                while (resultado.next()) {
                    AsesorComercial asesorcomer = new AsesorComercial(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                    asesoC.add(asesorcomer);
                }

            } else if (tipNAoS == 2){
                //busqueda por el apellido
     
                String sql = "select asr_id As \"ID del asesor\",asr_nombres as \"Nombre\",asr_apellidos as \"Apellido\",asr_surcusal_bancaria as \"Sucursal\"  from asesor_comercial where asr_apellidos like \"%?%\";";
                PreparedStatement consultadatos = conn.prepareStatement(sql);
                consultadatos.setString(0, consulta);
                ResultSet resultado = consultadatos.executeQuery();
                while (resultado.next()) {
                    AsesorComercial asesorcomer = new AsesorComercial(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                    asesoC.add(asesorcomer);
                }
            }else if (tipNAoS == 3){
                //busqueda por la sucursal
     
                String sql = "select asr_id As \"ID del asesor\",asr_nombres as \"Nombre\",asr_apellidos as \"Apellido\",asr_surcusal_bancaria as \"Sucursal\"  from asesor_comercial where asr_surcusal_bancaria like \"%?%\";";
                PreparedStatement consultadatos = conn.prepareStatement(sql);
                consultadatos.setString(0, consulta);
                ResultSet resultado = consultadatos.executeQuery();
                while (resultado.next()) {
                    AsesorComercial asesorcomer = new AsesorComercial(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                    asesoC.add(asesorcomer);
                }
            }
        } catch (SQLException ex) {
        }
        return asesoC;
    }

    public void AgregarAsesorcomercial(AsesorComercial AgregaraAsesorC) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "insert into asesor_comercial(asr_nombres, asr_apellidos, asr_surcusal_bancaria) values (?, ?, ?);";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            
            stadatos.setString(1, AgregaraAsesorC.getAsrNombres());
            stadatos.setString(2, AgregaraAsesorC.getAsrApellidos());
            stadatos.setString(3, AgregaraAsesorC.getAsrSucursalBancaria());
          

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

    public void ActualizarAsesorComercal(AsesorComercial ActualizarAsesor) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE asesor_comercial SET asr_id = ?, asr_nombres = ?, asr_apellidos = ?, asr_surcusal_bancaria= ? where asr_id = ?; ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            stadatos.setInt(1, ActualizarAsesor.getAsrId());
            stadatos.setString(2, ActualizarAsesor.getAsrNombres());
            stadatos.setString(3, ActualizarAsesor.getAsrApellidos());
            stadatos.setString(4, ActualizarAsesor.getAsrSucursalBancaria());
            stadatos.setInt(5, ActualizarAsesor.getAsrId());
         
            int resulconsul = stadatos.executeUpdate();
            //OPCIONAL 
            if (resulconsul > 0) {
                System.out.println("Actualizacion exitosa " + resulconsul);
            } else {
                System.out.println("No se pudo Actuaizar los datos ");
            }

        } catch (SQLException ex) {
        }

    }

    public void EliminaAsesorComercial(int eliminarAsesorcomercial) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = " delete from asesor_comercial WHERE 	asr_id = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setInt(1, eliminarAsesorcomercial);

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
