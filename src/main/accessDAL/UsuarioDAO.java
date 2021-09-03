/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.accessDAL;

import main.modelBL.UsuarioModelBL;
import java.util.ArrayList;
import utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author COMPUMAX
 */
public class UsuarioDAO {

    private Connection conn = null;
//obtener todos los usuarios

    public ArrayList<UsuarioModelBL> obteneUsuarios() {
        ArrayList<UsuarioModelBL> usuarios = new ArrayList<UsuarioModelBL>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario;";
            Statement statdatosconsul = conn.createStatement();
            ResultSet resultado = statdatosconsul.executeQuery(sql);
            while (resultado.next()) {
                UsuarioModelBL usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getDouble(5), resultado.getString(6), resultado.getString(7));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
        }
        return usuarios;
    }

    //obtener un usuario espesifico por el alias
    public UsuarioModelBL obtenerusUsuario(String usrAlias) {
        UsuarioModelBL usuario = null;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario\n"
                    + "where usr_alias = ?;";
            PreparedStatement consultadatos = conn.prepareStatement(sql);
            consultadatos.setString(0, usrAlias);
            ResultSet resultado = consultadatos.executeQuery();
            usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getDouble(5), resultado.getString(6), resultado.getString(7));

        } catch (SQLException ex) {
        }
        return usuario;
    }

    //obtener usuarios por Nombre o apellido  la variable 1 para nombre o 2 para apellido
    public ArrayList<UsuarioModelBL> obtenerUsuarios(String consulta, int tipNoA) {
        ArrayList<UsuarioModelBL> usuarios = new ArrayList<UsuarioModelBL>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            if (tipNoA == 1) {
                //busqueda por nombre
                String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario\n"
                        + "where usuario.usr_nombres like \"%?%\"\n"
                        + ";";
                PreparedStatement consultadatos = conn.prepareStatement(sql);
                consultadatos.setString(0, consulta);
                ResultSet resultado = consultadatos.executeQuery();
                while (resultado.next()) {
                    UsuarioModelBL usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getDouble(5), resultado.getString(6), resultado.getString(7));
                    usuarios.add(usuario);
                }

            } else {
                //busqueda por apelldo
                String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario\n"
                        + "where usuario.usr_apellidos like \"%?%\"\n"
                        + ";";
                PreparedStatement consultadatos = conn.prepareStatement(sql);
                consultadatos.setString(0, consulta);
                ResultSet resultado = consultadatos.executeQuery();
                while (resultado.next()) {
                    UsuarioModelBL usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getDouble(5), resultado.getString(6), resultado.getString(7));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
        }
        return usuarios;
    }

    public void AgregarUsuario(UsuarioModelBL usuarioAgregar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "insert into usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) values (?, ?, ?, ?, ?, ?, ?); ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            stadatos.setString(0, usuarioAgregar.getUsrAlias());
            stadatos.setString(1, usuarioAgregar.getUsrNombres());
            stadatos.setString(2, usuarioAgregar.getUsrApellidos());
            stadatos.setString(3, usuarioAgregar.getUsrEmail());
            stadatos.setDouble(4, usuarioAgregar.getUsrCelular());
            stadatos.setString(5, usuarioAgregar.getUsrClave());
            stadatos.setString(6, usuarioAgregar.getUsrFechaNto());

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

    public void ActualizarUsuario(UsuarioModelBL usuarioActualizar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = " UPDATE usuario SET usr_alias = ?, usr_nombres = ?, usr_apellidos = ?, usr_email = ? , usr_celular = ?, usr_clave = ? ,usr_fecha_nto = ? WHERE usr_alias = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setString(0, usuarioActualizar.getUsrAlias());
            stadatosActualiza.setString(1, usuarioActualizar.getUsrNombres());
            stadatosActualiza.setString(2, usuarioActualizar.getUsrApellidos());
            stadatosActualiza.setString(3, usuarioActualizar.getUsrEmail());
            stadatosActualiza.setDouble(4, usuarioActualizar.getUsrCelular());
            stadatosActualiza.setString(5, usuarioActualizar.getUsrClave());
            stadatosActualiza.setString(6, usuarioActualizar.getUsrFechaNto());
            stadatosActualiza.setString(7, usuarioActualizar.getUsrAlias());

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

    public void EliminarUsuario(UsuarioModelBL usuarioeliminar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = " delete from usuario where usr_alias = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setString(0, usuarioeliminar.getUsrAlias());

            int resulconsul = stadatosActualiza.executeUpdate();
            if (resulconsul > 0) {
                System.out.println("Se elimino el registro exitosamente " + resulconsul);
            } else {
                System.out.println("No se pudo eliminar el registro");
            }

        } catch (SQLException ex) {
        }

    }
    
    public void AgregarGerman(String strAgregar){
        try {
            PreparedStatement prstmnt = conn.prepareStatement(strAgregar);
            prstmnt.execute();
            System.out.println("Usuario Agregado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}